package com.github.leonardocouto.pontodigital.view.adapter;

import android.content.Context;
import android.graphics.Color;
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

public class WorkActivityAllocationAdapter extends ArrayAdapter<WorkActivity> {

    private final List<WorkActivity> workActivities;

    public WorkActivityAllocationAdapter(Context context, int resource, List<WorkActivity> objects) {
        super(context, resource, objects);
        this.workActivities = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WorkActivity workActivity = this.getItem(position);
        View row = (convertView == null) ? this.inflateLayout(parent) : convertView;
        ViewHolder holder = (ViewHolder) row.getTag();

        // TODO ColorGenerator (from index)
        // TODO time slot picker
        holder.workActivityId = workActivity.getId();
        holder.legendColor.setBackgroundColor(Color.rgb(155, 50, 50));
        holder.workActivity.setText(workActivity.getClient() + " - " + workActivity.getName() + " - " + workActivity.getProject());
        holder.timeSlot.setText(new Random().nextInt(101) + "%");

        return row;
    }

    private View inflateLayout(ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_allocation_work_activity, parent, false);
        view.setTag(new ViewHolder(view));
        return view;
    }

    public ArrayList<WorkActivity> getValues() {
        return new ArrayList<>(workActivities);
    }

    static class ViewHolder {

        long workActivityId;
        @Bind(R.id.item_allocation_legend_color) View legendColor;
        @Bind(R.id.item_allocation_work_activity) TextView workActivity;
        @Bind(R.id.item_allocation_time_slot) TextView timeSlot;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}