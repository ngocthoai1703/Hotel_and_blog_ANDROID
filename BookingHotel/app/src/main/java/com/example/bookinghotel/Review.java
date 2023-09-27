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

import com.example.bookinghotel.adapter.AdapterReview;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_comments;
import com.example.bookinghotel.database._5_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Review extends AppCompatActivity {
    RecyclerView recyclerView_review;
    ImageView _87;
    EditText _105;
    Button _196;
    String hotel_id;
    DatabaseHandler db1 = new DatabaseHandler(this);

    public void findViewById() {
        _87 = findViewById(R.id._87);
        _105 = findViewById(R.id._105);
        _196 = findViewById(R.id._196);
        recyclerView_review = findViewById(R.id.rvc_review);
    }

    public void setOnClickListener(SQLiteDatabase db) {
        _87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Review.this, DetailRoom.class);
                i.putExtra("hotel_id", hotel_id);
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
                startActivity(i);
            }
        });
        _196.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_105.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter your comment!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    String selectQuery = "SELECT user_id FROM users WHERE role_client='login';";
                    Cursor cursor = db.rawQuery(selectQuery, null);
                    if (cursor.moveToFirst()) {
                        //chuyển màn hình
                        //Intent i = new Intent(LogIn.this, MainActivity.class);
                        //startActivity(i);
                        String content_comments = _105.getText().toString();
                        Random generator = new Random();
                        String random_comment_id = String.valueOf(generator.nextInt());
                        db1.addComments(new _0_comments(cursor.getString(0), hotel_id, "", "", ""
                                , random_comment_id, "", "", content_comments));
                        Intent i = new Intent(Review.this, Review.class);
                        i.putExtra("hotel_id", hotel_id);
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(i);

                        Toast toast = Toast.makeText(getApplicationContext(), "Successful comment!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        });
    }

    public void others() {
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView_review.setLayoutManager(gridLayoutManager);
        AdapterReview adapter_review = new AdapterReview(getListReview());
        recyclerView_review.setAdapter(adapter_review);
    }

    private List<_5_table> getListReview() {
        List<_5_table> reviews = new ArrayList<>();
        Intent intent = getIntent();
        hotel_id = intent.getStringExtra("hotel_id");
        String selectQuery = "SELECT hotels.hotel_id, content_comments, avatar_client, name_client " +
                "FROM hotels, comments, users " +
                "WHERE hotels.hotel_id=comments.hotel_id " +
                "AND comments.user_id=users.user_id AND hotels.hotel_id=" + hotel_id;
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                reviews.add(new _5_table("", cursor.getString(0), "", "", "", "", "", "", cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return reviews;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        findViewById();
        setOnClickListener(db);
        others();
    }
}