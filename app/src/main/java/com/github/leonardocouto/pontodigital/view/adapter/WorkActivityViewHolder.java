package com.github.leonardocouto.pontodigital.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.leonardocouto.pontodigital.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkActivityViewHolder extends RecyclerView.ViewHolder {

    long workActivityId;
    @Bind(R.id.item_allocation_legend_color) View legendColor;
    @Bind(R.id.item_allocation_work_activity) TextView workActivity;
    @Bind(R.id.item_allocation_time_slot) TextView timeSlot;

    public WorkActivityViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

}
