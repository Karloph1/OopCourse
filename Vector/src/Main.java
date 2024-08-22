public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(10);
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector3 = new Vector(5, new double[]{9, -10, 4});
        Vector vector4 = new Vector(vector2);

        System.out.println("Component of vector is " + vector4.getComponent(2));
        vector2.setComponent(1, 3);

        System.out.println("Size of first vector is " + vector1.getSize());
        System.out.println("First vector is " + vector1);
        System.out.println("Second vector is " + vector2);
        System.out.println("Third vector is " + vector3);
        System.out.println("Fourth vector is " + vector4);

        System.out.println();

        vector1.subVector(vector3);
        vector1.addVector(vector2);
        System.out.println("First vector after addiction and subtraction is " + vector1);

        vector3.rotateVector();
        System.out.println("Third vector after inverting is " + vector3);

        vector4.scalarMultiplication(5);
        System.out.println("Fourth vector after multiply to scalar is " + vector4);

        System.out.println("Length of second vector is " + vector2.getVectorLength());

        Vector vector5 = new Vector(new double[]{1, 3, 3, 4});

        if (vector2.equals(vector5)) {
            System.out.println("Vectors are equal");
        } else {
            System.out.println("Vectors are not equal");
        }

        System.out.println("Hash code of vector is " + vector4.hashCode());

        System.out.println();

        Vector vector6 = Vector.vectorAddition(vector1, vector2);
        System.out.println("Addition of first and second vectors is " + vector6);

        System.out.println("Subtraction of second and third vectors is " + Vector.vectorSubtraction(vector2, vector3));

        System.out.println("Dot product of vectors is " + Vector.getDotProduct(vector1, vector6));
    }
}
