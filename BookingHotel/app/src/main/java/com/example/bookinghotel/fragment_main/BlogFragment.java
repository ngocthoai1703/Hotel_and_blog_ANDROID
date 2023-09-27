package com.example.bookinghotel.fragment_main;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bookinghotel.MainActivity;
import com.example.bookinghotel.Searching;
import com.example.bookinghotel.adapter.AdapterBlog;
import com.example.bookinghotel.R;
import com.example.bookinghotel.database.DatabaseHandler;
import com.example.bookinghotel.database._0_blogs;
import com.example.bookinghotel.database._4_table;

import java.util.ArrayList;
import java.util.List;

public class BlogFragment extends Fragment {
    RecyclerView recyclerView_listBlog;
    EditText _193;
    Button _210;
    String search = "";
//    LinearLayout linearLayout_adapter_list_blog;
//    CardView adapterLayout_list_blog;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //findViewById
        _193 = view.findViewById(R.id._193);
        _210 = view.findViewById(R.id._210);

        //------------

        //others
        recyclerView_listBlog = (RecyclerView) view.findViewById(R.id.rvc_list_blog);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView_listBlog.setLayoutManager(gridLayoutManager);

        AdapterBlog adapter_list_blog = new AdapterBlog(getListBlog());
        recyclerView_listBlog.setAdapter(adapter_list_blog);
        //------

        //setOnClickListener

        _210.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(_193.length() == 0) {
                    Toast toast = Toast.makeText(getContext(), "Please enter to searching!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    i.putExtra("search", _193.getText().toString());
                    i.putExtra("fragment", 3);

                    startActivity(i);
                    _193.setText("");
                }
            }
        });

        //------------------
    }

    private List<_4_table> getListBlog() {
        List<_4_table> blog_models = new ArrayList<>();
        String selectQuery;
        if(search.length() > 0) {
            selectQuery = "SELECT blog_id, picture_blog, title_blog, country_name" +
                    ", content_blog FROM blogs, countries " +
                    "WHERE blogs.country_id=countries.country_id " +
                    "AND (title_blog LIKE '%"+ search +"%' " +
                    "OR country_name LIKE '%"+ search +"%' " +
                    "OR content_blog LIKE '%" + search + "%')";
        } else {
            selectQuery = "SELECT blog_id, picture_blog, title_blog, country_name" +
                    ", content_blog FROM blogs, countries " +
                    "WHERE blogs.country_id=countries.country_id;";
        }
        SQLiteDatabase db = new DatabaseHandler(getContext()).getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                blog_models.add(new _4_table("", "", "", "", "", "", "", cursor.getString(0),cursor.getInt(1), cursor.getString(2), cursor.getString(3),cursor.getString(4)));
            } while (cursor.moveToNext());
        }
        return blog_models;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blog, container, false);
    }
}