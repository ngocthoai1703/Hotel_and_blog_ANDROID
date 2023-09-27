package com.example.bookinghotel.fragment_main;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bookinghotel.R;
import com.example.bookinghotel.Searching;
import com.example.bookinghotel.YourAccount;
import com.example.bookinghotel.adapter.AdapterHotel;
import com.example.bookinghotel.adapter.AdapterSearching;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_users;
import com.example.bookinghotel.database._1_table;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {
    RecyclerView _200;
    Button _195;
    EditText editTextTextPersonName4, editTextTextPersonName3, editTextTextPersonName_5;
    ImageView image5;
    public static String reverseWordInMyString(String str)
    {
        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            String reverseWord = "";
            for (int j = word.length()-1; j >= 0; j--)
            {
                reverseWord = reverseWord + word.charAt(j);
            }
            reversedString = reversedString + reverseWord + " ";
        }
        return reversedString;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();

        //findViewById
        image5 = view.findViewById(R.id.image5);
        _195 = (Button) view.findViewById(R.id._195);
        _200 = (RecyclerView) view.findViewById(R.id.rcv_tophotel);
        Calendar calendar = Calendar.getInstance();
        editTextTextPersonName4 = (EditText) view.findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName3 = (EditText) view.findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName_5 = (EditText) view.findViewById(R.id.editTextTextPersonName_5);
        //------------

        //others
        String selectQuery = "SELECT avatar_client FROM users WHERE role_client='login'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            image5.setImageResource(cursor.getInt(0));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        _200.setLayoutManager(linearLayoutManager);

        AdapterHotel adapterHotel = new AdapterHotel(getListSearch(db));
        _200.setAdapter(adapterHotel);

        DatePickerDialog.OnDateSetListener date_from = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String Format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.TAIWAN);

                editTextTextPersonName4.setText(sdf.format(calendar.getTime()));
            }
        };
        DatePickerDialog.OnDateSetListener date_to = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String Format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.TAIWAN);

                editTextTextPersonName_5.setText(sdf.format(calendar.getTime()));
            }
        };
        //------------------

        //setOnClickListener
        editTextTextPersonName4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date_from, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        editTextTextPersonName_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), date_to, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        _195.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Searching.class);
                Calendar calendar = Calendar.getInstance();
                String Format1 = "dd/MM/yyyy";
                SimpleDateFormat check_date = new SimpleDateFormat(Format1, Locale.TAIWAN);

                String editTextTextPersonName4_revert = reverseWordInMyString(editTextTextPersonName4.getText().toString());
                String editTextTextPersonName_5_revert = reverseWordInMyString(editTextTextPersonName_5.getText().toString());
                String current_day_revert = reverseWordInMyString(check_date.format(calendar.getTime()));

                if(editTextTextPersonName3.length() == 0
                        && editTextTextPersonName4.length() == 0
                        && editTextTextPersonName_5.length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Please enter the information you are looking for!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    i.putExtra("country_name", editTextTextPersonName3.getText().toString());
                    editTextTextPersonName3.setText("");

                    if(editTextTextPersonName4.length() == 0 && editTextTextPersonName_5.length() == 0) {
                        String Format = "dd/MM/yyyy";
                        SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
                        i.putExtra("date_from", date_from.format(calendar.getTime()));
                        i.putExtra("date_to", date_from.format(calendar.getTime()));
                        i.putExtra("search", "");

                        startActivity(i);
                        editTextTextPersonName3.setText("");
                        editTextTextPersonName4.setText("");
                        editTextTextPersonName_5.setText("");
                    } else if (editTextTextPersonName4.length() > 0 && editTextTextPersonName_5.length() == 0){
                        if(editTextTextPersonName4_revert.compareTo(current_day_revert) < 0) {
                            Toast toast = Toast.makeText(getContext(), "Start date cannot be less than current date!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return;
                        }
                        i.putExtra("date_from", editTextTextPersonName4.getText().toString());
                        i.putExtra("date_to", editTextTextPersonName4.getText().toString());
                        i.putExtra("search", "");
                        startActivity(i);
                        editTextTextPersonName3.setText("");
                        editTextTextPersonName4.setText("");
                        editTextTextPersonName_5.setText("");
                    } else if (editTextTextPersonName4.length() == 0 && editTextTextPersonName_5.length() > 0){
                        if(editTextTextPersonName_5_revert.compareTo(current_day_revert) < 0) {
                            Toast toast = Toast.makeText(getContext(), "End date cannot be less than the current date!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return;
                        }
                        i.putExtra("date_from", editTextTextPersonName_5.getText().toString());
                        i.putExtra("date_to", editTextTextPersonName_5.getText().toString());
                        i.putExtra("search", "");
                        startActivity(i);
                        editTextTextPersonName3.setText("");
                        editTextTextPersonName4.setText("");
                        editTextTextPersonName_5.setText("");
                    } else if (editTextTextPersonName4.length() > 0 && editTextTextPersonName_5.length() > 0){
                        if(editTextTextPersonName4_revert.compareTo(current_day_revert) < 0) {
                            Toast toast = Toast.makeText(getContext(), "Start date cannot be less than current date!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return;
                        }
                        if(editTextTextPersonName_5_revert.compareTo(current_day_revert) < 0) {
                            Toast toast = Toast.makeText(getContext(), "End date cannot be less than the current date!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return;
                        }
                        if(editTextTextPersonName_5_revert.compareTo(editTextTextPersonName4_revert) < 0) {
                            Toast toast = Toast.makeText(getContext(), "End date cannot be less than start date!", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return;
                        }
                        i.putExtra("date_from", editTextTextPersonName4.getText().toString());
                        i.putExtra("date_to", editTextTextPersonName_5.getText().toString());
                        i.putExtra("search", "");
                        startActivity(i);
                        editTextTextPersonName3.setText("");
                        editTextTextPersonName4.setText("");
                        editTextTextPersonName_5.setText("");
                    }
                }
            }
        });
        //------------------
    }

    private List<_1_table> getListSearch(SQLiteDatabase db) {
        List<_1_table> search_models = new ArrayList<>();
        String selectQuery = "SELECT hotel_id, name_hotel, description_hotel" +
                ", picture_hotel, address_hotel, star_hotel" +
                ", like_id, country_name " +
                "FROM hotels, countries " +
                "WHERE hotels.country_id=countries.country_id ORDER BY star_hotel DESC LIMIT 5;";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                search_models.add(new _1_table("", cursor.getString(0), "", "", "", "", "", "", cursor.getInt(3), cursor.getString(1), cursor.getInt(5), 0, "", cursor.getString(7), 0));
            } while (cursor.moveToNext());
        }
        return search_models;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}