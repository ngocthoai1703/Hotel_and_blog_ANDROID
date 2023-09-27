package com.example.bookinghotel.database;

//load ra các recycle view các khách sạn hiện có
public class _1_table {
    public String user_id;
    public String hotel_id;
    public String country_id;
    public String hotel_details_id;
    public String like_id;
    public String comments_id;
    public String order_id;
    public String blog_id;
    public String name_hotel;
    public String address_hotel;
    public int star_hotel;
    public int price_hotel_detail;
    public int status_hotel_detail;
    public int picture_hotel;
    public int save_hotel;
    //Others
    public String number_of_day_other;

    public _1_table(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    int _picture_hotel, String _name_hotel, int _star_hotel,
                    int _status_hotel_detail, String _number_of_day_other,
                    String _address_hotel, int _save_hotel) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        picture_hotel = _picture_hotel;
        name_hotel = _name_hotel;
        star_hotel = _star_hotel;
        status_hotel_detail = _status_hotel_detail;
        number_of_day_other = _number_of_day_other;
        address_hotel = _address_hotel;
        save_hotel = _save_hotel;
    }
}
