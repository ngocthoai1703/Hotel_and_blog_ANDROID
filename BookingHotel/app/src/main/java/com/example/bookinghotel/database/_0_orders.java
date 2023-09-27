package com.example.bookinghotel.database;

import java.util.Date;

public class _0_orders {
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
    public String date_start_order; //31
    public String date_end_order; //32
    public int status_order; //33
    public String blog_id; //34
    public int picture_hotel; //39
    public int image_payment;

    public _0_orders (){}
    public _0_orders(String _user_id, String _hotel_id, String _country_id,
                       String _hotel_details_id, String _like_id, String _comments_id,
                       String _order_id, String _blog_id,
                       String _date_start_order, String _date_end_order, int _status_order, int _image_payment) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        date_start_order = _date_start_order;
        date_end_order = _date_end_order;
        status_order = _status_order;
        image_payment = _image_payment;
    }
}
