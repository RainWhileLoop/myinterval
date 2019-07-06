package com.rainwl.myinterval;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author rainw
 */
public class Interval {

    private LocalDate start;
    private LocalDate end;

    public Interval() {
    }

    public Interval(LocalDate start, LocalDate end) {
        this.start = Optional.ofNullable(start).orElse(LocalDate.MIN);
        this.end = Optional.ofNullable(end).orElse(LocalDate.MAX);
        
        if (this.start.isAfter(this.end)) {
            throw new IllegalArgumentException("Cannot set date reversed");
        }
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.start);
        hash = 11 * hash + Objects.hashCode(this.end);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interval other = (Interval) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        return Objects.equals(this.end, other.end);
    }

}