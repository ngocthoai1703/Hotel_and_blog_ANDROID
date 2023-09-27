package com.example.bookinghotel.database;

import java.util.Date;

public class _0_blogs {
    public String user_id; //1
    public String hotel_id; //12
    public String name_hotel; //13
    public String country_id; //15
    public String address_hotel; //16
    public String hotel_details_id; //17
    public String like_id; //19
    public int price_hotel_detail; //23
    public String comments_id; //28
    public String order_id; //30
    public String blog_id; //34
    public String title_blog; //35
    public String content_blog; //36
    public int picture_blog; //37
    public int picture_hotel; //39

    public _0_blogs() {};
    public _0_blogs(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    String _title_blog, String _content_blog, int _picture_blog) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        title_blog = _title_blog;
        content_blog = _content_blog;
        picture_blog = _picture_blog;
    }
}
