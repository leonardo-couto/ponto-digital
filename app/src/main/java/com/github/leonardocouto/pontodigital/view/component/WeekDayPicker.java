package com.github.leonardocouto.pontodigital.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.github.leonardocouto.pontodigital.R;

public class WeekDayPicker extends LinearLayout {

    public WeekDayPicker(Context context) {
        super(context);
        this.initializeViews(context);
    }

    public WeekDayPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initializeViews(context);
    }

    public WeekDayPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initializeViews(context);
    }

    public WeekDayPicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_week_day_picker, this);
    }
}
