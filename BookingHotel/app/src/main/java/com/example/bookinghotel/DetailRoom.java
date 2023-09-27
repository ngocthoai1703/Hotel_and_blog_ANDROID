package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.bookinghotel.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class DetailRoom extends AppCompatActivity {
    ViewFlipper viewFlipper;
    TextView _70, _18, _19, _22, _38, _44, _49;
    ImageView _51;
    Button _72;
    String hotel_id, number_of_day_other;

    public void findViewById() {
        _70 = findViewById(R.id._70);
        _51 = findViewById(R.id._51);
        _72 = findViewById(R.id._72);
        _18 = findViewById(R.id._18);
        _19 = findViewById(R.id._19);
        _22 = findViewById(R.id._22);
        _38 = findViewById(R.id._38);
        _44 = findViewById(R.id._44);
        _49 = findViewById(R.id._49);
        viewFlipper = findViewById(R.id._17);
    }

    public void setOnClickListener() {
        _70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailRoom.this, Policies.class);
                startActivity(i);
            }
        });
        _51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailRoom.this, Review.class);
                i.putExtra("hotel_id", hotel_id);
                overridePendingTransition(R.anim._2_slide_center_to_left, R.anim._2_slide_right_to_center);
                startActivity(i);
            }
        });
        _72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailRoom.this, SelectDetailRoom.class);
                i.putExtra("hotel_id", hotel_id);
                i.putExtra("number_of_day_other", number_of_day_other);
                startActivity(i);
            }
        });
    }

    public void others(SQLiteDatabase db, Intent intent) {
        hotel_id = intent.getStringExtra("hotel_id");
        String selectQuery = "SELECT hotels.hotel_id, name_hotel, description_hotel" +
                ", address_hotel FROM hotels " +
                "WHERE hotels.hotel_id='" + hotel_id + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _18.setText(cursor.getString(1));
            _19.setText(cursor.getString(2));
            _22.setText(cursor.getString(3));
        }
        number_of_day_other = intent.getStringExtra("number_of_day_other");
        String CheckIn = number_of_day_other.substring(5, 15);
        String Checkout = number_of_day_other.substring(19);
        _38.setText(CheckIn);
        _44.setText(Checkout);

        String selectQuery1 = "SELECT COUNT(*) AS count FROM hotels, comments " +
                "WHERE hotels.hotel_id=comments.hotel_id " +
                "AND hotels.hotel_id='"+hotel_id+"';";
        Cursor cursor1 = db.rawQuery(selectQuery1, null);
        if (cursor1.moveToFirst()) {
            _49.setText(cursor1.getString(0));
        }

    }

    private void ActionViewFlipper() {
        List<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://i.pinimg.com/originals/b1/62/8e/b1628edd3f876fbfa5aa808b6676e381.jpg");
        mangquangcao.add("https://i.pinimg.com/originals/a2/29/55/a2295520e545c581f122c9bd5b0a77db.jpg");
        mangquangcao.add("https://i.pinimg.com/originals/b1/62/8e/b1628edd3f876fbfa5aa808b6676e381.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim._1_slide_left_to_center);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim._1_slide_center_to_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);
        Intent intent = getIntent();

        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        findViewById();
        others(db, intent);
        setOnClickListener();
        ActionViewFlipper();
    }
}