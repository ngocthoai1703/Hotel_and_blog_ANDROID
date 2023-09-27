package com.example.bookinghotel.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Gravity;
import android.widget.Toast;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//DatabaseHandler db = new DatabaseHandler(this);
//db.addContact(new Contact(Name, Phone));

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context) {
        super(context, "booking_hotel", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(user_id TEXT PRIMARY KEY,name_client TEXT,email_client TEXT,password_client TEXT,date_of_birth_client TEXT, gender_client TEXT, phone_client TEXT, avatar_client INTEGER, facebook_client TEXT, instagram_client TEXT, role_client TEXT);");
        db.execSQL("CREATE TABLE hotels(hotel_id TEXT PRIMARY KEY,name_hotel TEXT, description_hotel TEXT, picture_hotel INTEGER, country_id TEXT, address_hotel TEXT, star_hotel INTEGER, like_id TEXT);");
        db.execSQL("CREATE TABLE likes(like_id TEXT PRIMARY KEY,hotel_id TEXT,user_id TEXT);");
        db.execSQL("CREATE TABLE hotel_details(hotel_details_id TEXT PRIMARY KEY,hotel_id TEXT,number_of_room_hotel_detail TEXT, size_hotel_detail TEXT, description_hotel_detail TEXT, price_hotel_detail INTEGER, status_hotel_detail INTEGER, picture_1_hotel_detail INTEGER, picture_2_hotel_detail INTEGER, picture_3_hotel_detail INTEGER);");
        db.execSQL("CREATE TABLE comments(comments_id TEXT PRIMARY KEY,hotel_id TEXT,user_id TEXT, content_comments TEXT);");
        db.execSQL("CREATE TABLE orders(order_id TEXT PRIMARY KEY,user_id TEXT, hotel_id TEXT, hotel_details_id TEXT, date_start_order TEXT, date_end_order TEXT, image_payment INTEGER, status_order INTEGER);");
        db.execSQL("CREATE TABLE blogs(blog_id TEXT PRIMARY KEY,title_blog TEXT, content_blog TEXT, picture_blog INTEGER, country_id TEXT);");
        db.execSQL("CREATE TABLE countries(country_id TEXT PRIMARY KEY,country_name TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS hotels");
        db.execSQL("DROP TABLE IF EXISTS likes");
        db.execSQL("DROP TABLE IF EXISTS hotel_details");
        db.execSQL("DROP TABLE IF EXISTS comments");
        db.execSQL("DROP TABLE IF EXISTS orders");
        db.execSQL("DROP TABLE IF EXISTS blogs");
        db.execSQL("DROP TABLE IF EXISTS countries");
        onCreate(db);
    }
    public void addBlogs(_0_blogs blog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("blog_id", blog.blog_id);
        values.put("title_blog", blog.title_blog);
        values.put("content_blog", blog.content_blog);
        values.put("picture_blog", blog.picture_blog);
        values.put("country_id", blog.country_id);
        db.insert("blogs", null, values);
        db.close();
    }

    public void addComments(_0_comments comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("comments_id", comment.comments_id);
        values.put("hotel_id", comment.hotel_id);
        values.put("user_id", comment.user_id);
        values.put("content_comments", comment.content_comments);
        db.insert("comments", null, values);
        db.close();
    }

    public void addCountries(_0_countries country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("country_id", country.country_id);
        values.put("country_name", country.country_name);
        db.insert("countries", null, values);
        db.close();
    }

    public void addHotelDetail(_0_hotel_details hotel_detail) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hotel_details_id", hotel_detail.hotel_details_id);
        values.put("hotel_id", hotel_detail.hotel_id);
        values.put("number_of_room_hotel_detail", hotel_detail.number_of_room_hotel_detail);
        values.put("size_hotel_detail", hotel_detail.size_hotel_detail);
        values.put("description_hotel_detail", hotel_detail.description_hotel_detail);
        values.put("price_hotel_detail", hotel_detail.price_hotel_detail);
        values.put("status_hotel_detail", hotel_detail.status_hotel_detail);
        values.put("picture_1_hotel_detail", hotel_detail.picture_1_hotel_detail);
        values.put("picture_2_hotel_detail", hotel_detail.picture_2_hotel_detail);
        values.put("picture_3_hotel_detail", hotel_detail.picture_3_hotel_detail);
        db.insert("hotel_details", null, values);
        db.close();
    }

    public void addHotel(_0_hotels hotel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hotel_id", hotel.hotel_id);
        values.put("name_hotel", hotel.name_hotel);
        values.put("description_hotel", hotel.description_hotel);
        values.put("picture_hotel", hotel.picture_hotel);
        values.put("country_id", hotel.country_id);
        values.put("address_hotel", hotel.address_hotel);
        values.put("star_hotel", hotel.star_hotel);
        values.put("like_id", hotel.like_id);
        db.insert("hotels", null, values);
        db.close();
    }

    public void addLikes(_0_likes like) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("like_id", like.like_id);
        values.put("hotel_id", like.hotel_id);
        values.put("user_id", like.user_id);
        db.insert("likes", null, values);
        db.close();
    }

    public void addOrders(_0_orders order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("order_id", order.order_id);
        values.put("user_id", order.user_id);
        values.put("hotel_id", order.hotel_id);
        values.put("hotel_details_id", order.hotel_details_id);
        values.put("date_start_order", order.date_start_order);
        values.put("date_end_order", order.date_end_order);
        values.put("image_payment", order.image_payment);
        values.put("status_order", order.status_order);
        db.insert("orders", null, values);
        db.close();
    }

    public void addUsers(_0_users account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user_id", account.user_id);
        values.put("name_client", account.name_client);
        values.put("email_client", account.email_client);
        values.put("password_client", account.password_client);
        values.put("date_of_birth_client", account.date_of_birth_client);
        values.put("gender_client", account.gender_client);
        values.put("phone_client", account.phone_client);
        values.put("avatar_client", account.avatar_client);
        values.put("facebook_client", account.facebook_client);
        values.put("instagram_client", account.instagram_client);
        values.put("role_client", account.role_client);
        db.insert("users", null, values);
        db.close();
    }

//    Contact getContact(int id) {
//        Contact contact = new Contact();
//        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS + " WHERE " + KEY_ID + "=" + id;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            contact.setID(Integer.parseInt(cursor.getString(0)));
//            contact.setName(cursor.getString(1));
//            contact.setPhoneNumber(cursor.getString(2));
//        }
//        return contact;
//    }
//
//    public List<Contact> getAllContacts() {
//        List<Contact> contactList = new ArrayList<Contact>();
//        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Contact contact = new Contact();
//                contact.setID(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhoneNumber(cursor.getString(2));
//                contactList.add(contact);
//            } while (cursor.moveToNext());
//        }
//        return contactList;
//    }
//
//    public int updateContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_PH_NO, contact.getPhoneNumber());
//        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//                new String[]{String.valueOf(contact.getID())});
//    }
//
//    public void deleteContact(Contact contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//                new String[]{String.valueOf(contact.getID())});
//        db.close();
//    }
//
//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        return cursor.getCount();
//    }

}