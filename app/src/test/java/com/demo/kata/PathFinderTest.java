package com.demo.kata;

import com.demo.kata.activity.helper.Matrix;
import com.demo.kata.activity.helper.PathEntry;
import com.demo.kata.activity.helper.PathFinder;
import com.demo.kata.activity.helper.Cell;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by lokesh_n on 2/10/2017.
 */

public class PathFinderTest {
    private PathFinder pathFinder = new PathFinder(50);

    @Test
    public void constructor_setsMaxResistanceToMaxInteger_when_noValueIsSupplied() {
        assertEquals(Integer.MAX_VALUE, new PathFinder().getMaxCost());
    }

    @Test
    public void constructor_setsMaxResistanceToPassedValue_when_valueIsPassed() {
        assertEquals(50, new PathFinder(50).getMaxCost());
    }

    @Test
    public void findPath_given1x1_returnsCorrectPath() {
        Matrix costMatrix = new Matrix(singletonList(singletonList(1)));

        List<PathEntry> expected = singletonList(
                new PathEntry(new Cell(1, 1), 1)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void findPath_given1x5_returnsCorrectPath() {
        Matrix costMatrix = new Matrix(singletonList(asList(1, 2, 3, 4, 5)));

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 1),
                new PathEntry(new Cell(2, 1), 2),
                new PathEntry(new Cell(3, 1), 3),
                new PathEntry(new Cell(4, 1), 4),
                new PathEntry(new Cell(5, 1), 5)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void findPath_given2x5_returnsCorrectPath() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(1, 2, 2, 2, 1),
                        asList(2, 1, 1, 1, 2))
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 1),
                new PathEntry(new Cell(2, 2), 1),
                new PathEntry(new Cell(3, 2), 1),
                new PathEntry(new Cell(4, 2), 1),
                new PathEntry(new Cell(5, 1), 1)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void findPath_given5x5_returnsCorrectPath() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(1, 2, 3, 4, 5),
                        asList(3, 4, 2, 1, 5),
                        asList(5, 6, 3, 2, 3),
                        asList(6, 1, 2, 1, 1),
                        asList(9, 2, 1, 4, 5)
                )
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 1),
                new PathEntry(new Cell(2, 1), 2),
                new PathEntry(new Cell(3, 5), 1),
                new PathEntry(new Cell(4, 4), 1),
                new PathEntry(new Cell(5, 4), 1)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void findPath_given10x10_returnsCorrectPath() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(5, 1, 5, 1, 5, 5, 5, 5, 5, 5),
                        asList(1, 5, 5, 5, 1, 5, 5, 5, 5, 1),
                        asList(5, 5, 5, 5, 5, 1, 5, 5, 1, 5),
                        asList(5, 5, 5, 5, 5, 5, 1, 1, 5, 5),
                        asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
                        asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
                        asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
                        asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
                        asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
                        asList(5, 5, 1, 5, 5, 5, 5, 5, 5, 5)
                )
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 2), 1),
                new PathEntry(new Cell(2, 1), 1),
                new PathEntry(new Cell(3, 10), 1),
                new PathEntry(new Cell(4, 1), 1),
                new PathEntry(new Cell(5, 2), 1),
                new PathEntry(new Cell(6, 3), 1),
                new PathEntry(new Cell(7, 4), 1),
                new PathEntry(new Cell(8, 4), 1),
                new PathEntry(new Cell(9, 3), 1),
                new PathEntry(new Cell(10, 2), 1)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void findPath_given1x5_thatExceedsMaxResistance_returnsCorrectPathUnderMaxResistance() {
        PathFinder pathFinder = new PathFinder(10);

        Matrix costMatrix = new Matrix(singletonList(asList(5, 4, 3, 2, 1)));

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 5),
                new PathEntry(new Cell(2, 1), 4)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void kata_example_one() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(3, 4, 1, 2, 8, 6),
                        asList(6, 1, 8, 2, 7, 4),
                        asList(5, 9, 3, 9, 9, 5),
                        asList(8, 4, 1, 3, 2, 6),
                        asList(3, 7, 2, 8, 6, 4)
                )
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 3),
                new PathEntry(new Cell(2, 2), 1),
                new PathEntry(new Cell(3, 3), 3),
                new PathEntry(new Cell(4, 4), 3),
                new PathEntry(new Cell(5, 4), 2),
                new PathEntry(new Cell(6, 5), 4)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void kata_example_two() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(3, 4, 1, 2, 8, 6),
                        asList(6, 1, 8, 2, 7, 4),
                        asList(5, 9, 3, 9, 9, 5),
                        asList(8, 4, 1, 3, 2, 6),
                        asList(3, 7, 2, 1, 2, 3)
                )
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 3),
                new PathEntry(new Cell(2, 2), 1),
                new PathEntry(new Cell(3, 1), 1),
                new PathEntry(new Cell(4, 5), 1),
                new PathEntry(new Cell(5, 5), 2),
                new PathEntry(new Cell(6, 5), 3)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    @Test
    public void kata_example_three() {
        Matrix costMatrix = new Matrix(
                asList(
                        asList(19,10,19,10,19),
                        asList(21,23,20,19,12),
                        asList(20,12,20,11,10)
                )
        );

        List<PathEntry> expected = asList(
                new PathEntry(new Cell(1, 1), 19),
                new PathEntry(new Cell(2, 1), 10),
                new PathEntry(new Cell(3, 1), 19)
        );

        assertListsAreEqual(pathFinder.findPath(costMatrix), expected);
    }

    private void assertListsAreEqual(List<PathEntry> i1, List<PathEntry> i2) {
        assertThat(i1.size(), Matchers.is(i2.size()));

        for (int i = 0; i < i1.size(); i++) {
            assertThat(i1.get(i), Matchers.is(i2.get(i)));
        }
    }
}
