import Vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(4, 5);

        double[][] d = new double[][]{{1, 2, 3}, {2, 3, 4, 8}, {5, 6, 7, 10, 99}};
        Matrix matrix3 = new Matrix(d);

        Matrix matrix2 = new Matrix(matrix3);

        Vector[] vectors = new Vector[]{new Vector(5), new Vector(new double[]{1, 2, 4, 9}), new Vector(6, new double[]{1, 2, 4, 1})};
        Matrix matrix4 = new Matrix(vectors);

        System.out.println("Length and width of first matrix are: " + matrix1.getN() + " " + matrix1.getM());
        System.out.println("First matrix is " + matrix1);
        System.out.println("Second matrix is " + matrix2);
        System.out.println("Third matrix is " + matrix3);
        System.out.println("Fourth matrix is " + matrix4);

        System.out.println();

        matrix4.setVectorLine(1, new Vector(new double[]{1, 4, 8, -10, 9, -1}));
        System.out.println("After change vector in fourth matrix is " + matrix4.getVectorLine(1));

        System.out.println("Column in third matrix is " + matrix3.getVectorColumn(1));

        matrix3.doScalarMultiplication(10);
        System.out.println("Matrix after scalar multiplication is " + matrix3);

        Matrix matrix5 = new Matrix(new double[][]{{-4, -1, 2}, {10, 4, -1}, {8, 3, 1}});

        System.out.println("Matrix Determinant of matrix is " + matrix5.getMatrixDeterminant());

        Matrix matrix6 = new Matrix(new double[][]{{3, -3, -5, 8}, {-3, 2, 4, -6}, {2, -5, -7, 5}, {-4, 3, 5, -6}});
        System.out.println("Matrix Determinant of matrix is " + matrix6.getMatrixDeterminant());

        System.out.println();

        matrix5.multiplyVector(new Vector(new double[]{1, 2, 3}));
        System.out.println("Matrix after multiplication by vector is " + matrix5);

        Matrix matrix7 = new Matrix(new double[][]{{1, 2, 3}, {2, 3, 4}, {5, 6, 7}});

        matrix7.addMatrix(matrix5);
        System.out.println("Addition of matrices is " + matrix7);

        matrix7.subMatrix(matrix5);
        System.out.println("Subtraction of matrices is " + matrix7);

        System.out.println("New matrix after addition is " + Matrix.matrixAddition(matrix5, matrix5));

        System.out.println("New matrix after subtraction is " + Matrix.matrixSubtraction(matrix7, matrix7));

        Matrix matrix8 = new Matrix(new double[][]{{1, -10, 9}, {4, 5, 6}});
        matrix8.doMatrixTransposition();
        System.out.println("Matrix after transposition is " + matrix8);

        Matrix matrix9 = new Matrix(new double[][]{{1, 2, -1}, {3, 4, -6}});
        Matrix matrix10 = new Matrix(new double[][]{{5, 6}, {7, 8}, {9, 10}});

        System.out.println("New matrix after multiplication is " + Matrix.matrixMultiplication(matrix9, matrix10));
    }
}
