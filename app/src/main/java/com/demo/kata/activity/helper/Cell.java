package com.demo.kata.activity.helper;

/**
 * Created by lokesh_n on 2/9/2017.
 */
public class Cell {
    private int x;
    private int y;

    public Cell(){

    }
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell toCompare = (Cell) obj;
            return this.x == toCompare.getX() && this.y == toCompare.getY();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
