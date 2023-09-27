package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.bookinghotel.adapter.AdapterReview;
import com.example.bookinghotel.adapter.AdapterSelectRoom;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_comments;
import com.example.bookinghotel.database._5_table;
import com.example.bookinghotel.database._6_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectDetailRoom extends AppCompatActivity {
    RecyclerView rcv_selectRoom;

    public void findViewById() {
        rcv_selectRoom = findViewById(R.id.rcv_selectRoom);
    }

    public void setOnClickListener() {

    }

    public void others() {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rcv_selectRoom.setLayoutManager(gridLayoutManager);
        AdapterSelectRoom adapter_review = new AdapterSelectRoom(getListReview());
        rcv_selectRoom.setAdapter(adapter_review);
    }

    private List<_6_table> getListReview() {
        Intent intent = getIntent();
        List<_6_table> hotel_details = new ArrayList<>();
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();

        String hotel_id = intent.getStringExtra("hotel_id");
        String number_of_day_other = intent.getStringExtra("number_of_day_other");

        String selectQuery = "SELECT hotel_details_id, hotel_id" +
                ", number_of_room_hotel_detail, size_hotel_detail" +
                ", description_hotel_detail, price_hotel_detail" +
                ", status_hotel_detail, picture_1_hotel_detail" +
                ", picture_2_hotel_detail, picture_3_hotel_detail " +
                "FROM hotel_details WHERE hotel_id='"+ hotel_id +"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                hotel_details.add(new _6_table("", cursor.getString(1), "", cursor.getString(0), "", "", "", "",cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getInt(5), number_of_day_other));
            } while (cursor.moveToNext());
        }
        return hotel_details;

//        Intent intent = getIntent();
//        hotel_id = intent.getStringExtra("hotel_id");
//        String selectQuery = "SELECT hotels.hotel_id, content_comments, avatar_client, name_client " +
//                "FROM hotels, comments, users " +
//                "WHERE hotels.hotel_id=comments.hotel_id " +
//                "AND comments.user_id=users.user_id AND hotels.hotel_id=" + hotel_id;
//        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                reviews.add(new _5_table("", cursor.getString(0), "", "", "", "", "", "", cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
//            } while (cursor.moveToNext());
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_detail_room);

        findViewById();
        setOnClickListener();
        others();

    }
}