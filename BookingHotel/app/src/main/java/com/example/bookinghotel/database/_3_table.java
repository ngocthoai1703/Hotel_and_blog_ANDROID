package com.example.bookinghotel.database;

//hotel_details: chưa xong
public class _3_table {
    public String user_id;
    public String hotel_id;
    public String country_id;
    public String hotel_details_id;
    public String like_id;
    public String comments_id;
    public String order_id;
    public String blog_id;
    private String number_of_room;
    private int Size;
    private String description;
    private int Price;
    private String status;
    private int pictute1;
    private int picture2;
    private int picture3;

    public _3_table(String _user_id, String _hotel_id, String _country_id,
                    String _hotel_details_id, String _like_id, String _comments_id,
                    String _order_id, String _blog_id,
                    String number_of_room, int size, String description, int price, String status, int pictute1, int picture2, int picture3) {
        user_id = _user_id;
        hotel_id = _hotel_id;
        country_id = _country_id;
        hotel_details_id = _hotel_details_id;
        like_id = _like_id;
        comments_id = _comments_id;
        order_id = _order_id;
        blog_id = _blog_id;
        this.number_of_room = number_of_room;
        Size = size;
        this.description = description;
        Price = price;
        this.status = status;
        this.pictute1 = pictute1;
        this.picture2 = picture2;
        this.picture3 = picture3;
    }
}
