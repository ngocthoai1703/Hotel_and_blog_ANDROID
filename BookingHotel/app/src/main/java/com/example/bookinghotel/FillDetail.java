package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
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
import com.example.bookinghotel.database._0_orders;

import java.util.Random;

public class FillDetail extends AppCompatActivity {
    TextView _namehoteldetail, _checkinhoteldetail, _checkouthoteldetail, _roomtypehoteldetail, _pricehoteldetail;
    String hotel_details_id, number_of_day_other, CheckIn, Checkout, user_id;
    EditText _editTextFullName, _editTextPhone, _editTextEmail;
    String name_client, phone_client, email_client;
    Button _300;

    public void findViewById() {
        _namehoteldetail = findViewById(R.id._namehoteldetail);
        _checkinhoteldetail = findViewById(R.id._phonepaymentdetail);
        _checkouthoteldetail = findViewById(R.id._emailpaymentdetail);
        _roomtypehoteldetail = findViewById(R.id._roomtypehoteldetail);
        _pricehoteldetail = findViewById(R.id._pricehoteldetail);
        _editTextFullName = findViewById(R.id._editTextFullName);
        _editTextPhone = findViewById(R.id._editTextPhone);
        _editTextEmail = findViewById(R.id._editTextEmail);
        _300 = findViewById(R.id._300);
    }

    public void setOnClickListener() {
        DatabaseHandler db1 = new DatabaseHandler(this);
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        _300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_editTextFullName.getText().toString() != name_client
                || _editTextPhone.getText().toString() != phone_client
                || _editTextEmail.getText().toString() != email_client) {
                    ContentValues values = new ContentValues();
                    values.put("name_client", _editTextFullName.getText().toString());
                    values.put("email_client", _editTextEmail.getText().toString());
                    values.put("phone_client", _editTextPhone.getText().toString());
                    db.update("users", values, "role_client = ?",
                            new String[]{"login"});
                }
                Random generator = new Random();
                String random = String.valueOf(generator.nextInt());
                db1.addOrders(new _0_orders(user_id, "", ""
                        , hotel_details_id, ""
                        , "", random, ""
                        , CheckIn
                        , Checkout, 0, 0));

                Intent i = new Intent(FillDetail.this, PaymentDetail.class);
                i.putExtra("order_id", random);
                startActivity(i);

                Toast toast = Toast.makeText(getApplicationContext(), "Order Success!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();

        hotel_details_id = intent.getStringExtra("hotel_details_id");
        number_of_day_other = intent.getStringExtra("number_of_day_other");

        CheckIn = number_of_day_other.substring(5, 15);
        Checkout = number_of_day_other.substring(19);

        String selectQuery = "SELECT name_hotel, hotel_details_id, hotels.hotel_id" +
                ", number_of_room_hotel_detail, size_hotel_detail" +
                ", description_hotel_detail, price_hotel_detail " +
                "FROM hotels, hotel_details WHERE hotels.hotel_id=hotel_details.hotel_id AND hotel_details_id='"+ hotel_details_id +"';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _namehoteldetail.setText(cursor.getString(0));
            _checkinhoteldetail.setText(CheckIn);
            _checkouthoteldetail.setText(Checkout);
            _roomtypehoteldetail.setText(cursor.getString(3));
            _pricehoteldetail.setText("$" + cursor.getString(6));
        }

        String selectQuery1 = "SELECT name_client, phone_client, email_client, user_id " +
                "FROM users WHERE role_client='login'";
        Cursor cursor1 = db.rawQuery(selectQuery1, null);
        if (cursor1.moveToFirst()) {
            //cursor.getString(1)
            //cursor.getInt(5)
            _editTextFullName.setText(cursor1.getString(0));
            name_client = cursor1.getString(0);
            _editTextPhone.setText(cursor1.getString(1));
            phone_client = cursor1.getString(1);
            _editTextEmail.setText(cursor1.getString(2));
            email_client = cursor1.getString(2);
            user_id = cursor1.getString(3);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_detail);
        findViewById();
        others();
        setOnClickListener();
    }
}