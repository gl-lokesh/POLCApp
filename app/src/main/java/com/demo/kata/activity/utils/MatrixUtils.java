package com.demo.kata.activity.utils;

import android.text.TextUtils;

import com.demo.kata.activity.exception.InvalidInputException;
import com.demo.kata.activity.helper.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class MatrixUtils {
    /**
     * Matrix converter from user input to NxM integer matrix.
     * User will input the matrix using SPACE as Column separator and new line(\n) for row separator
     * This helper class will split the user input row wise first and then column wise
     * if there any wrong input by throwing InvalidInputException
     */
    public static Matrix parseInput(String input) {
        if (!TextUtils.isEmpty(input)) {
            final List<List<Integer>> output = new ArrayList<List<Integer>>();
            final List<String> rows = Arrays.asList(input.split("\n"));

            int validColumnLength = 0;
            for (int row = 0; row < rows.size(); row++) {
                final List<String> columns = Arrays.asList(rows.get(row).split(" "));
                if (validColumnLength == 0) {
                    validColumnLength = columns.size();
                }
                if (columns.size() != validColumnLength) {
                    throw new InvalidInputException("All rows must have the same length");
                }
                final List<Integer> columnList = new ArrayList<Integer>();
                for (int column = 0; column < columns.size(); column++) {
                    try {
                        columnList.add(Integer.parseInt(columns.get(column)));
                    } catch (NumberFormatException e) {
                        throw new InvalidInputException("All values must be integers.");
                    }
                }
                output.add(columnList);

            }
          /*  if (output.size() < 1 || output.size() > 10) {
                throw new InvalidInputException("Number of rows should be between 1 and 10");
            } else if (output.get(0).size() < 5 || output.get(0).size() > 100) {
                throw new InvalidInputException("Number of columns should be between 5 and 100");
            }*/
            return new Matrix(output);

        } else {
            return null;
        }
    }

    /**
     * Method to format the display
     *
     * @return formatted  string
     */

    public static String formatString(int[][] values) {
        final StringBuilder builder = new StringBuilder();
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                builder.append(values[row][column]);
                if (column < values[row].length - 1) {
                    builder.append("\t");
                }
            }
            if (row < values.length - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    public static String pathToString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
