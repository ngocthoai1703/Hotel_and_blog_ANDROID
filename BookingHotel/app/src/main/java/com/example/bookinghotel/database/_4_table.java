package com.example.bookinghotel.database;

import java.util.Date;

//in ra các blog khác nhau
public class _4_table {
    public String user_id; //1
    public String hotel_id; //12
    public String country_id; //15
    public String hotel_details_id; //17
    public String like_id; //19
    public String comments_id; //28
    public String order_id; //30
    public String blog_id; //34
    public String title_blog; //35
    public String content_blog; //36
    public int picture_blog; //37
    public String country_name; //38

    public _4_table(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    int _picture_blog, String _title_blog, String _country_name,
                    String _content_blog) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        picture_blog = _picture_blog;
        title_blog = _title_blog;
        country_name = _country_name;
        content_blog = _content_blog;
    }
}
