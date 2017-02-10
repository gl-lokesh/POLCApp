package com.demo.kata.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.kata.R;
import com.demo.kata.activity.exception.InvalidInputException;
import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.helper.CalculateLowestPath;
import com.demo.kata.activity.helper.PathFinder;
import com.demo.kata.activity.helper.Result;
import com.demo.kata.activity.utils.MatrixUtils;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class CustomDataSetActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editCustomContent;
    private TextView tvDataSetContent;
    private TextView tvResultSuccess;
    private TextView tvTotalCost;
    private TextView tvPath;
    private TextView tvContentLbl;
    private TextView tvResultLbl;

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
        setContentView(R.layout.activity_custom_data_set);
        editCustomContent = (EditText) findViewById(R.id.edit_custom_data_set);
        tvDataSetContent = (TextView) findViewById(R.id.tv_data_set_content);
        tvResultSuccess = (TextView) findViewById(R.id.tv_results_success);
        tvTotalCost = (TextView) findViewById(R.id.tv_results_total_cost);
        tvPath = (TextView) findViewById(R.id.tv_results_path_taken);
        Button btnShowOutput = (Button) findViewById(R.id.btn_show_output);
        tvContentLbl = (TextView) findViewById(R.id.tv_data_set_label);
        tvResultLbl = (TextView) findViewById(R.id.tv_results_label);
        btnShowOutput.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_show_output) {
            hideKeyboard();
            String gridString = editCustomContent.getText().toString();
            try {
                Matrix graph = MatrixUtils.parseInput(gridString);
                if (graph == null) {
                    tvResultSuccess.setText("");
                    tvTotalCost.setText("");
                    tvPath.setText("");
                    new AlertDialog.Builder(this)
                            .setTitle(R.string.invalid_content)
                            .setMessage(R.string.invalid_grid_message)
                            .setPositiveButton(R.string.ok, null)
                            .show();
                } else {
                    CalculateLowestPath calculateLowestPath = new CalculateLowestPath(new PathFinder(50));
                    Result result = calculateLowestPath.calculate(graph);
                    if (result.isCompleted()) {
                        tvResultSuccess.setText(R.string.yes);
                    } else {
                        tvResultSuccess.setText(R.string.no);
                    }
                    tvTotalCost.setText(String.valueOf(result.getTotalCost()));
                    tvPath.setText(MatrixUtils.pathToString(result.getPathList()));

                }
            } catch (InvalidInputException e) {
                tvResultSuccess.setText("");
                tvTotalCost.setText("");
                tvPath.setText("");
                new AlertDialog.Builder(this)
                        .setTitle(R.string.invalid_content)
                        .setMessage(e.getMessage())
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        }

    }

    /**
     * Hides the  keyboard.
     * activity Current activity instance
     */

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editCustomContent.getWindowToken(), 0);
    }
}
