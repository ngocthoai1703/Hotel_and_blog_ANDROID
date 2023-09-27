package com.example.bookinghotel.fragment_main;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookinghotel.LogIn;
import com.example.bookinghotel.R;
import com.example.bookinghotel.RoomHistory;
import com.example.bookinghotel.YourAccount;
import com.example.bookinghotel.database.DatabaseHandler;

public class AccountFragment extends Fragment {
    TextView _185, _187, _190, _182;
    ImageView _181;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //findViewById
        _182 = view.findViewById(R.id._182);
        _181 = view.findViewById(R.id._181);
        _185 = (TextView) view.findViewById(R.id._185);
        _187 = (TextView) view.findViewById(R.id._187);
        _190 = (TextView) view.findViewById(R.id._190);
        //------------
        
        //setOnClickListener
        _185.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), YourAccount.class);
                startActivity(i);
            }
        });
        _187.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), RoomHistory.class);
                startActivity(i);
            }
        });
        _190.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LogIn.class);
                SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("role_client", "");
                db.update("users", values, "role_client = ?",
                        new String[]{"login"});
                startActivity(i);

                Toast toast = Toast.makeText(getContext(), "Successful logout!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        //------------------

        //others
        SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();
        String selectQuery = "SELECT avatar_client, name_client FROM users WHERE role_client='login'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            _181.setImageResource(cursor.getInt(0));
            _182.setText(cursor.getString(1));
        }
        //------
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }
}