package com.demo.kata.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.kata.R;
import com.demo.kata.activity.exception.InvalidInputException;
import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.helper.CalculateLowestPath;
import com.demo.kata.activity.helper.PathFinder;
import com.demo.kata.activity.helper.Result;
import com.demo.kata.activity.utils.AppConstants;
import com.demo.kata.activity.utils.MatrixUtils;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class SampleDataSetActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    private TextView tvTotalCost;
    private TextView tvPath;
    private TextView tvDataContent;
    private final static int SAMPLE_1 = 1;
    private final static int SAMPLE_2 = 2;
    private final static int SAMPLE_3 = 3;
    private int selectedDataSet;
    private Button buttonResult;
    private LinearLayout resultLayout;
    private TextView tvOutputLabel;

    /**
     * onCreate(Bundle) is where you initialize your activity. Most importantly, here you will usually
     * call setContentView(int) with a layout resource defining your UI, and using findViewById(int) to
     * retrieve the widgets in that UI that you need to interact with programmatically.
     * When the application is launched for the first time this screen will be displayed.
     * The application will display the splash screen and build version also.
     *
     * @param savedInstanceState Constructs a new, empty Bundle.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_data_set);
        final Button buttonSampleOne = (Button) findViewById(R.id.button_sample_one);
        final Button buttonSampleTwo = (Button) findViewById(R.id.button_sample_two);
        final Button buttonSampleThree = (Button) findViewById(R.id.button_sample_three);
        buttonResult = (Button) findViewById(R.id.btn_result);
        tvResult = (TextView) findViewById(R.id.tv_results_success);
        tvTotalCost = (TextView) findViewById(R.id.tv_results_total_cost);
        tvPath = (TextView) findViewById(R.id.tv_results_path_taken);
        tvDataContent = (TextView) findViewById(R.id.tv_contents);
        resultLayout = (LinearLayout) findViewById(R.id.results_layout);
        tvOutputLabel = (TextView) findViewById(R.id.tv_results_label);
        buttonSampleOne.setOnClickListener(this);
        buttonSampleTwo.setOnClickListener(this);
        buttonSampleThree.setOnClickListener(this);
        buttonResult.setOnClickListener(this);
        buttonResult.setEnabled(false);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_sample_one:
                hideOutputLayout();
                updateUI(SAMPLE_1);
                break;
            case R.id.button_sample_two:

                hideOutputLayout();
                updateUI(SAMPLE_2);
                break;
            case R.id.button_sample_three:

                hideOutputLayout();
                updateUI(SAMPLE_3);
                break;
            case R.id.btn_result:
                resultLayout.setVisibility(View.VISIBLE);
                tvOutputLabel.setVisibility(View.VISIBLE);

                try {
                    Matrix matrix = MatrixUtils.parseInput(tvDataContent.getText().toString());
                    if (matrix == null) {
                        tvResult.setText("");
                        tvTotalCost.setText("");
                        tvPath.setText("");
                        new AlertDialog.Builder(this)
                                .setTitle(R.string.invalid_content)
                                .setMessage(R.string.invalid_grid_message)
                                .setPositiveButton(R.string.ok, null)
                                .show();
                    } else {
                        CalculateLowestPath calculateLowestPath = new CalculateLowestPath(new PathFinder(50));
                        Result result = calculateLowestPath.calculate(matrix);
                        if (result.isCompleted()) {
                            tvResult.setText(R.string.yes);
                        } else {
                            tvResult.setText(R.string.no);
                        }
                        tvTotalCost.setText(String.valueOf(result.getTotalCost()));
                        tvPath.setText(MatrixUtils.pathToString(result.getPathList()));
                    }
                } catch (InvalidInputException e) {
                    tvResult.setText("");
                    tvTotalCost.setText("");
                    tvPath.setText("");
                    new AlertDialog.Builder(this)
                            .setTitle(R.string.invalid_content)
                            .setMessage(e.getMessage())
                            .setPositiveButton(R.string.ok, null)
                            .show();
                }
                break;
        }

    }

    private void updateUI(int selectedDataSet) {
        buttonResult.setEnabled(true);
        if (this.selectedDataSet != selectedDataSet) {
            clearPreviousData();
        }
        String selectedGrid = null;
        if (selectedDataSet == SAMPLE_1) {
            selectedGrid = AppConstants.SAMPLE_1;
        } else if (selectedDataSet == SAMPLE_2) {
            selectedGrid = AppConstants.SAMPLE_6;
        } else if (selectedDataSet == SAMPLE_3) {
            selectedGrid = AppConstants.SAMPLE_3;
        }
        this.selectedDataSet = selectedDataSet;
        tvDataContent.setText(selectedGrid);


    }

    private void clearPreviousData() {
        tvResult.setText("");
        tvTotalCost.setText(getResources().getText(R.string.no_results));
        tvPath.setText("");
    }

    private void hideOutputLayout() {
        resultLayout.setVisibility(View.GONE);
        tvOutputLabel.setVisibility(View.GONE);
    }
}
