package com.demo.kata.activity.helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class PathFinder {
    private final int maxCost;

    public PathFinder() {
        this(Integer.MAX_VALUE);
    }

    public PathFinder(int maxCost) {
        this.maxCost = maxCost;
    }

    /**
     * Method to get and find the best available path for given matrix
     *
     * @param matrix input matrix
     * @return best path entry
     */
    public List<PathEntry> findPath(Matrix matrix) {
        List<PathEntry> bestPath = null;
        for (int i = 0; i < matrix.getNoOfRows(); i++) {
            final Cell cell = new Cell();
            cell.setX(1);
            cell.setY(i + 1);
            List<PathEntry> currentPath = findPath(matrix, cell, new ArrayList<PathEntry>());
            if (bestPath == null || sumPath(currentPath) < sumPath(bestPath)) {
                bestPath = currentPath;
            }
        }

        return bestPath;
    }

    /**
     * Method to get and find the best available path
     *
     * @param matrix inputmatrix
     * @param cells  current cell
     * @param path   list of paths
     * @return path entry
     */
    private List<PathEntry> findPath(Matrix matrix, Cell cells, List<PathEntry> path) {
        if (cells == null) {
            return path;
        }
        final List<PathEntry> currentPath = new ArrayList<>(path);
        int nextCost = matrix.getCost(cells);

        if (sumPath(currentPath) + nextCost > maxCost || cells.getX() > matrix.getNoOfColumns()) {
            return currentPath;
        }
        currentPath.add(new PathEntry(cells, nextCost));

        List<PathEntry> upRight = findPath(matrix, matrix.getDiagonalUp(cells), currentPath);
        List<PathEntry> straightRight = findPath(matrix, matrix.getRight(cells), currentPath);
        List<PathEntry> downRight = findPath(matrix, matrix.getDiagonalDown(cells), currentPath);

        return findBestPath(upRight, straightRight, downRight);
    }

    /**
     * Method to get and finds the best path entry from up, down and right
     *
     * @param up    diagonal up path entry list
     * @param right diagonal right path entry list
     * @param down  diagonal down path entry list
     * @return calculate and return best available path
     */
    private List<PathEntry> findBestPath(List<PathEntry> up, List<PathEntry> right, List<PathEntry> down) {
        Log.d("findBestPath", "up = " + up.toString());
        Log.d("findBestPath", "right = " + right.toString());
        Log.d("findBestPath", "down = " + down.toString());
        List<PathEntry> bestOfUpAndRight = bestOfTwo(up, right);
        return bestOfTwo(bestOfUpAndRight, down);
    }

    /**
     * Method to calculate and find best path from two path entries
     *
     * @param p1 diagonal path entry
     * @param p2 diagonal path entry
     * @return best path among two path entries
     */
    private List<PathEntry> bestOfTwo(List<PathEntry> p1, List<PathEntry> p2) {
        if (p1.size() == p2.size()) {
            if (sumPath(p1) < sumPath(p2)) {
                return p1;
            }
            return p2;
        }

        if (p1.size() > p2.size()) {
            return p1;
        }
        return p2;
    }

    /**
     * method to get cost of the given path
     */
    private int sumPath(List<PathEntry> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i).getValue();
        }
        return sum;
    }

    /**
     * Method returning max cost
     */
    public int getMaxCost() {
        return maxCost;
    }
}
