package com.example.bookinghotel.fragment_main;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookinghotel.R;
import com.example.bookinghotel.Searching;
import com.example.bookinghotel.adapter.AdapterBlog;
import com.example.bookinghotel.adapter.AdapterHotel;
import com.example.bookinghotel.adapter.AdapterSearching;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._1_table;
import com.example.bookinghotel.database._4_table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SavedFragment extends Fragment {
    Button button;
    RecyclerView recyclerview1;
    String user_id = "";
    ImageView _112;
    TextView _194, _75;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //findViewById
        button = (Button) view.findViewById(R.id._195);
        _112 = view.findViewById(R.id._112);
        _194 = view.findViewById(R.id._194);
        _75 = view.findViewById(R.id._75);
        recyclerview1 = (RecyclerView) view.findViewById(R.id.recyclerview1);
        //------------

        //others

        SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();
        String selectQuery_cline = "SELECT user_id " +
                "FROM users WHERE role_client='login'";
        Cursor cursor_client = db.rawQuery(selectQuery_cline, null);
        if (cursor_client.moveToFirst()) {
            user_id = cursor_client.getString(0);
        }
        //
        String selectQuery2 = "SELECT * " +
                "FROM hotels, likes " +
                "WHERE hotels.hotel_id=likes.hotel_id " +
                "AND user_id='" + user_id + "'";
        Cursor cursor_client2 = db.rawQuery(selectQuery2, null);
        if (cursor_client2.moveToFirst()) {
            _112.setVisibility(View.INVISIBLE);
            _194.setVisibility(View.INVISIBLE);
            _75.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
            recyclerview1.setLayoutManager(gridLayoutManager);

            AdapterSearching adapter_list_search = new AdapterSearching(getListSearch(db));
            recyclerview1.setAdapter(adapter_list_search);
        }


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
//        recyclerview1.setLayoutManager(gridLayoutManager);
//
//        AdapterSearching adapter_list_search = new AdapterSearching(getListSearch(db));
//        recyclerview1.setAdapter(adapter_list_search);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
//        recyclerview1.setLayoutManager(gridLayoutManager);
//
//        AdapterSearching adapter_list_search = new AdapterSearching(getListSearch(db));
//        recyclerview1.setAdapter(adapter_list_search);
        //------

        //setOnClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Searching.class);
                Calendar calendar = Calendar.getInstance();
                String Format = "dd/MM/yyyy";
                SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
                i.putExtra("date_from", date_from.format(calendar.getTime()));
                i.putExtra("date_to", date_from.format(calendar.getTime()));
                i.putExtra("country_name", "");
                i.putExtra("search", "");
                startActivity(i);
            }
        });
        //------------------
    }

    private List<_1_table> getListSearch(SQLiteDatabase db) {
        List<_1_table> search_models = new ArrayList<>();
        String number_of_day_other;

        Calendar calendar = Calendar.getInstance();
        String Format = "dd/MM/yyyy";
        SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
        number_of_day_other = "From " + date_from.format(calendar.getTime())
                + " to " + date_from.format(calendar.getTime());

        String selectQuery = "SELECT hotels.hotel_id, name_hotel, description_hotel" +
                ", picture_hotel, address_hotel, star_hotel" +
                ", likes.like_id, country_name " +
                "FROM hotels, countries, likes " +
                "WHERE hotels.country_id=countries.country_id " +
                "AND hotels.hotel_id=likes.hotel_id " +
                "AND user_id='" + user_id + "';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int save_hotel;
                String selectQuery1 = "SELECT * " +
                        "FROM hotels, likes " +
                        "WHERE hotels.hotel_id=likes.hotel_id " +
                        "AND hotels.hotel_id='" + cursor.getString(0) + "' " +
                        "AND user_id='" + user_id + "'";
                Cursor cursor_client1 = db.rawQuery(selectQuery1, null);
                if (cursor_client1.moveToFirst()) {
                    save_hotel = R.drawable.icon_save_hotel;
                } else {
                    save_hotel = R.drawable.icon_unsave_hotel;
                }
                search_models.add(new _1_table(user_id, cursor.getString(0), "", "", "", "", "", "", cursor.getInt(3), cursor.getString(1), cursor.getInt(5), 0, number_of_day_other, cursor.getString(7), save_hotel));
            } while (cursor.moveToNext());
        }
        return search_models;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false);
    }
}