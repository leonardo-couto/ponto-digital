package com.github.leonardocouto.pontodigital.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

public class WorkActivityPickerFragment extends Fragment {

    public static final String TAG = "work_activity_picker_fragment";
    private PickWorkActivityHandler pickWorkActivityHandler;

    public WorkActivityPickerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Activity activity) {
        // the non-deprecated method was not being called
        super.onAttach(activity);
        this.pickWorkActivityHandler = (PickWorkActivityHandler) activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.pickWorkActivityHandler = (PickWorkActivityHandler) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_activity_picker, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview_activity_picker);

        // TODO: ver busca do Telegram

        final ArrayAdapter<WorkActivity> adapter = mockedWorkActivities();

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pickWorkActivityHandler.handle(adapter.getItem(position));
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_foobar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    private ArrayAdapter<WorkActivity> mockedWorkActivities() {
        return new ArrayAdapter<WorkActivity>(getActivity(), R.layout.list_item_activity, R.id.item_activity, new WorkActivity[] {
                WorkActivity.build("DEV", "C&A", "Celula Scrum", "Desenvolvimento"),
                WorkActivity.build("DEV", "Facti", "RDA", "Desenvolvimento"),
                WorkActivity.build("DEV", "Sodexo", "Deep Dive", "Outros"),
                WorkActivity.build("RH", "Desenvolvimento Organizacional", "Mentoria", "Outros")
        });
    }

}
