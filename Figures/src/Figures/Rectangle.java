package Figures;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public String toString() {
        return "[" + width + ", " + height + "]";
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int hash = 1;
        hash = PRIME * hash + Double.hashCode(width);
        hash = PRIME * hash + Double.hashCode(height);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;

        return rectangle.width == width && rectangle.height == height;
    }
}
