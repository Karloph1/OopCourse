package Range;

import java.util.ArrayList;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double point) {
        final double epsilon = 1.0e-10;

        return from - point <= epsilon && point - to <= epsilon;
    }

    public Range getRangesIntersection(Range range) {
        final double epsilon = 1.0e-10;

        Range minRange = this.getLength() - range.getLength() > epsilon ? range : this;
        Range maxRange = Math.abs(range.getLength() - minRange.getLength()) > epsilon ? range : this;

        if (maxRange.isInside(minRange.from) && maxRange.isInside(minRange.to)) {
            return new Range(minRange.from, minRange.to);
        } else if (maxRange.isInside(minRange.from) && Math.abs(minRange.from - maxRange.to) > epsilon) {
            return new Range(minRange.from, maxRange.to);
        } else if (maxRange.isInside(minRange.to) && Math.abs(maxRange.from - minRange.to) > epsilon) {
            return new Range(maxRange.from, minRange.to);
        }

        return null;
    }

    public ArrayList<Range> getRangesAssociation(Range range) {
        ArrayList<Range> rangeList = new ArrayList<>();
        final double epsilon = 1.0e-10;

        Range minRange = this.getLength() - range.getLength() > epsilon ? range : this;
        Range maxRange = Math.abs(range.getLength() - minRange.getLength()) > epsilon ? range : this;

        if (!maxRange.isInside(minRange.from) && !maxRange.isInside(minRange.to)) {
            if (maxRange.from - minRange.from > epsilon) {
                rangeList.add(minRange);
                rangeList.add(maxRange);
            } else {
                rangeList.add(maxRange);
                rangeList.add(minRange);
            }
        } else {
            Range newRange = new Range(Math.min(this.from, range.from), Math.max(this.to, range.to));
            rangeList.add(newRange);
        }

        return rangeList;
    }

    public ArrayList<Range> getRangesDifference(Range range) {
        ArrayList<Range> rangeList = new ArrayList<>();
        final double epsilon = 1.0e-10;

        if (this.isInside(range.from) && this.isInside(range.to)) {
            rangeList.add(new Range(this.from, range.from));
            rangeList.add(new Range(range.to, this.to));
        } else if (this.isInside(range.from) && Math.abs(this.to - range.from) > epsilon) {
            rangeList.add(new Range(this.from, range.from));
        } else if (this.isInside(range.to) && Math.abs(this.from - range.to) > epsilon) {
            rangeList.add(new Range(range.to, this.to));
        } else {
            rangeList.add(this);
        }

        return rangeList;
    }
}