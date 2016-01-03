package com.github.leonardocouto.pontodigital.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkActivityAllocationAdapter extends RecyclerView.Adapter<WorkActivityViewHolder> {

    private static final int HEADER = 0;
    private static final int LAYOUT_HEADER = R.layout.list_header_allocation_work_activity;
    private static final int LAYOUT_ITEM = R.layout.list_item_allocation_work_activity;

    private final List<WorkActivity> workActivities;
    private String title;
    private WorkActivityViewHolder header;

    public WorkActivityAllocationAdapter(List<WorkActivity> activities) {
        this.workActivities = activities;
    }

    public ArrayList<WorkActivity> getValues() {
        return new ArrayList<>(workActivities);
    }

    @Override
    public WorkActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == HEADER) {
            View view = inflater.inflate(LAYOUT_HEADER, parent, false);
            WorkActivityViewHolder viewHolder = new WorkActivityViewHolder(view, true);
            this.header = viewHolder;
            return viewHolder;
        }

        View view = inflater.inflate(LAYOUT_ITEM, parent, false);
        return new WorkActivityViewHolder(view, false);
    }

    @Override
    public void onBindViewHolder(WorkActivityViewHolder holder, int position) {
        if (position == 0) {
            holder.title.setText(this.title);
            return;
        }

        WorkActivity workActivity = this.workActivities.get(position - 1);

        // TODO ColorGenerator (from index)
        // TODO time slot picker

        holder.workActivityId = workActivity.getId();
        holder.legendColor.setBackgroundResource(R.color.colorAccent);
        holder.workActivity.setText(workActivity.getClient() + " - " + workActivity.getName() + " - " + workActivity.getProject());
        holder.timeSlot.setText(new Random().nextInt(101) + "%");
    }

    @Override
    public int getItemCount() {
        return this.workActivities.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == 0) ? HEADER : 1;
    }

    @Override
    public void onViewDetachedFromWindow(WorkActivityViewHolder holder) {
        if (holder.isHeader()) {
            this.title = holder.title.getText().toString();
        }
    }

    public void add(WorkActivity workActivity) {
        this.workActivities.add(workActivity);
        this.notifyItemInserted(this.workActivities.size());
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return (header == null) ? this.title : header.title.getText().toString();
    }
}