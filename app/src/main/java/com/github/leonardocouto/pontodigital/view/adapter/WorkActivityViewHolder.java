package com.github.leonardocouto.pontodigital.view.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.leonardocouto.pontodigital.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkActivityViewHolder extends RecyclerView.ViewHolder {

    private final boolean header;

    long workActivityId;
    @Nullable @Bind(R.id.item_allocation_legend_color) View legendColor;
    @Nullable @Bind(R.id.item_allocation_work_activity) TextView workActivity;
    @Nullable @Bind(R.id.item_allocation_time_slot) TextView timeSlot;
    @Nullable @Bind(R.id.allocation_title) EditText title;

    public WorkActivityViewHolder(View view, boolean header) {
        super(view);
        this.header = header;
        ButterKnife.bind(this, view);
    }

    public boolean isHeader() {
        return this.header;
    }

}
