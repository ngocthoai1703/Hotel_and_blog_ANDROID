package com.example.bookinghotel.database;

//recycle view trong list history, có doing, done, cancel
public class _2_table {
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
    public String number_of_room_hotel_detail;
    public int price_hotel_detail;
    public int picture_hotel;
    //Others
    public String number_of_day_other;

    public _2_table(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    int _picture_hotel, String _name_hotel, int _price_hotel_detail,
                    String _number_of_day_other, String _number_of_room_hotel_detail,
                    String _address_hotel) {
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
        price_hotel_detail = _price_hotel_detail;
        number_of_day_other = _number_of_day_other;
        number_of_room_hotel_detail = _number_of_room_hotel_detail;
        address_hotel = _address_hotel;
    }
}
