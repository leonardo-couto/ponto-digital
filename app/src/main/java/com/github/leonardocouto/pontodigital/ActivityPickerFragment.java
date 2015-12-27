package com.github.leonardocouto.pontodigital;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class ActivityPickerFragment extends Fragment {

    public ActivityPickerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_picker, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview_activity_picker);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_activity, R.id.item_activity, new String[] {
                "DEV - C&A - Celula Scrum",
                "DEV - Facti - RDA",
                "DEV - Sodexo - Deep Dive",
                "RH - Mentoria",
        });

        listView.setAdapter(adapter);

        return view;
    }

}
