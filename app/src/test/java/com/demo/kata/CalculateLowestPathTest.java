package com.demo.kata;

import com.demo.kata.activity.exception.InvalidInputException;
import com.demo.kata.activity.helper.CalculateLowestPath;
import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.helper.PathFinder;
import com.demo.kata.activity.helper.Result;
import com.demo.kata.activity.utils.AppConstants;
import com.demo.kata.activity.utils.MatrixUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class CalculateLowestPathTest {
    private CalculateLowestPath calculateLowestPath = new CalculateLowestPath(new PathFinder(50));

    @Test
    public void test_6X5MatrixNormalFlowExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_1);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(16));
    }

    @Test
    public void test_6X5MatrixNormalFlowExampleTwo() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_2);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(11));
    }
    @Test
    public void test_5X3MatrixWithNoPathExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_3);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(false));
        assertThat(result.getTotalCost(), equalTo(48));
    }
    @Test
    public void test_1X5MatrixExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_4);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(26));
    }
    @Test//(expected = InvalidInputException.class)
    public void test_5X1MatrixExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_5);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(3));
    }

    @Test(expected = InvalidInputException.class)
    public void test_NonNumericInputExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_6);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(3));
    }

    @Test(expected = InvalidInputException.class)
    public void test_NoInputExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_6);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(3));
    }

    @Test
    public void test_StaringWithMaxCostExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_8);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(false));
        assertThat(result.getTotalCost(), equalTo(0));
    }

    @Test//(expected = InvalidInputException.class)
    public void test_OneValueGreaterThanMaxCostExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_9);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(false));
        assertThat(result.getTotalCost(), equalTo(0));
    }

//    @Test(expected = InvalidInputException.class)
    @Test
    public void test_NegativeValuesExample() {
        Matrix matrix = MatrixUtils.parseInput(AppConstants.SAMPLE_10);
        Result result = calculateLowestPath.calculate(matrix);
        assertThat(result.isCompleted(), is(true));
        assertThat(result.getTotalCost(), equalTo(0));
    }
}
