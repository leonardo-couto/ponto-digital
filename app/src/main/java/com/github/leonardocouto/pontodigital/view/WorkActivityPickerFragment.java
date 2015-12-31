package com.github.leonardocouto.pontodigital.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class WorkActivityPickerFragment extends WorkActivityPickerFragmentBase {

    public static final String TAG = "work_activity_picker_fragment";

    @Bind(R.id.listview_activity_picker) ListView listView;
    private ArrayAdapter<WorkActivity> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: ver busca do Telegram
        View view = inflater.inflate(R.layout.fragment_work_activity_picker, container, false);
        ButterKnife.bind(this, view);

        this.adapter = mockedWorkActivities();
        this.listView.setAdapter(this.adapter);

        return view;
    }

    @OnItemClick(R.id.listview_activity_picker)
    public void onPickWorkActivity(int position) {
        pickWorkActivityHandler().handle(this.adapter.getItem(position));
    }

    @NonNull
    private ArrayAdapter<WorkActivity> mockedWorkActivities() {
        return new ArrayAdapter<WorkActivity>(
                this.listView.getContext(),
                R.layout.list_item_picker_work_activity,
                R.id.item_activity,
                new WorkActivity[] {
                    WorkActivity.build("DEV", "C&A", "Celula Scrum", "Desenvolvimento"),
                    WorkActivity.build("DEV", "Facti", "RDA", "Desenvolvimento"),
                    WorkActivity.build("DEV", "Sodexo", "Deep Dive", "Outros"),
                    WorkActivity.build("RH", "Desenvolvimento Organizacional", "Mentoria", "Outros")
                }
        );
    }

}
