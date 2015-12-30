package com.github.leonardocouto.pontodigital.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import butterknife.ButterKnife;
import butterknife.OnClick;

abstract class AllocationFragmentBase extends Fragment {

    private AddWorkActivityActionHandler addWorkActivity;

    @Override
    public void onAttach(Activity activity) {
        // the non-deprecated method was not being called
        super.onAttach(activity);
        this.addWorkActivity = (AddWorkActivityActionHandler) activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.addWorkActivity = (AddWorkActivityActionHandler) context;
    }

    protected AddWorkActivityActionHandler addWorkActivityActionHandler() {
        return this.addWorkActivity;
    }

}
