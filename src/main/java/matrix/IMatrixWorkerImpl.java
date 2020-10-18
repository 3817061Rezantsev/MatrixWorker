package matrix;

import java.util.InputMismatchException;

public class IMatrixWorkerImpl implements IMatrixWorker {

	@Override
	public void print(double[][] m) {
		if (m == null) {
			System.out.println("Matrix doesn't exist");
		} else {
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					System.out.print(m[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	@Override
	public boolean haveSameDimension(double[][] m1, double[][] m2) {
		if ((m1 == null) || (m2 == null)) {
			return false;
		}
		if (m1.length == m2.length) {
			for (int i = 0; i < m1.length; i++) {
				if ((m1[0].length != m2[i].length) && (m1[i].length != m2[0].length)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public double[][] add(double[][] m1, double[][] m2) {
		if (!haveSameDimension(m1, m2)) {
			throw new InputMismatchException();
		}
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				m1[i][j] += m2[i][j];
			}
		}
		return m1;
	}

	@Override
	public double[][] subtract(double[][] m1, double[][] m2) {
		if (!haveSameDimension(m1, m2)) {
			throw new InputMismatchException();
		}
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				m1[i][j] -= m2[i][j];
			}
		}
		return m1;
	}

	@Override
	public double[][] multiply(double[][] m1, double[][] m2) {
		if ((m1.length != m2[0].length) && (m1[0].length != m2.length)) {
			throw new InputMismatchException();
		}
		double[][] res = new double[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++)
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++)
					res[i][j] += m1[i][k] * m2[k][j];
			}
		return res;

	}

	public double determ(double[][] a, int size) {
		int i, j;
		double det = 0;
		double[][] matr;
		if (!haveSameDimension(a, a)) {
			throw new InputMismatchException();
		}
		if (size == 1) {
			det = a[0][0];
		} else if (size == 2) {
			det = a[0][0] * a[1][1] - a[0][1] * a[1][0];
		} else {
			matr = new double[size - 1][size];
			for (i = 0; i < size; ++i) {
				for (j = 0; j < size - 1; ++j) {
					if (j < i) {
						for (int k = 0; k < size; k++) {
							matr[j][k] = a[j][k];
						}

					} else {
						for (int k = 0; k < size; k++) {
							matr[j][k] = a[j + 1][k];
						}
					}

				}
				det += Math.pow(-1.0, (i + j)) * determ(matr, size - 1) * a[i][size - 1];
			}

		}
		return det;
	}

	public double[] kramer(double[][] a, double[] b) {
		int size = a.length;
		if (!haveSameDimension(a, a)) {
			throw new InputMismatchException();
		}
		double[] dets = new double[size];
		double[] x = new double[size];
		double det = determ(a, size);
		if (det != 0) {
			for (int i = 0; i < size; i++) {
				double[][] tmp = new double[size][size];
				for (int k = 0; k < size; k++) {
					for (int l = 0; l < size; l++) {
						tmp[k][l] = a[k][l];
					}
				}
				for (int j = 0; j < size; j++) {
					tmp[j][i] = b[j];
				}
				dets[i] = determ(tmp, size);
			}
			for (int i = 0; i < size; i++) {
				x[i] = dets[i] / det;
			}
		} else {
			for (int m = 0; m < size; m++) {
				x[m] = -1d;
			}
		}
		return x;
	}
}
