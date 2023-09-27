package com.example.bookinghotel.database;

import java.util.Date;

//lưu lại những comment
public class _5_table {
    public String user_id; //1
    public String name_client; //2
    public String email_client; //3
    public String password_client; //4
    public String date_of_birth_client; //5
    public String gender_client; //6
    public String phone_client; //7
    public int avatar_client; //8
    public String facebook_client; //9
    public String instagram_client; //10
    public String role_client; //11
    public String hotel_id; //12
    public String name_hotel; //13
    public String description_hotel; //14
    public String country_id; //15
    public String address_hotel; //16
    public String hotel_details_id; //17
    public int star_hotel; //18
    public String like_id; //19
    public String number_of_room_hotel_detail; //20
    public String size_hotel_detail; //21
    public String description_hotel_detail; //22
    public int price_hotel_detail; //23
    public int status_hotel_detail; //24
    public int picture_1_hotel_detail; //25
    public int picture_2_hotel_detail; //26
    public int picture_3_hotel_detail; //27
    public String comments_id; //28
    public String content_comments; //29
    public String order_id; //30
    public String date_start_order; //31
    public String date_end_order; //32
    public String status_order; //33
    public String blog_id; //34
    public String title_blog; //35
    public String content_blog; //36
    public int picture_blog; //37
    public String country_name; //38
    public int picture_hotel; //39
    //Others
    public String number_of_day_other; //40
    public String type_other; //41

    public _5_table(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    String _content_comments, int _avatar_client, String _name_client) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        name_client = _name_client;
        content_comments = _content_comments;
        avatar_client = _avatar_client;
    }
}
