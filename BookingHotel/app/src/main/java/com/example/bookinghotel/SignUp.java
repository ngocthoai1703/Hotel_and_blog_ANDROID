package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_users;

import java.sql.Date;
import java.util.Random;

public class SignUp extends AppCompatActivity {
    TextView _123;
    Button _122;
    EditText _118, _119, _120, _121;
    DatabaseHandler db = new DatabaseHandler(this);

    public void findViewById() {
        _123 = findViewById(R.id._123);
        _122 = findViewById(R.id._122);
        _118 = findViewById(R.id._118);
        _119 = findViewById(R.id._119);
        _120 = findViewById(R.id._120);
        _121 = findViewById(R.id._121);
    }

    public void setOnClickListener() {
        _123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this, LogIn.class);
                startActivity(i);
            }
        });
        _122.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_118.getText().toString() != "" && _121.getText().toString() != "") {
                    Random generator = new Random();
                    String random = String.valueOf(generator.nextInt());
                    String user_name = _120.getText().toString();
                    String email = _119.getText().toString();
                    String pass_work = _118.getText().toString();
                    db.addUsers(new _0_users(random, "", "", "", ""
                            , "", "", "", user_name
                            , email, pass_work, ""
                            , "", "", R.drawable._avatar_empty
                            , "", "", ""));
                    Toast toast = Toast.makeText(getApplicationContext(), "Create account successfully", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    Intent i = new Intent(SignUp.this, LogIn.class);
                    startActivity(i);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Create account fail", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
    }

    public void others() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById();
        setOnClickListener();
        others();
    }
}