package com.github.leonardocouto.pontodigital;

import android.app.Fragment;
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

public class ActivityPickerFragment extends Fragment {

    public ActivityPickerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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
                String item = adapter.getItem(position);
                Toast.makeText(getActivity(), item, Toast.LENGTH_SHORT).show();
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
