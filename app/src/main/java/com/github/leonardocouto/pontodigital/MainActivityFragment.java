package com.github.leonardocouto.pontodigital;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.makeChart(view);
        return view;
    }

    private void makeChart(View view) {

        double[] distribution = {85.0d, 15.0d};
        int[] colors = {Color.argb(255, 165, 198, 99), Color.argb(255,15,88,55)};

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
        DefaultRenderer defaultRenderer = new DefaultRenderer();
        defaultRenderer.setApplyBackgroundColor(false);
        defaultRenderer.setShowLabels(false);
        defaultRenderer.setShowLegend(false);
        defaultRenderer.setZoomButtonsVisible(false);
        defaultRenderer.setClickEnabled(false);
        defaultRenderer.setZoomEnabled(false);
        defaultRenderer.setInScroll(false);
        defaultRenderer.setPanEnabled(false);
        defaultRenderer.setScale(1.25f);
        return defaultRenderer;
    }
}
