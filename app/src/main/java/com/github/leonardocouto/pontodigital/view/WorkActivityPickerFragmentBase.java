package com.github.leonardocouto.pontodigital.view;

import android.annotation.SuppressLint;
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

abstract class WorkActivityPickerFragmentBase extends Fragment {

    private PickWorkActivityHandler pickWorkActivityHandler;

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_foobar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    protected PickWorkActivityHandler pickWorkActivityHandler() {
        return this.pickWorkActivityHandler;
    }

}
