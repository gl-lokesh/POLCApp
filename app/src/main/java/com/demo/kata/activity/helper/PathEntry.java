package com.demo.kata.activity.helper;

/**
 * Created by lokesh_n on 2/9/2017.
 */

public class PathEntry {
    private final Cell coordinates;
    private final Integer value;

    public Cell getCoordinates() {
        return coordinates;
    }

    public Integer getValue() {
        return value;
    }

    public PathEntry(Cell coordinates, Integer value) {
        this.coordinates = coordinates;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PathEntry) {
            PathEntry o1 = (PathEntry) o;
            return o1.getCoordinates().equals(this.getCoordinates()) &&
                    o1.getValue().equals(this.getValue());
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s", coordinates, value);
    }
}
