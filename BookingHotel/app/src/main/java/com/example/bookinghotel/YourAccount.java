package com.example.bookinghotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_users;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class YourAccount extends AppCompatActivity {
    ImageView icon_arrowback_accountFragment;
    EditText _130, _128, _132, _137;
    TextView _125;
    RadioButton _134, _135;
    Button _138, _139;
    Calendar calendar = Calendar.getInstance();

    public void findViewById() {
        icon_arrowback_accountFragment = findViewById(R.id._124);
        _130 = (EditText) findViewById(R.id._130);
        _125 = (TextView) findViewById(R.id._125);
        _128 = findViewById(R.id._128);
        _132 = findViewById(R.id._132);
        _137 = findViewById(R.id._137);
        _134 = findViewById(R.id._134);
        _135 = findViewById(R.id._135);
        _138 = findViewById(R.id._138);
        _139 = findViewById(R.id._139);
    }

    public void setOnClickListener() {
        SQLiteDatabase db1 = new DatabaseHandler(this).getWritableDatabase();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String Format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.TAIWAN);

                _130.setText(sdf.format(calendar.getTime()));
            }
        };
        _130.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(YourAccount.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        _139.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YourAccount.this, MainActivity.class);
                i.putExtra("fragment", 4);
                //finish();
                overridePendingTransition(0, 0);
                startActivity(i);
            }
        });
        _138.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
                String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                if (!_137.getText().toString().matches(phone)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid phone number!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else if (!_132.getText().toString().matches(email)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name_client", _128.getText().toString());
                    values.put("date_of_birth_client", _130.getText().toString());
                    values.put("email_client", _132.getText().toString());
                    values.put("phone_client", _137.getText().toString());
                    if (_134.isChecked()) {
                        values.put("gender_client", "Nam");
                    } else if (_135.isChecked()) {
                        values.put("gender_client", "Nu");
                    }
                    db1.update("users", values, "role_client = ?",
                            new String[]{"login"});

                    Intent i = new Intent(YourAccount.this, MainActivity.class);
                    i.putExtra("fragment", 4);
                    //finish();
                    overridePendingTransition(0, 0);
                    startActivity(i);

                    Toast toast = Toast.makeText(getApplicationContext(), "Account update successful!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

        icon_arrowback_accountFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YourAccount.this, MainActivity.class);
                i.putExtra("fragment", 4);
                //finish();
                overridePendingTransition(R.anim._1_slide_center_to_right, R.anim._1_slide_left_to_center);
                startActivity(i);
            }
        });
    }

    public void others() {
        SQLiteDatabase db = new DatabaseHandler(this).getWritableDatabase();
        String selectQuery = "SELECT name_client, date_of_birth_client" +
                ", email_client, phone_client, gender_client " +
                "FROM users WHERE role_client='login'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _128.setText(cursor.getString(0));
            _130.setText(cursor.getString(1));
            _132.setText(cursor.getString(2));
            _137.setText(cursor.getString(3));
            if (cursor.getString(4) == "Nam") {
                _135.setChecked(true);
            } else {
                _134.setChecked(true);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_account);
        findViewById();
        others();
        setOnClickListener();
    }
}