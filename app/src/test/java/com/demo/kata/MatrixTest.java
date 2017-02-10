package com.demo.kata;

import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.helper.Cell;

import org.hamcrest.Matchers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class MatrixTest {

    @Test
    public void getRight_returnsStraightRightValue() {
        Cell cell = new Cell();
        cell.setX(1);
        cell.setY(1);
        Cell result = new Matrix(singletonList(asList(1, 2))).getRight(cell);
        cell.setX(2);
        cell.setY(1);
        assertThat(result, Matchers.is(cell));
    }

    @Test
    public void getRight_returnsNullWhenAtEndOfRow() {
        Cell cell = new Cell();
        cell.setX(2);
        cell.setY(1);
        Cell result = new Matrix(singletonList(asList(1, 1))).getRight(cell);
        assertNull(result);
    }


    @Test
    public void getDiagonalUp_returnsUpRightMatrixCells() {
        Cell cell = new Cell();
        cell.setX(2);
        cell.setY(2);
        Cell result =
                new Matrix(asList(
                        asList(1, 1, 2),
                        asList(1, 1, 1)
                )).getDiagonalUp(cell);
        cell.setX(3);
        cell.setY(1);
        assertThat(result, Matchers.is(cell));
    }

    @Test
    public void getDiagonalUp_returnsRightForXAndLastRowForYMatrixCells_whenCurrentMatrixCellsAreTopRow() {
        Cell cell = new Cell();
        cell.setX(2);
        cell.setY(1);
        Cell result =
                new Matrix(asList(
                        asList(1, 1, 2),
                        asList(1, 1, 1),
                        asList(1, 1, 1)
                )).getDiagonalUp(cell);
        cell.setX(3);
        cell.setY(3);
        assertThat(result, Matchers.is(cell));
    }

    @Test
    public void checkNoOfRowsInMatrix() {
        Matrix result = new Matrix(asList(asList(3, 5, 2, 5, 6), asList(7, 4, 2, 1, 8)));
        assertThat(result.getNoOfRows(), equalTo(2));
        result = new Matrix(asList(asList(3, 5, 2, 5, 6, 2, 3, 5, 2, 5, 6), asList(7, 4, 2, 1, 8, 2, 7, 4, 2, 1, 8),
                asList(1, 5, 2, 4, 6, 2, 7, 5, 8, 6, 1)));
        assertThat(result.getNoOfRows(), equalTo(3));
    }

    @Test
    public void checkNoOfColumnInMatrix() {
        Matrix result = new Matrix(asList(asList(3, 5, 2, 5, 6), asList(7, 4, 2, 1, 8)));
        assertThat(result.getNoOfColumns(), equalTo(5));
        result = new Matrix(asList(asList(3, 5, 2, 5, 6, 2, 3, 5, 2, 5, 6), asList(7, 4, 2, 1, 8, 2, 7, 4, 2, 1, 8),
                asList(1, 5, 2, 4, 6, 2, 7, 5, 8, 6, 1)));
        assertThat(result.getNoOfColumns(), equalTo(11));
    }

    @Test
    public void checkValueAtRowAndColumn() {
        Matrix result = new Matrix(asList(asList(3, 5, 2, 5, 6), asList(7, 4, 2, 1, 8)));
        Cell cell = new Cell();
        cell.setX(1);
        cell.setY(2);
        assertThat(result.getCost(cell), equalTo(7));
        cell.setX(2);
        cell.setY(1);
        assertThat(result.getCost(cell), equalTo(5));
    }


    @Test
    public void getDiagonalDown_returnsDownRightMatrixCells() {
        Cell cell = new Cell();
        cell.setX(2);
        cell.setY(1);
        Cell result =
                new Matrix(asList(
                        asList(1, 1, 2),
                        asList(1, 1, 1)
                )).getDiagonalDown(cell);
        cell.setX(3);
        cell.setY(2);
        assertThat(result, Matchers.is(cell));
    }

    @Test
    public void getDiagonalDown_returnsRightForXAndFirstRowForYMatrixCells_whenCurrentMatrixCellsAreBottomRow() {
        Cell cell = new Cell();
        cell.setX(2);
        cell.setY(3);
        Cell result =
                new Matrix(asList(
                        asList(1, 1, 2),
                        asList(1, 1, 1),
                        asList(1, 1, 1)
                )).getDiagonalDown(cell);
        cell.setX(3);
        cell.setY(1);
        assertThat(result, Matchers.is(cell));
    }

    @Test
    public void getCost_returns_theCorrectValue() {
        Matrix Matrix = new Matrix(asList(
                asList(1, 2, 3),
                asList(4, 5, 6),
                asList(7, 8, 9)
        ));
        Cell cell = new Cell();
        cell.setX(1);
        cell.setY(1);
        assertThat(Matrix.getCost(cell), Matchers.is(1));
        cell.setX(2);
        cell.setY(1);
        assertThat(Matrix.getCost(cell), Matchers.is(2));
        cell.setX(3);
        cell.setY(1);
        assertThat(Matrix.getCost(cell), Matchers.is(3));
        cell.setX(1);
        cell.setY(2);
        assertThat(Matrix.getCost(cell), Matchers.is(4));
        cell.setX(2);
        cell.setY(2);
        assertThat(Matrix.getCost(cell), Matchers.is(5));
        cell.setX(3);
        cell.setY(2);
        assertThat(Matrix.getCost(cell), Matchers.is(6));
        cell.setX(1);
        cell.setY(3);
        assertThat(Matrix.getCost(cell), Matchers.is(7));
        cell.setX(2);
        cell.setY(3);
        assertThat(Matrix.getCost(cell), Matchers.is(8));
        cell.setX(3);
        cell.setY(3);
        assertThat(Matrix.getCost(cell), Matchers.is(9));
    }

    @Test
    public void getHeight_returns_theCorrectValue() {
        int height = new Matrix(asList(
                asList(1, 2),
                asList(4, 5),
                asList(7, 8)
        )).getNoOfRows();

        assertThat(height, Matchers.is(3));
    }

    @Test
    public void getWidth_returns_theCorrectValue() {
        int width = new Matrix(asList(
                asList(1, 2),
                asList(4, 5),
                asList(7, 8)
        )).getNoOfColumns();

        assertThat(width, Matchers.is(2));
    }
}
