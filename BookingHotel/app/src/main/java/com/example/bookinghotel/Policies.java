package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Policies extends AppCompatActivity {
    ImageView _87;

    public void findViewById() {
        _87 = findViewById(R.id._87);
    }

    public void setOnClickListener() {
        _87.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Policies.this, DetailRoom.class);
                //finish();
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
                startActivity(i);
            }
        });
    }

    public void others() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);
        findViewById();
        setOnClickListener();
        others();
    }
}