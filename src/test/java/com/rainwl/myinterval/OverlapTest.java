package com.rainwl.myinterval;

import com.rainwl.myinterval.IntervalUtils;
import com.rainwl.myinterval.Interval;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rainw
 */
public class OverlapTest {

    public OverlapTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void startAndEndSameDate_Success() {
        new Interval(LocalDate.of(2019, Month.JULY, 5), LocalDate.of(2019, Month.JULY, 5));
    }

    @Test
    public void reverseDate_ThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Interval(LocalDate.of(2019, Month.JULY, 5), LocalDate.of(2019, Month.JULY, 4)));
    }

    @Test
    public void twoIntervals_NotOverlap() {
        assertFalse(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 6)),
                new Interval(LocalDate.of(2019, Month.JULY, 7), LocalDate.of(2019, Month.JULY, 11))));
        assertFalse(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.AUGUST, 6)),
                new Interval(LocalDate.of(2019, Month.SEPTEMBER, 1), LocalDate.of(2019, Month.SEPTEMBER, 11))));
        assertFalse(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 1)),
                new Interval(LocalDate.of(2019, Month.JULY, 2), LocalDate.of(2019, Month.JULY, 3))));
        assertFalse(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 2), LocalDate.of(2019, Month.JULY, 3)),
                new Interval(LocalDate.of(2019, Month.JUNE, 25), LocalDate.of(2019, Month.JUNE, 30))));
        assertFalse(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 1)),
                new Interval(LocalDate.of(2019, Month.JUNE, 30), LocalDate.of(2019, Month.JUNE, 30))));
    }
    
    @Test
    public void twoIntervals_Overlap() {
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 10), LocalDate.of(2019, Month.JULY, 20)),
                new Interval(LocalDate.of(2019, Month.JULY, 15), LocalDate.of(2019, Month.JULY, 25))));
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 10), LocalDate.of(2019, Month.JULY, 20)),
                new Interval(LocalDate.of(2019, Month.JULY, 10), LocalDate.of(2019, Month.JULY, 10))));
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 10), LocalDate.of(2019, Month.JULY, 20)),
                new Interval(LocalDate.of(2019, Month.JUNE, 5), LocalDate.of(2019, Month.JULY, 15))));
        
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JUNE, 10), LocalDate.of(2019, Month.JUNE, 20)),
                new Interval(LocalDate.of(2019, Month.JUNE, 20), LocalDate.of(2019, Month.JUNE, 30))));
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JULY, 10), LocalDate.of(2019, Month.JULY, 20)),
                new Interval(LocalDate.of(2019, Month.JUNE, 12), LocalDate.of(2019, Month.JULY, 18))));
        assertTrue(IntervalUtils.isOverlap(
                new Interval(LocalDate.of(2019, Month.JUNE, 10), LocalDate.of(2019, Month.JUNE, 20)),
                new Interval(LocalDate.of(2019, Month.JUNE, 5), LocalDate.of(2019, Month.JUNE, 10))));
    }
}
