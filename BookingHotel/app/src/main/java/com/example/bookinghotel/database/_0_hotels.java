package com.example.bookinghotel.database;

import java.util.Date;

public class _0_hotels {
    public String user_id;
    public String hotel_id;
    public String name_hotel;
    public String description_hotel;
    public String country_id;
    public String address_hotel;
    public String hotel_details_id;
    public int star_hotel;
    public String like_id;
    public int price_hotel_detail;
    public String comments_id;
    public String order_id;
    public String blog_id;
    public int picture_hotel;

    public _0_hotels(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    String _name_hotel, String _description_hotel, int _picture_hotel,
                    String _address_hotel, int _star_hotel) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        name_hotel = _name_hotel;
        description_hotel = _description_hotel;
        picture_hotel = _picture_hotel;
        address_hotel = _address_hotel;
        star_hotel = _star_hotel;
    }
}
