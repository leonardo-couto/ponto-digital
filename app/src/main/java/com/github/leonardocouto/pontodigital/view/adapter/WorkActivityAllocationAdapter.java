package com.github.leonardocouto.pontodigital.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WorkActivityAllocationAdapter extends ArrayAdapter<WorkActivity> {

    public WorkActivityAllocationAdapter(Context context, int resource, int textViewResourceId, List<WorkActivity> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WorkActivity workActivity = this.getItem(position);
        View row = (convertView == null) ? convertView : this.inflateLayout(parent);
        ViewHolder holder = (ViewHolder) row.getTag();

        holder.name.setText(workActivity.getClient());

        return row;
    }

    private View inflateLayout(ViewGroup parent) {
        // TODO create new layout
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_activity, parent);
        view.setTag(new ViewHolder(view));
        return view;
    }

    private static class ViewHolder {

        @Bind(R.id.item_activity) TextView name;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }
}
