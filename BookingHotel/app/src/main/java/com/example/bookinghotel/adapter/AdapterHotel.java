package com.example.bookinghotel.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotel.BlogDetail;
import com.example.bookinghotel.DetailRoom;
import com.example.bookinghotel.R;
import com.example.bookinghotel.database._1_table;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterHotel extends RecyclerView.Adapter<AdapterHotel.HotelViewHolder> {

    private List<_1_table> listHotel;
    private Context context;

    public AdapterHotel(List<_1_table> list) {
        this.listHotel = list;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_hotel, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        _1_table hotel = listHotel.get(position);
        if (hotel == null) {
            return;
        }
        holder.imgHotel.setImageResource(hotel.picture_hotel);
        holder.nameHotel.setText(hotel.name_hotel);
        holder.priceHotel.setText(String.valueOf(hotel.star_hotel));
        holder.cardviewhomehotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), DetailRoom.class);
                Calendar calendar = Calendar.getInstance();
                String Format = "dd/MM/yyyy";
                SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
                String date_from_to = "From " + date_from.format(calendar.getTime()) + " to " + date_from.format(calendar.getTime());
                i.putExtra("hotel_id", hotel.hotel_id);
                i.putExtra("number_of_day_other", date_from_to);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listHotel != null) {
            return listHotel.size();
        }
        return 0;
    }

    public class HotelViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgHotel;
        private TextView nameHotel, priceHotel;
        private CardView cardviewhomehotel;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);
            cardviewhomehotel = itemView.findViewById(R.id.cardviewhomehotel);
            imgHotel = itemView.findViewById(R.id.img_tophotel);
            nameHotel = itemView.findViewById(R.id.namehotel_tophotel);
            priceHotel = itemView.findViewById(R.id.pricehotel_tophotel);
        }
    }
}