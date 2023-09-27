package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.bookinghotel.database.DatabaseHandler;

public class BillBank extends AppCompatActivity {
    TextView _namehoteldetail, _phonepaymentdetail, _emailpaymentdetail
            , _textViewHotelname, _textViewCheckIn, _textViewCheckOut
            , _textViewRoomType, textViewPrice;
    ImageView _400;
    String order_id;
    Button _500;

    public void findViewById() {
        _namehoteldetail = findViewById(R.id._namehoteldetail);
        _phonepaymentdetail = findViewById(R.id._phonepaymentdetail);
        _emailpaymentdetail = findViewById(R.id._emailpaymentdetail);
        _textViewHotelname = findViewById(R.id._textViewHotelname);
        _textViewCheckIn = findViewById(R.id._textViewCheckIn);
        _textViewCheckOut = findViewById(R.id._textViewCheckOut);
        _textViewRoomType = findViewById(R.id._textViewRoomType);
        textViewPrice = findViewById(R.id.textViewPrice);
        _400 = findViewById(R.id._400);
        _500 = findViewById(R.id._500);
    }

    public void setOnClickListener() {
        _500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BillBank.this, RoomHistory.class);
                startActivity(i);
            }
        });
    }

    public void others() {
        Intent intent = getIntent();
        order_id = intent.getStringExtra("order_id");

        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        String selectQuery = "SELECT order_id, name_client, phone_client" +
                ", email_client, name_hotel, date_start_order, date_end_order" +
                ", number_of_room_hotel_detail, price_hotel_detail, image_payment FROM orders" +
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
            textViewPrice.setText("$" + cursor.getString(8));
            _400.setImageResource(cursor.getInt(9));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_bank);
        findViewById();
        others();
        setOnClickListener();
    }
}