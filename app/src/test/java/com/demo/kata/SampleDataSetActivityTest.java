package com.demo.kata;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.kata.activity.SampleDataSetActivity;

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
public class SampleDataSetActivityTest {
    private SampleDataSetActivity sampleDataSetActivity;

    @Before
    public void setUp() throws Exception {
        sampleDataSetActivity = Robolectric.buildActivity(SampleDataSetActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void activityShouldNotBeNull() throws Exception {
        assertNotNull(sampleDataSetActivity);
    }

    @Test
    public void checkUIComponents() {
        final Button buttonSampleOne = (Button) sampleDataSetActivity.findViewById(R.id.button_sample_one);
        final Button buttonSampleTwo = (Button) sampleDataSetActivity.findViewById(R.id.button_sample_two);
        final Button buttonSampleThree = (Button) sampleDataSetActivity.findViewById(R.id.button_sample_three);
        Button buttonResult = (Button) sampleDataSetActivity.findViewById(R.id.btn_result);
        TextView tvResult = (TextView) sampleDataSetActivity.findViewById(R.id.tv_results_success);
        TextView tvTotalCost = (TextView) sampleDataSetActivity.findViewById(R.id.tv_results_total_cost);
        TextView tvPath = (TextView) sampleDataSetActivity.findViewById(R.id.tv_results_path_taken);
        TextView tvDataContent = (TextView) sampleDataSetActivity.findViewById(R.id.tv_contents);
        LinearLayout resultLayout = (LinearLayout) sampleDataSetActivity.findViewById(R.id.results_layout);
        TextView tvOutputLabel = (TextView) sampleDataSetActivity.findViewById(R.id.tv_results_label);
        assertNotNull(buttonSampleOne);
        assertNotNull(buttonSampleTwo);
        assertNotNull(buttonSampleThree);
        assertNotNull(buttonResult);
        assertNotNull(tvResult);
        assertNotNull(tvTotalCost);
        assertNotNull(tvPath);
        assertNotNull(tvDataContent);
        assertNotNull(resultLayout);
        assertNotNull(tvOutputLabel);

    }


}
