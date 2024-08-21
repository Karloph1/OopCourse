package Figures;

import java.util.Arrays;

public class Main {
    private static void sortFigureAreas(Shape[] shapes) {
        Arrays.sort(shapes, (figure1, figure2) -> (int) (figure2.getArea() - figure1.getArea()));
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Square(24),
                new Rectangle(100, 10),
                new Triangle(-5, 10, 20, 40, 10, -50),
                new Circle(23),
                new Circle(20),
                new Triangle(-100, 0, 0, 100, 2, 2),
                new Rectangle(10, 10)};

        /*
        part 2 tests
         */

        sortFigureAreas(shapes);

        System.out.println("Shape with max area has: width - " + shapes[0].getWidth() +
                "\nheight - " + shapes[0].getHeight() + "\narea - " + shapes[0].getArea() +
                "\nperimeter " + shapes[0].getPerimeter() + "\n");

        System.out.println("Shape with second max area has: width - " + shapes[1].getWidth() +
                "\nheight - " + shapes[1].getHeight() + "\narea - " + shapes[1].getArea() +
                "\nperimeter " + shapes[1].getPerimeter() + "\n");

        /*
        part 3 tests
         */

        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        System.out.println();

        Rectangle comparableFigure = new Rectangle(10, 10);
        for (Shape shape : shapes) {
            if (comparableFigure.equals(shape)) {
                System.out.println("Figures are equal");
            } else {
                System.out.println("Figures are not equal");
            }
        }

        System.out.println();

        for (Shape shape : shapes) {
            System.out.println("Figure hash code is " + shape.hashCode());
        }
    }
}
