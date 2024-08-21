package Figures;

public class Square implements Shape {
    private final double length;

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getWidth() {
        return length;
    }

    @Override
    public double getHeight() {
        return length;
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    @Override
    public String toString() {
        return "[" + length + "]";
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int hash = 1;
        hash = PRIME * hash + Double.hashCode(length);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) obj;

        return square.length == length;
    }
}
