package com.demo.kata;

import com.demo.kata.activity.helper.Cell;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class CellsTest {
    @Test
    public void equals_returnsTrue_when_coordinatesAreEqual() {
        Cell c1 = new Cell();
        c1.setX(1);
        c1.setY(1);
        Cell c2 = new Cell();
        c2.setX(1);
        c2.setY(1);
        assertThat(c1, Matchers.is(c2));
    }

    @Test
    public void equals_returnsFalse_when_coordinatesAreNotEqual() {
        Cell c1 = new Cell();
        Cell c2 = new Cell();
        c1.setX(1);
        c1.setY(1);
        c2.setX(1);
        c2.setY(2);
        assertThat(c1, Matchers.not(Matchers.is(c2)));
        c1.setX(1);
        c1.setY(1);
        c2.setX(2);
        c2.setY(1);
        assertThat(c1, Matchers.not(Matchers.is(c2)));
        assertThat(c1, Matchers.not(Matchers.is(c2)));
        assertThat(c1, Matchers.not(Matchers.is(new Object())));
    }
}
