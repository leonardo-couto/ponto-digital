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

public class AllocationFragment extends Fragment {

    public static final String TAG = "allocation_fragment";
    private AddWorkActivityActionHandler addWorkActivity;

    public AllocationFragment() {
    }

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

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.makeChart(view);

        LinearLayout addNewActivity = (LinearLayout) view.findViewById(R.id.add_new_activity);
        addNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO get work activities already in the allocation before calling this method
                WorkActivity[] currentActivities = new WorkActivity[0];
                addWorkActivity.differentFrom(currentActivities);
            }
        });

        return view;
    }

    private void makeChart(View view) {

        double[] distribution = {45.0d, 40.0d, 15.0d};
        int[] colors = {Color.argb(255, 142, 170, 85), Color.argb(255, 165, 198, 99), Color.argb(255,121,144,72)};

        CategorySeries distributionSeries = new CategorySeries("Allocation");

        for (double data : distribution) {
            distributionSeries.add(data);
        }

        DefaultRenderer renderer = this.allocationChartRenderer();

        for (int color : colors) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(color);
            renderer.addSeriesRenderer(seriesRenderer);
        }

        LinearLayout chartContainer = (LinearLayout) view.findViewById(R.id.chart);
        chartContainer.removeAllViews();

        GraphicalView mChart = ChartFactory.getPieChartView(view.getContext(), distributionSeries, renderer);
        chartContainer.addView(mChart);
    }

    @NonNull
    private DefaultRenderer allocationChartRenderer() {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setApplyBackgroundColor(false);
        renderer.setShowLabels(false);
        renderer.setShowLegend(false);
        renderer.setZoomButtonsVisible(false);
        renderer.setClickEnabled(false);
        renderer.setZoomEnabled(false);
        renderer.setInScroll(false);
        renderer.setPanEnabled(false);
        renderer.setScale(1.25f);
        return renderer;
    }
}
