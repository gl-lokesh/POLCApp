package com.demo.kata.activity.helper;

import java.util.List;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class Matrix {
    private final List<List<Integer>> lowestCostMatrix;

    public Matrix(List<List<Integer>> lowestCostMatrix) {
        this.lowestCostMatrix = lowestCostMatrix;
    }

    /**
     * Method returning  right cell
     *
     * @param cells traversed row
     * @return if right cell null return null otherwise it will return right of the current cell
     */
    public Cell getRight(Cell cells) {
        if (cells.getX() + 1 > lowestCostMatrix.get(cells.getY() - 1).size()) {
            return null;
        }
        final Cell cell = new Cell();
        cell.setX(cells.getX() + 1);
        cell.setY(cells.getY());
        return cell;
    }

    /**
     * Method returning  Diagonal up cell
     *
     * @param cells traversed node
     * @return if right cell null return null otherwise diagonal cell
     */
    public Cell getDiagonalUp(Cell cells) {
        Cell right = getRight(cells);
        if (right == null) {
            return null;
        }

        int y = cells.getY() - 1;
        final Cell cell = new Cell();
        cell.setX(right.getX());
        cell.setY(y == 0 ? lowestCostMatrix.size() : y);
        return cell;
    }


    /**
     * Method returning Diagonal up cell
     *
     * @param cells
     * @return if right cell null return null otherwise diagonal cell
     */
    public Cell getDiagonalDown(Cell cells) {
        Cell right = getRight(cells);
        if (right == null)
            return null;
        int y = cells.getY() + 1;
        final Cell cell = new Cell();
        cell.setX(right.getX());
        cell.setY(y > lowestCostMatrix.size() ? 1 : y);
        return cell;
    }


    public int getCost(Cell cells) {
        return lowestCostMatrix.get(cells.getY() - 1).get(cells.getX() - 1);
    }

    /**
     * Method returning number of columns in Matrix
     *
     * @return total number of column in Matrix
     */
    public int getNoOfColumns() {
        return lowestCostMatrix.get(0).size();
    }

    /**
     * Method returning number of rows in Matrix
     *
     * @return total number of rows in Matrix
     */
    public int getNoOfRows() {
        return lowestCostMatrix.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Matrix) {
            Matrix o1 = (Matrix) o;
            for (int i = 0; i < o1.lowestCostMatrix.size(); i++) {
                final List<Integer> curentRow = this.lowestCostMatrix.get(i);
                final List<Integer> compareRow = o1.lowestCostMatrix.get(i);
                for (int x = 0; x < compareRow.size(); x++) {
                    if (curentRow.get(x) != compareRow.get(x)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
