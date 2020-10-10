package matrix;

public interface IMatrixWorker {
    void print(double[][] m);

    boolean haveSameDimension(double[][] m1, double[][] m2);

    double[][] add(double[][] m1, double[][] m2);

    double[][] subtract(double[][] m1, double[][] m2);

    double[][] multiply(double[][] m1, double[][] m2);

}
