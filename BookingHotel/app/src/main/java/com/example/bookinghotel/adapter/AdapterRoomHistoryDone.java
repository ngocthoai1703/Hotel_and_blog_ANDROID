package com.example.bookinghotel.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotel.BillBank;
import com.example.bookinghotel.R;
import com.example.bookinghotel.database._2_table;

import java.util.List;

public class AdapterRoomHistoryDone extends RecyclerView.Adapter<AdapterRoomHistoryDone.ListRoomHistory>{

    private List<_2_table> roomhistoryList;

    public AdapterRoomHistoryDone(List<_2_table> roomhistoryList) {
        this.roomhistoryList = roomhistoryList;
    }

    @Override
    public int getItemCount() {
        if(roomhistoryList != null) {
            return roomhistoryList.size();
        }
        return 0;
    }

    public class ListRoomHistory extends RecyclerView.ViewHolder{
        private ImageView _171;
        private TextView _172, _174, _176, _175, _178;
        Button buttonseebill1;

        public ListRoomHistory(@NonNull View itemView) {
            super(itemView);
            _171 = itemView.findViewById(R.id._171);
            _172 = itemView.findViewById(R.id._172);
            _174 = itemView.findViewById(R.id._174);
            _176 = itemView.findViewById(R.id._176);
            _178 = itemView.findViewById(R.id._178);
            _175 = itemView.findViewById(R.id._175);
            buttonseebill1 = itemView.findViewById(R.id.buttonseebill1);
        }
    }

    @NonNull
    @Override
    public ListRoomHistory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_room_history_done, parent, false);
        return new ListRoomHistory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListRoomHistory holder, int position) {

        final _2_table room_history_1 = roomhistoryList.get(position);
        if (room_history_1 == null) {
            return;
        }
        holder._171.setImageResource(room_history_1.picture_hotel);
        holder._172.setText(room_history_1.name_hotel);
        holder._174.setText(String.valueOf(room_history_1.price_hotel_detail));
        holder._175.setText(room_history_1.number_of_day_other);
        holder._176.setText(room_history_1.number_of_room_hotel_detail);
        holder._178.setText(room_history_1.address_hotel);
        holder.buttonseebill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), BillBank.class);
                i.putExtra("order_id", room_history_1.order_id);
                view.getContext().startActivity(i);
            }
        });
    }
}
