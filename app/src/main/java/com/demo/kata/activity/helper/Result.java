package com.demo.kata.activity.helper;

import java.util.List;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class Result {
    private boolean completed;
    private int totalCost;
    private List<Integer> pathList;

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setPathList(List<Integer> pathList) {
        this.pathList = pathList;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public List<Integer> getPathList() {
        return pathList;
    }
}
