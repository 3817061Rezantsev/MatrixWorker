package matrix.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import matrix.IMatrixWorkerImpl;

public class MatrixWorkerTest {

    @Test
    public void haveSameDimensionTest() {
        IMatrixWorkerImpl worker = new IMatrixWorkerImpl();

        double[][] m1 = new double[2][7];
        double[][] m2 = new double[2][7];
        assertTrue(worker.haveSameDimension(m1, m2));

        m1 = new double[3][7];
        assertFalse(worker.haveSameDimension(m1, m2));

        m1 = new double[2][6];
        assertFalse(worker.haveSameDimension(m1, m2));
    }

    @Test
    public void addTest() {
        double[][] m1 = new double[][] { { 1d, 1d, 1d }, { 1d, 1d, 1d } };
        double[][] m2 = new double[][] { { 1d, 2d, 3d }, { 4d, 5d, 6d } };
        IMatrixWorkerImpl worker = new IMatrixWorkerImpl();
        double[][] m = worker.add(m1, m2);
        assertEquals(m1.length, m.length);
        assertEquals(m1[0].length, m[0].length);
        assertEquals(m1.length, m.length);
        assertEquals(2d, m[0][0]);
        assertEquals(3d, m[0][1]);
        assertEquals(4d, m[0][2]);
        assertEquals(5d, m[1][0]);
        assertEquals(6d, m[1][1]);
        assertEquals(7d, m[1][2]);
    }

    @Test
    public void subtructTest() {
        double[][] m1 = new double[][] { { 5d, 5d, 5d }, { 5d, 5d, 5d } };
        double[][] m2 = new double[][] { { 1d, 2d, 3d }, { 4d, 5d, 6d } };

        IMatrixWorkerImpl worker = new IMatrixWorkerImpl();
        double[][] m = worker.subtract(m1, m2);
        assertEquals(m1.length, m.length);
        assertEquals(m1[0].length, m[0].length);
        assertEquals(m1.length, m.length);
        assertEquals(4d, m[0][0]);
        assertEquals(3d, m[0][1]);
        assertEquals(2d, m[0][2]);
        assertEquals(1d, m[1][0]);
        assertEquals(0d, m[1][1]);
        assertEquals(-1d, m[1][2]);
    }

    @Test
    public void multiplyTest() {
        double[][] m1 = new double[][] { { 1d, 2d, 3d } };
        double[][] m2 = new double[][] { { 1d }, { 2d }, { 3d } };
        IMatrixWorkerImpl worker = new IMatrixWorkerImpl();
        double[][] m = worker.multiply(m1, m2);
        assertEquals(1, m.length);
        assertEquals(1, m[0].length);
        assertEquals(14, m[0][0]);
    }
}
