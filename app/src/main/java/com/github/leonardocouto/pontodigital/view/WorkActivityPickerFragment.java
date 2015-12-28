package com.github.leonardocouto.pontodigital.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.fragment_activity_picker, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview_activity_picker);

        // TODO: ver busca do Telegram

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_activity, R.id.item_activity, new String[] {
                "DEV - C&A - Celula Scrum",
                "DEV - Facti - RDA",
                "DEV - Sodexo - Deep Dive",
                "RH - Mentoria",
        });

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO item should be a WorkActivity
                String item = adapter.getItem(position);
                WorkActivity workActivity = new WorkActivity();
                workActivity.setName(item);

                pickWorkActivityHandler.handle(workActivity);

            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_foobar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
