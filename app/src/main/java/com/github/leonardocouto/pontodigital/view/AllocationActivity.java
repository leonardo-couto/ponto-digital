package com.github.leonardocouto.pontodigital.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.github.leonardocouto.pontodigital.R;
import com.github.leonardocouto.pontodigital.entity.WorkActivity;

public class AllocationActivity extends Activity implements PickWorkActivityHandler, AddWorkActivityActionHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.openAllocationFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        setActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openAllocationFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        AllocationFragment fragment = new AllocationFragment();

        fragmentManager
                .beginTransaction()
                .replace(R.id.allocation_container, fragment, AllocationFragment.TAG)
                .commit();
    }

    @Override
    public void handle(WorkActivity work) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack(WorkActivityPickerFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        openAllocationFragment();
    }

    @Override
    public void differentFrom(WorkActivity... excludes) {
        FragmentManager fragmentManager = getFragmentManager();
        WorkActivityPickerFragment fragment = new WorkActivityPickerFragment();

        fragmentManager
                .beginTransaction()
                .replace(R.id.allocation_container, fragment, WorkActivityPickerFragment.TAG)
                .addToBackStack(WorkActivityPickerFragment.TAG)
                .commit();
    }
}
