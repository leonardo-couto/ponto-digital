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

    private final List<WorkActivity> workActivities;

    public WorkActivityAllocationAdapter(List<WorkActivity> activities) {
        this.workActivities = activities;
    }

    public ArrayList<WorkActivity> getValues() {
        return new ArrayList<>(workActivities);
    }

    @Override
    public WorkActivityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_allocation_work_activity, parent, false);
        return new WorkActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkActivityViewHolder holder, int position) {
        WorkActivity workActivity = this.workActivities.get(position);

        // TODO ColorGenerator (from index)
        // TODO time slot picker

        holder.workActivityId = workActivity.getId();
        holder.legendColor.setBackgroundResource(R.color.colorAccent);
        holder.workActivity.setText(workActivity.getClient() + " - " + workActivity.getName() + " - " + workActivity.getProject());
        holder.timeSlot.setText(new Random().nextInt(101) + "%");
    }

    @Override
    public int getItemCount() {
        return this.workActivities.size();
    }

    public void add(WorkActivity workActivity) {
        this.workActivities.add(workActivity);
        this.notifyItemInserted(this.workActivities.size() - 1);
    }
}