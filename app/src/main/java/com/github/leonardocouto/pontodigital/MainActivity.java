package com.github.leonardocouto.pontodigital;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.openAllocationFragment();
        //this.openActivityPickerFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        setActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    public void openActivityPickerFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        ActivityPickerFragment activityPicker = new ActivityPickerFragment();

        fragmentManager
                .beginTransaction()
                .replace(R.id.xptoid, activityPicker, "activity_picker_fragment")
                .addToBackStack(null)
                .commit();
    }

    public void openAllocationFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        MainActivityFragment fragment = new MainActivityFragment();

        fragmentManager
                .beginTransaction()
                .replace(R.id.xptoid, fragment, "main_activity_fragment")
                .addToBackStack(null)
                .commit();
    }
}
