package com.example.bookinghotel.fragment_room_history;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookinghotel.R;
import com.example.bookinghotel.adapter.AdapterRoomHistoryCancel;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._2_table;

import java.util.ArrayList;
import java.util.List;

public class CancelFragment extends Fragment {

    RecyclerView recyclerView_cancel;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView_cancel = (RecyclerView) view.findViewById(R.id.recyclerView_cancel);
        GridLayoutManager gridLayoutManager_cancel = new GridLayoutManager(getActivity(), 1);
        recyclerView_cancel.setLayoutManager(gridLayoutManager_cancel);

        AdapterRoomHistoryCancel adapterRoomHistory_cancel = new AdapterRoomHistoryCancel(getListRoom_Cancel());
        recyclerView_cancel.setAdapter(adapterRoomHistory_cancel);
    }

    private List<_2_table> getListRoom_Cancel() {
        List<_2_table> room_histories = new ArrayList<>();
        String user_id = "";
        SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();

        String select_client = "SELECT user_id " +
                "FROM users WHERE role_client='login'";
        Cursor cursor_client = db.rawQuery(select_client, null);
        if (cursor_client.moveToFirst()) {
            user_id = cursor_client.getString(0);
        }

        String selectQuery = "SELECT order_id, picture_hotel, name_hotel" +
                ", price_hotel_detail, date_start_order, date_end_order" +
                ", number_of_room_hotel_detail, country_name " +
                "FROM orders, users, hotel_details, hotels, countries " +
                "WHERE orders.user_id=users.user_id " +
                "AND orders.hotel_details_id=hotel_details.hotel_details_id " +
                "AND hotel_details.hotel_id=hotels.hotel_id " +
                "AND countries.country_id=hotels.country_id " +
                "AND status_order=2 AND users.user_id='" + user_id + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String date_start_order = cursor.getString(4).substring(0, 5);
                String date_end_order = cursor.getString(5).substring(0, 5);
                room_histories.add(new _2_table("", "", "", "", "", "", cursor.getString(0), "", cursor.getInt(1),cursor.getString(2), cursor.getInt(3), date_start_order + " - " + date_end_order, cursor.getString(6), cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return room_histories;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cancel, container, false);
    }
}