package com.example.bookinghotel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookinghotel.R;
import com.example.bookinghotel.database._5_table;

import java.util.List;

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.ListReview> {
    private List<_5_table> reviewsList;

    public AdapterReview(List<_5_table> reviewsList) {
        this.reviewsList = reviewsList;
    }

    @Override
    public int getItemCount() {
        if (reviewsList != null) {
            return reviewsList.size();
        }
        return 0;
    }

    public class ListReview extends RecyclerView.ViewHolder {
        private ImageView _150;
        private TextView _151, _153;

        public ListReview(@NonNull View itemView) {
            super(itemView);
            _150 = itemView.findViewById(R.id._150);
            _151 = itemView.findViewById(R.id._151);
            _153 = itemView.findViewById(R.id._153);
        }
    }

    @NonNull
    @Override
    public AdapterReview.ListReview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_review, parent, false);
        return new ListReview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReview.ListReview holder, int position) {
        _5_table review = reviewsList.get(position);
        if (review == null) {
            return;
        }
        holder._150.setImageResource(review.avatar_client);
        holder._151.setText(review.name_client);
        holder._153.setText(review.content_comments);
    }
}
