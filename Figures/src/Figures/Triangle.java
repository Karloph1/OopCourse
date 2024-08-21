package Figures;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
    }

    @Override
    public double getHeight() {
        return Math.max(y1, Math.max(y2, y3)) - Math.min(y1, Math.min(y2, y3));
    }

    @Override
    public double getArea() {
        double a = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        double halfPerimeter = (a + b + c) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }

    @Override
    public double getPerimeter() {
        double a = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        return a + b + c;
    }

    @Override
    public String toString() {
        return "[" + x1 + ", " + y1 + "; " + x2 + ", " + y2 + "; " + x3 + ", " + y3 + "]";
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int hash = 1;
        hash = PRIME * hash + Double.hashCode(x1);
        hash = PRIME * hash + Double.hashCode(y1);
        hash = PRIME * hash + Double.hashCode(x2);
        hash = PRIME * hash + Double.hashCode(y2);
        hash = PRIME * hash + Double.hashCode(x3);
        hash = PRIME * hash + Double.hashCode(y3);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;

        return triangle.x1 == x1 && triangle.x2 == x2 && triangle.x3 == x3 &&
                triangle.y1 == y1 && triangle.y2 == y2 && triangle.y3 == y3;
    }
}
