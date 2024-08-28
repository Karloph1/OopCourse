import Vector.Vector;

public class Matrix {
    private  int n;
    private int m;
    private Vector[] grid;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.grid = new Vector[n];

        for (int i = 0; i < n; i++) {
            grid[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this.n = matrix.n;
        this.m = matrix.m;
        this.grid = new Vector[n];

        for (int i = 0; i < n; i++) {
            grid[i] = new Vector(matrix.grid[i]);
        }
    }

    public Matrix(double[][] grid) {
        this.n = grid.length;
        this.m = 0;

        for (int i = 0; i < n; i++) {
            if (this.m < grid[i].length) {
                this.m = grid[i].length;
            }
        }

        this.grid = new Vector[n];

        for (int i = 0; i < n; i++) {
            this.grid[i] = new Vector(m, grid[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        this.n = vectors.length;
        this.m = 0;

        for (int i = 0; i < n; i++) {
            if (this.m < vectors[i].getSize()) {
                this.m = vectors[i].getSize();
            }
        }

        this.grid = new Vector[n];

        for (int i = 0; i < n; i++) {
            if (vectors[i].getSize() == this.m) {
                this.grid[i] = new Vector(vectors[i]);
            } else {
                Vector tmp = new Vector(m);
                tmp.addVector(vectors[i]);
                this.grid[i] = new Vector(tmp);
            }
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Vector getVectorLine(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index shouldn't be negative");
        }

        return grid[index];
    }

    public void setVectorLine(int index, Vector vector) {
        if (index < 0) {
            throw new IllegalArgumentException("Index shouldn't be negative");
        } else if (vector.getSize() != this.m) {
            throw new IllegalArgumentException("Vector length must be equal to matrix width");
        }

        grid[index] = vector;
    }

    public Vector getVectorColumn(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index shouldn't be negative");
        }

        double[] vectorColumn = new double[n];

        for (int i = 0; i < n; i++) {
            vectorColumn[i] = grid[i].getComponent(index);
        }

        return new Vector(vectorColumn);
    }

    public void doScalarMultiplication(double scalar) {
        for (int i = 0; i < n; i++) {
            grid[i].scalarMultiplication(scalar);
        }
    }

    public void doMatrixTransposition() {
        if (this.n != this.m) {
            Matrix temp = new Matrix(this.m, this.n);

            for (int i = 0; i < temp.n; i++) {
                temp.setVectorLine(i, this.getVectorColumn(i));
            }

            this.n = temp.n;
            this.m = temp.m;
            this.grid = temp.grid;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < m; j++) {
                    if (i != j) {
                        double tmp = grid[i].getComponent(j);
                        grid[i].setComponent(j, grid[j].getComponent(i));
                        grid[j].setComponent(i, tmp);
                    }
                }
            }
        }
    }

    private double calculateMatrixDeterminant(Matrix matrix) {
        double sum = 0;

        if (matrix.n == 2) {
            return matrix.getVectorLine(0).getComponent(0) * matrix.getVectorLine(1).getComponent(1)
                    - matrix.getVectorLine(0).getComponent(1) * matrix.getVectorLine(1).getComponent(0);
        } else {
            for (int i = 0; i < matrix.n; i++) {
                Vector[] vectors = new Vector[matrix.n - 1];
                int k = 0;

                for (int j = 0; j < matrix.n; j++) {
                    if (j != i) {
                        vectors[j - k] = new Vector(matrix.getVectorColumn(j));
                    } else {
                        k = 1;
                    }
                }

                Matrix tmp = new Matrix(vectors);

                Matrix temp = new Matrix(matrix.n - 1, matrix.n - 1);

                for (int j = 1; j < matrix.n; j++) {
                    temp.setVectorLine(j - 1, tmp.getVectorColumn(j));
                }

                sum += matrix.grid[0].getComponent(i) * Math.pow(-1, i) * calculateMatrixDeterminant(temp);

            }
        }

        return sum;
    }

    public double getMatrixDeterminant() {
        if (n != m) {
            throw new IllegalArgumentException("Matrix must be quadratic");
        }

        return calculateMatrixDeterminant(this);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");

        for (int i = 0; i < n; i++) {
            string.append(grid[i]);
            string.append(", ");
        }

        string.delete(string.length() - 2, string.length());

        return string + "}";
    }

    public void multiplyVector(Vector vector) {
        if (vector.getSize() != this.n) {
            throw new IllegalArgumentException("Vector length must be equal to matrix length");
        }

        doMatrixTransposition();

        for (int i = 0; i < n; i++) {
            grid[i].scalarMultiplication(vector.getComponent(i));
        }

        doMatrixTransposition();
    }

    public void addMatrix(Matrix matrix) {
        if (matrix.n != this.n || matrix.m != this.m) {
            throw new IllegalArgumentException("Matrix data doesn't match each other");
        }

        for (int i = 0; i < this.n; i++) {
            this.grid[i].addVector(matrix.grid[i]);
        }
    }

    public void subMatrix(Matrix matrix) {
        if (matrix.n != this.n || matrix.m != this.m) {
            throw new IllegalArgumentException("Matrix data doesn't match each other");
        }

        for (int i = 0; i < this.n; i++) {
            this.grid[i].subVector(matrix.grid[i]);
        }
    }

    public static Matrix matrixAddition(Matrix matrix1, Matrix matrix2) {
        matrix1.addMatrix(matrix2);

        return new Matrix(matrix1);
    }

    public static Matrix matrixSubtraction(Matrix matrix1, Matrix matrix2) {
        matrix1.subMatrix(matrix2);

        return new Matrix(matrix1);
    }

    public static Matrix matrixMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.m != matrix2.n) {
            throw new IllegalArgumentException("Matrix data doesn't match each other");
        }

        Matrix matrix = new Matrix(matrix1.n, matrix2.m);

        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                matrix.grid[i].setComponent(j, Vector.getDotProduct(matrix1.grid[i], matrix2.getVectorColumn(j)));
            }
        }

        return matrix;
    }
}