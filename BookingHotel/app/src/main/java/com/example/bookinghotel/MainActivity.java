package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.fragment_main.AccountFragment;
import com.example.bookinghotel.fragment_main.BlogFragment;
import com.example.bookinghotel.fragment_main.HomeFragment;
import com.example.bookinghotel.fragment_main.SavedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView  bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    BlogFragment blogFragment = new BlogFragment();
    AccountFragment accountFragment = new AccountFragment();
    SavedFragment savedFragment = new SavedFragment();

    public void findViewById() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
    }

    public void setOnClickListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId() == R.id.menu_icon_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.menu_icon_saved){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, savedFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.menu_icon_blog){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, blogFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.menu_icon_account){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, accountFragment).commit();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        int fragment = intent.getIntExtra("fragment", 0);
        if(fragment == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        } else if (fragment == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, savedFragment).commit();
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
        } else if (fragment == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, blogFragment).commit();
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
        } else if (fragment == 4){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, accountFragment).commit();
            bottomNavigationView.getMenu().getItem(3).setChecked(true);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        others();
        setOnClickListener();
    }
}