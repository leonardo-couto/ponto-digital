package com.github.leonardocouto.pontodigital.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;
import com.github.leonardocouto.pontodigital.view.adapter.WorkActivityAllocationAdapter;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AllocationFragment extends AllocationFragmentBase {

    public static final String TAG = "allocation_fragment";

    @Bind(R.id.chart) LinearLayout chartContainer;
    @Bind(R.id.listview_activity_allocation) RecyclerView recyclerView;

    String titleValue;

    private WorkActivityAllocationAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle state) {
        View view = inflater.inflate(R.layout.fragment_allocation, container, false);
        ButterKnife.bind(this, view);

        if (this.adapter == null) {
            this.adapter = new WorkActivityAllocationAdapter(buildWorkActivities(state));
        }

        boolean changeTitle = this.titleValue == null && state != null;
        this.adapter.setTitle(changeTitle ? state.getString("title") : this.titleValue);

        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.recyclerView.setAdapter(this.adapter);

        this.makeChart();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        this.titleValue = this.adapter.getTitle();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("workActivities", this.adapter.getValues());
        outState.putString("title", this.adapter.getTitle());
    }

    @OnClick(R.id.add_new_activity)
    public void askForNewWorkActivity() {
        // TODO get work activities already in the allocation before calling this method
        WorkActivity[] currentActivities = new WorkActivity[0];
        addWorkActivityActionHandler().differentFrom(currentActivities);
    }

    public void addWorkActivity(WorkActivity workActivity) {
        this.adapter.add(workActivity);

    }

    private void makeChart() {

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

        this.chartContainer.removeAllViews();

        GraphicalView mChart = ChartFactory.getPieChartView(this.chartContainer.getContext(), distributionSeries, renderer);
        this.chartContainer.addView(mChart);
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
        renderer.setScale(1.3f);
        return renderer;
    }

    private static List<WorkActivity> buildWorkActivities(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return new ArrayList<WorkActivity>();

        }

        List<WorkActivity> workActivities = savedInstanceState.<WorkActivity>getParcelableArrayList("workActivities");
        return (workActivities == null) ? new ArrayList<WorkActivity>() : workActivities;
    }

}
