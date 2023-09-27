package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bookinghotel.adapter.AdapterSearching;
import com.example.bookinghotel.database.DatabaseHandler;

public class SeePictures extends AppCompatActivity {
    ImageView _87, _111, _112, _113;

    public void findViewById() {
        _87 = findViewById(R.id._87);
        _111 = findViewById(R.id._111);
        _112 = findViewById(R.id._112);
        _113 = findViewById(R.id._113);
    }

    public void setOnClickListener() {
        _87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SeePictures.this, DetailRoom.class);
                startActivity(i);
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        String hotel_details_id = intent.getStringExtra("hotel_details_id");

        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        String selectQuery = "SELECT picture_1_hotel_detail" +
                ", picture_2_hotel_detail, picture_3_hotel_detail " +
                "FROM hotel_details WHERE hotel_details_id='"+ hotel_details_id +"';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _111.setImageResource(cursor.getInt(0));
            _112.setImageResource(cursor.getInt(1));
            _113.setImageResource(cursor.getInt(2));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_pictures);
        findViewById();
        others();
        setOnClickListener();
    }
}