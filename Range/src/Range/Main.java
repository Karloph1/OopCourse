package Range;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
            Range tests
         */

        Range range = new Range(-1200, 15921.1);

        System.out.println("Bottom border is " + range.getFrom());

        range.setTo(1900);
        System.out.println("Top border is " + range.getTo());

        System.out.println("Range of diapason is " + range.getLength());

        double point = -120.122;

        System.out.println("Point is " + point);

        if (range.isInside(point)) {
            System.out.println("Point is in range");
        } else {
            System.out.println("Point is not in range");
        }

        range.setFrom(-130);
        System.out.println("Bottom border changed to " + range.getFrom());

        if (range.isInside(point)) {
            System.out.println("Now point is in range");
        } else {
            System.out.println("Point is still not in range");
        }

        System.out.println();

        /*
            Range* tests
         */

        range.setFrom(-100);
        range.setTo(100);

        Range range1 = new Range(1, 5);
        Range range2 = new Range(-200, -150);
        Range range3 = new Range(-200, -100);
        Range range4 = new Range(10, 1000);

        ArrayList<Range> ranges = new ArrayList<>();
        ranges.add(range1);
        ranges.add(range2);
        ranges.add(range3);
        ranges.add(range4);

        for (Range segment : ranges) {
            Range intersectionRange = range.getRangesIntersection(segment);
            if (intersectionRange != null) {
                System.out.println("Intersection range borders are: " + intersectionRange.getFrom() + " and "
                        + intersectionRange.getTo());
            } else {
                System.out.println("Impossible to calculate");
            }
        }

        System.out.println();

        for (Range segment : ranges) {
            ArrayList<Range> associationRange = range.getRangesAssociation(segment);
            System.out.println("Amount of ranges after association are: " + associationRange.size());
        }

        System.out.println();

        for (Range segment : ranges) {
            ArrayList<Range> differenceRange = range.getRangesDifference(segment);
            System.out.println("Amount of ranges after difference are: " + differenceRange.size());
        }
    }
}
