package com.demo.kata;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.kata.activity.CustomDataSetActivity;

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
public class CustomDataSetActivityTest {
    private CustomDataSetActivity customDataSetActivity;

    @Before
    public void setUp() throws Exception {
        customDataSetActivity = Robolectric.buildActivity(CustomDataSetActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityShouldNotBeNull() throws Exception {
        assertNotNull(customDataSetActivity);
    }

    @Test
    public void checkUIComponents() {
        EditText editCustomContent = (EditText) customDataSetActivity.findViewById(R.id.edit_custom_data_set);
        TextView tvDataSetContent = (TextView) customDataSetActivity.findViewById(R.id.tv_data_set_content);
        TextView tvResultSuccess = (TextView) customDataSetActivity.findViewById(R.id.tv_results_success);
        TextView tvTotalCost = (TextView) customDataSetActivity.findViewById(R.id.tv_results_total_cost);
        TextView tvPath = (TextView) customDataSetActivity.findViewById(R.id.tv_results_path_taken);
        Button btnShowOutput = (Button) customDataSetActivity.findViewById(R.id.btn_show_output);
        TextView tvContentLbl = (TextView) customDataSetActivity.findViewById(R.id.tv_data_set_label);
        TextView tvResultLbl = (TextView) customDataSetActivity.findViewById(R.id.tv_results_label);
        assertNotNull(editCustomContent);
        assertNotNull(tvDataSetContent);
        assertNotNull(tvResultSuccess);
        assertNotNull(tvTotalCost);
        assertNotNull(tvPath);
        assertNotNull(btnShowOutput);
        assertNotNull(tvContentLbl);
        assertNotNull(tvResultLbl);
    }
}
