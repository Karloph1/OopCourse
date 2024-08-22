public class Vector {
    private int dimension;
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Dimension must be positive");
        }

        this.dimension = dimension;
        this.components = new double[dimension];

        for (int i = 0; i < dimension; i++) {
            components[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.dimension = vector.dimension;
        this.components = new double[dimension];

        System.arraycopy(vector.components, 0, this.components, 0, dimension);
    }

    public Vector(double[] components) {
        this.dimension = components.length;
        this.components = new double[dimension];

        System.arraycopy(components, 0, this.components, 0, dimension);
    }

    public Vector(int dimension, double[] components) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Dimension must be positive");
        }

        this.dimension = dimension;
        this.components = new double[dimension];

        System.arraycopy(components, 0, this.components, 0, components.length);

        for (int i = components.length; i < dimension; i++) {
            this.components[i] = 0;
        }
    }

    public int getSize() {
        return dimension;
    }

    public void addVector(Vector vector) {
        if (this.dimension < vector.dimension) {
            Vector temp = new Vector(vector.dimension, this.components);

            this.dimension = temp.dimension;
            this.components = temp.components;
        }

        for (int i = 0; i < vector.dimension; i++) {
            this.components[i] += vector.components[i];
        }
    }

    public void subVector(Vector vector) {
        if (this.dimension < vector.dimension) {
            Vector temp = new Vector(vector.dimension, this.components);

            this.dimension = temp.dimension;
            this.components = temp.components;
        }

        for (int i = 0; i < vector.dimension; i++) {
            this.components[i] -= vector.components[i];
        }
    }

    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < dimension; i++) {
            components[i] *= scalar;
        }
    }

    public void rotateVector() {
        for (int i = 0; i < dimension; i++) {
            components[i] *= -1;
        }
    }

    public double getVectorLength() {
        double length = 0;

        for (int i = 0; i < dimension; i++) {
            length += Math.pow(components[i], 2);
        }

        return Math.sqrt(length);
    }

    public void setComponent(int n, double component) {
        components[n] = component;
    }

    public double getComponent(int n) {
        return components[n];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        } else if (this.dimension != ((Vector) obj).dimension) {
            return false;
        }

        for (int i = 0; i < dimension; i++) {
            if (this.components[i] != ((Vector) obj).components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 23;
        int hash = 1;

        hash = PRIME * hash + Integer.hashCode(dimension);
        for (int i = 0; i < dimension; i++) {
            hash = PRIME * hash + Double.hashCode(components[i]);
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");

        for (int i = 0; i < dimension; i++) {
            string.append(components[i]);
            string.append(", ");
        }

        string.delete(string.length() - 2, string.length());

        return string + "}";
    }

    public static Vector vectorAddition(Vector vector1, Vector vector2) {
        vector1.addVector(vector2);

        return new Vector(vector1);
    }

    public static Vector vectorSubtraction(Vector vector1, Vector vector2) {
        vector1.subVector(vector2);

        return new Vector(vector1);
    }

    public static double getDotProduct(Vector vector1, Vector vector2) {
        double ans = 0;

        for (int i = 0; i < Math.min(vector1.dimension, vector2.dimension); i++) {
            ans += (vector1.components[i] * vector2.components[i]);
        }

        return ans;
    }
}