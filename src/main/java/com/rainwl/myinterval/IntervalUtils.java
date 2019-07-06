/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rainwl.myinterval;

/**
 *
 * @author rainw
 */
public class IntervalUtils {

    public static boolean isOverlap(Interval i1, Interval i2) {
        if (i1.getStart().isAfter(i2.getStart())
                && i1.getStart().isAfter(i2.getEnd())
                && i1.getEnd().isAfter(i2.getStart())
                && i1.getEnd().isAfter(i2.getEnd())) {
            return false;
        }
        if (i2.getStart().isAfter(i1.getStart())
                && i2.getStart().isAfter(i1.getEnd())
                && i2.getEnd().isAfter(i1.getStart())
                && i2.getEnd().isAfter(i1.getEnd())) {
            return false;
        }
        return true;
    }

}
