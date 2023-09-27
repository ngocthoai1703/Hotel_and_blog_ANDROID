package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_users;

public class LogIn extends AppCompatActivity {
    EditText _81, _82;
    TextView _84;
    Button _83;

    public void findViewById() {
        _84 = findViewById(R.id._84);
        _83 = findViewById(R.id._83);
        _81 = findViewById(R.id._81);
        _82 = findViewById(R.id._82);
    }

    public void setOnClickListener() {
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        _83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _email_client = _81.getText().toString();
                String _password_client = _82.getText().toString();

                String selectQuery = "SELECT user_id FROM users WHERE email_client='" + _email_client + "' AND password_client='" + _password_client + "';";
                Cursor cursor = db.rawQuery(selectQuery, null);
                if (cursor.moveToFirst()) {
                    String user_id = cursor.getString(0);

                    ContentValues values = new ContentValues();
                    values.put("role_client", "login");
                    db.update("users", values, "user_id = ?",
                            new String[]{String.valueOf(user_id)});
                    Toast toast = Toast.makeText(getApplicationContext(), "Log in successfully!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    //chuyển màn hình
                    Intent i = new Intent(LogIn.this, MainActivity.class);
                    finish();
                    startActivity(i);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Incorrect account or password!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
        _84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LogIn.this, SignUp.class);
                startActivity(i);
            }
        });
    }

    public void others() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        findViewById();
        setOnClickListener();
        others();
    }
}