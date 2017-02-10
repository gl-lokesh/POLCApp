package com.demo.kata.activity.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class CalculateLowestPath {
    private final PathFinder pathFinder;

    public CalculateLowestPath(PathFinder pathFinder) {
        this.pathFinder = pathFinder;
    }

    /**
     * Method to get and calculate the lowest cost of the given matrix
     *
     * @param matrix input matrix
     * @return output Result
     */
    public Result calculate(Matrix matrix) {
        final List<PathEntry> path = pathFinder.findPath(matrix);
        final Result result = new Result();
        result.setCompleted(path.size() == matrix.getNoOfColumns());
        result.setTotalCost(sumPath(path));
        result.setPathList(getTraversedPath(path));
        return result;
    }

    /**
     * Method to get the traversed path
     *
     * @param path path entry
     * @return list of integer
     */
    private List<Integer> getTraversedPath(List<PathEntry> path) {
        final List<Integer> pathList = new ArrayList<Integer>();
        for (int i = 0; i < path.size(); i++) {
            pathList.add(path.get(i).getCoordinates().getY());
        }
        return pathList;
    }

    /**
     * Method to get and calculate path sum
     *
     * @param path entry path
     * @return total path cost
     */
    private int sumPath(List<PathEntry> path) {
        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i).getValue();
        }
        return sum;
    }
}
