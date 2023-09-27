package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bookinghotel.adapter.MyRoomHistoryAdapter;
import com.google.android.material.tabs.TabLayout;

public class RoomHistory extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyRoomHistoryAdapter myRoomHistoryAdapter;
    ImageView _106;

    public void findViewById() {
        _106 = findViewById(R.id._106);
        tabLayout = findViewById(R.id.tablayout_roomHistory);
        viewPager2 = findViewById(R.id.viewPager_roomHistory);
    }

    public void setOnClickListener() {
        _106.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoomHistory.this, MainActivity.class);
                i.putExtra("fragment", 4);
                //finish();
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
                startActivity(i);
            }
        });
    }

    public void others() {
        myRoomHistoryAdapter = new MyRoomHistoryAdapter(this);
        viewPager2.setAdapter(myRoomHistoryAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_history);
        findViewById();
        setOnClickListener();
        others();
    }
}