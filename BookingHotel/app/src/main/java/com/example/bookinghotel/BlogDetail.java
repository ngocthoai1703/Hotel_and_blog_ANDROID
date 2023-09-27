package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._4_table;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BlogDetail extends AppCompatActivity {
    TextView _13, _9, _11;
    ImageView _7, _1;
    Button _14;
    String country_name;

    public void findViewById() {
        _14 = findViewById(R.id._14);
        _1 = findViewById(R.id._1);
        _13 = findViewById(R.id._13);
        _9 = findViewById(R.id._9);
        _11 = findViewById(R.id._11);
        _7 = findViewById(R.id._7);
    }

    public void setOnClickListener() {
        _14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                Intent i = new Intent(BlogDetail.this, Searching.class);
                String Format = "dd/MM/yyyy";
                SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
                i.putExtra("country_name", country_name);
                i.putExtra("date_from", date_from.format(calendar.getTime()));
                i.putExtra("date_to", date_from.format(calendar.getTime()));
                i.putExtra("search", "");
                startActivity(i);
            }
        });
        _1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BlogDetail.this, MainActivity.class);
                i.putExtra("fragment", 3);
                //finish();
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
                startActivity(i);
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        String blog_id = intent.getStringExtra("blog_id");
        String selectQuery = "SELECT blog_id, picture_blog" +
                ", title_blog, country_name, content_blog " +
                "FROM blogs, countries WHERE blogs.country_id=countries.country_id " +
                "AND blog_id='" + blog_id + "'";
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _9.setText(cursor.getString(2));
            _11.setText(cursor.getString(3));
            country_name = cursor.getString(3);
            _13.setText(cursor.getString(4));
            _7.setImageResource(cursor.getInt(1));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);
        findViewById();
        others();
        setOnClickListener();
    }
}