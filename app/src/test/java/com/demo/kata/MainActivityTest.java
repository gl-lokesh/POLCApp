package com.demo.kata;

import android.widget.Button;


import com.demo.kata.activity.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

/**
 * Created by lokesh_n on 2/9/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityShouldNotBeNull() throws Exception {
        assertNotNull(mainActivity);
    }

    @Test
    public void checkUIComponents() {
        Button btnSampleDateSet = (Button) mainActivity.findViewById(R.id.button_sample_data_set);
        Button btnCustomDateSet = (Button) mainActivity.findViewById(R.id.button_custom_data_set);
        assertNotNull(btnCustomDateSet);
        assertNotNull(btnSampleDateSet);
    }
}
