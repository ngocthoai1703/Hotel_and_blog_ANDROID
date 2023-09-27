package com.example.bookinghotel.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookinghotel.fragment_room_history.CancelFragment;
import com.example.bookinghotel.fragment_room_history.DoingFragment;
import com.example.bookinghotel.fragment_room_history.DoneFragment;

public class MyRoomHistoryAdapter extends FragmentStateAdapter {
    public MyRoomHistoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DoingFragment();
            case 1:
                return new DoneFragment();
            case 2:
                return new CancelFragment();
            default:
                return new DoingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
