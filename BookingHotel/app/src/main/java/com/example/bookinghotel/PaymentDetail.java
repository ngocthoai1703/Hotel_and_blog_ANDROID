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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_orders;

import java.util.Random;

public class PaymentDetail extends AppCompatActivity {
    TextView _namehoteldetail, _phonepaymentdetail, _emailpaymentdetail
            , _textViewHotelname, _textViewCheckIn, _textViewCheckOut
            , _textViewRoomType, textViewTotalPrice;
    RadioButton radioButton_directpayment, radioButton_bank, radioButton_momo;
    Button buttonContinue;
    String order_id;

    public void findViewById() {
        _namehoteldetail = findViewById(R.id._namehoteldetail);
        _phonepaymentdetail = findViewById(R.id._phonepaymentdetail);
        _emailpaymentdetail = findViewById(R.id._emailpaymentdetail);
        _textViewHotelname = findViewById(R.id._textViewHotelname);
        _textViewCheckIn = findViewById(R.id._textViewCheckIn);
        _textViewCheckOut = findViewById(R.id._textViewCheckOut);
        _textViewRoomType = findViewById(R.id._textViewRoomType);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        radioButton_directpayment = findViewById(R.id.radioButton_directpayment);
        radioButton_bank = findViewById(R.id.radioButton_bank);
        radioButton_momo = findViewById(R.id.radioButton_momo);
        buttonContinue = findViewById(R.id.buttonContinue);

    }

    public void setOnClickListener() {
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton_directpayment.isChecked()){
                    ContentValues values = new ContentValues();
                    values.put("image_payment", R.drawable.qr_taiquay);
                    db.update("orders", values, "order_id = ?",
                            new String[]{order_id});
                } else if(radioButton_bank.isChecked()) {
                    ContentValues values = new ContentValues();
                    values.put("image_payment", R.drawable.qr_nganhang);
                    db.update("orders", values, "order_id = ?",
                            new String[]{order_id});
                } else if (radioButton_momo.isChecked()) {
                    ContentValues values = new ContentValues();
                    values.put("image_payment", R.drawable.qr_momo);
                    db.update("orders", values, "order_id = ?",
                            new String[]{order_id});
                }
                Intent i = new Intent(PaymentDetail.this, BillBank.class);
                i.putExtra("order_id", order_id);
                startActivity(i);

                Toast toast = Toast.makeText(getApplicationContext(), "Select payment method successfully!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");

        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        String selectQuery = "SELECT order_id, name_client, phone_client" +
                ", email_client, name_hotel, date_start_order, date_end_order" +
                ", number_of_room_hotel_detail, price_hotel_detail FROM orders" +
                ", users, hotel_details, hotels " +
                "WHERE orders.user_id=users.user_id " +
                "AND orders.hotel_details_id=hotel_details.hotel_details_id " +
                "AND hotel_details.hotel_id=hotels.hotel_id AND order_id='" + order_id + "';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            //cursor.getString(1)
            //cursor.getInt(5)
            _namehoteldetail.setText(cursor.getString(1));
            _phonepaymentdetail.setText(cursor.getString(2));
            _emailpaymentdetail.setText(cursor.getString(3));
            _textViewHotelname.setText(cursor.getString(4));
            _textViewCheckIn.setText(cursor.getString(5));
            _textViewCheckOut.setText(cursor.getString(6));
            _textViewRoomType.setText(cursor.getString(7));
            textViewTotalPrice.setText("$" + cursor.getString(8));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);
        findViewById();
        others();
        setOnClickListener();
    }
}