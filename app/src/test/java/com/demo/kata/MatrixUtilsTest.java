package com.demo.kata;

import com.demo.kata.activity.exception.InvalidInputException;
import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.utils.MatrixUtils;

import org.hamcrest.Matchers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class MatrixUtilsTest {
    @Test
    public void parseInput_oneRowOfIntegers_returns_correctCostMatrix() {
        Matrix expected = new Matrix(singletonList(asList(1, 2, 3, 4, 5)));
        Matrix actual = MatrixUtils.parseInput("1 2 3 4 5");
        assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void parseInput_multipleRowsOfIntegers_returns_correctCostMatrix() {
        Matrix expected = new Matrix(asList(
                asList(1, 2, 3, 4, 5),
                asList(6, 7, 8, 9, 10)
        ));

        Matrix actual = MatrixUtils.parseInput("1 2 3 4 5\n6 7 8 9 10");
        assertThat(actual, Matchers.is(expected));
    }

    @Test
    public void parseInput_multipleRows_correctIntegers() {
        Matrix expected = new Matrix(asList(asList(5, 6, 7, 8, 9), asList(4, 2, 3, 4, 5)));
        String stringData = "5 6 7 8 9\n4 2 3 4 5";
        Matrix actual = MatrixUtils.parseInput(stringData);
        assertThat(actual, Matchers.is(expected));

    }
    @Test
    public void parseInput_negativeIntegers_returns_exception() {
        Matrix expected = new Matrix(asList(asList(-5, 6, -7, -8, -9), asList(-4, 0, 3, -4, -5)));
        String stringData = "-5 6 -7 -8 -9\n-4 0 3 -4 -5";
        Matrix actual = MatrixUtils.parseInput(stringData);
        assertThat(actual, Matchers.is(expected));
    }

    @Test(expected = InvalidInputException.class)
    public void parseInput_throwsExceptionIfNotAllValuesAreIntegers() {
        MatrixUtils.parseInput("1 2 foo 4");
    }

    @Test(expected = InvalidInputException.class)
    public void parseInput_throwsExceptionIfNotAllRowsAreSameSize() {
        MatrixUtils.parseInput("1 2 3\n3 2 1 1");
    }
}
