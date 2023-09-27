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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bookinghotel.adapter.AdapterSearching;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._1_table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Searching extends AppCompatActivity {
    RecyclerView _110;
    ImageView _107;
    EditText _109;
    Button _197;
    String country_name, date_from, date_to, search;
    String user_id;


    public void findViewById() {
        _110 = findViewById(R.id._110);
        _107 = findViewById(R.id._107);
        _109 = findViewById(R.id._109);
        _197 = findViewById(R.id._197);
    }

    public void setOnClickListener() {
        _107.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Searching.this, MainActivity.class);
                i.putExtra("fragment", 1);
                startActivity(i);
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
            }
        });
        _197.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_109.length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter to searching!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                    toast.show();
                } else {
                    Intent i = new Intent(Searching.this, Searching.class);
                    i.putExtra("country_name", country_name);
                    i.putExtra("date_from", date_from);
                    i.putExtra("date_to", date_to);
                    i.putExtra("search", _109.getText().toString());
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(i);
                    _109.setText("");
                }
            }
        });
    }

    public void others(SQLiteDatabase db) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        _110.setLayoutManager(gridLayoutManager);

        AdapterSearching adapter_list_search = new AdapterSearching(getListSearch(db));
        _110.setAdapter(adapter_list_search);
    }

    private List<_1_table> getListSearch(SQLiteDatabase db) {
        List<_1_table> search_models = new ArrayList<>();
        Intent intent = getIntent();
        String changeSave;
        country_name = intent.getStringExtra("country_name");
        date_from = intent.getStringExtra("date_from");
        date_to = intent.getStringExtra("date_to");
        search = intent.getStringExtra("search");

        String number_of_day_other = "From " + date_from + " to " + date_to;

        String selectQuery_cline = "SELECT user_id " +
                "FROM users WHERE role_client='login'";
        Cursor cursor_client = db.rawQuery(selectQuery_cline, null);
        if (cursor_client.moveToFirst()) {
            user_id = cursor_client.getString(0);
        }

        String selectQuery = "";
        if(search.length() != 0) {
            selectQuery = "SELECT hotel_id, name_hotel, description_hotel" +
                    ", picture_hotel, address_hotel, star_hotel" +
                    ", like_id, country_name " +
                    "FROM hotels, countries " +
                    "WHERE hotels.country_id=countries.country_id " +
                    "AND (country_name LIKE '%" + country_name + search + "%' " +
                    "OR name_hotel LIKE '%" + search + "%' " +
                    "OR description_hotel LIKE '%" + search + "%' " +
                    "OR address_hotel LIKE '%" + search + "%');";
        } else {
            selectQuery = "SELECT hotel_id, name_hotel, description_hotel" +
                    ", picture_hotel, address_hotel, star_hotel" +
                    ", like_id, country_name " +
                    "FROM hotels, countries " +
                    "WHERE hotels.country_id=countries.country_id " +
                    "AND country_name LIKE '%" + country_name + "%';";
        }
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();

        findViewById();
        setOnClickListener();
        others(db);
    }
}