package com.example.bookinghotel.database;

import java.util.Date;

public class _0_users {
    public String user_id;
    public String name_client;
    public String email_client;
    public String password_client;
    public String date_of_birth_client;
    public String gender_client;
    public String phone_client;
    public int avatar_client;
    public String facebook_client;
    public String instagram_client;
    public String role_client;
    public String hotel_id;
    public String name_hotel;
    public String country_id;
    public String hotel_details_id;
    public String like_id;
    public int price_hotel_detail;
    public String comments_id;
    public String order_id;
    public String blog_id;
    //public int picture_hotel;

    public _0_users() {};
    public _0_users(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    String _name_client, String _email_client, String _password_client,
                    String _date_of_birth_client, String _gender_client,
                    String _phone_client, int _avatar_client, String _facebook_client,
                    String _instagram_client, String _role_client) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        name_client = _name_client;
        email_client = _email_client;
        password_client = _password_client;
        date_of_birth_client = _date_of_birth_client;
        gender_client = _gender_client;
        phone_client = _phone_client;
        avatar_client = _avatar_client;
        facebook_client = _facebook_client;
        instagram_client = _instagram_client;
        role_client = _role_client;
    }
}
