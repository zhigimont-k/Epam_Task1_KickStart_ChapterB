package by.epam.task1b.matrix;

public class MatrixDeterminantCalculator {
    private double[][] data;

    private MatrixDeterminantCalculator(int rows, int cols) {
        data = new double[rows][cols];
    }

    public MatrixDeterminantCalculator(double[][] data) {
        this.data = data.clone();
    }

    private MatrixDeterminantCalculator subMatrix(MatrixDeterminantCalculator matrix, int excludeRow, int excludeCol) {
        MatrixDeterminantCalculator result = new MatrixDeterminantCalculator(matrix.data.length - 1,
                matrix.data[0].length - 1);

        for (int row = 0, p = 0; row < matrix.data.length; ++row) {
            if (row != excludeRow - 1) {
                for (int col = 0, q = 0; col < matrix.data[0].length; ++col) {
                    if (col != excludeCol - 1) {
                        result.data[p][q] = matrix.data[row][col];
                        ++q;
                    }
                }
                ++p;
            }
        }
        return result;
    }

    private double calculateDeterminant(MatrixDeterminantCalculator matrix) {
        if (matrix.data[0].length == 1) {
            return matrix.data[0][0];
        } else if (matrix.data[0].length == 2) {
            return (matrix.data[0][0] * matrix.data[1][1] -
                    matrix.data[0][1] * matrix.data[1][0]);
        } else {
            double result = 0.0;

            for (int col = 0; col < matrix.data[0].length; ++col) {
                MatrixDeterminantCalculator sub = subMatrix(matrix, 1, col + 1);

                result += (Math.pow(-1, 1 + col + 1) *
                        matrix.data[0][col] * calculateDeterminant(sub));
            }

            return result;
        }
    }

    public double calculateDeterminant() {
        if (data[0].length == 1) {
            return data[0][0];
        } else if (data[0].length == 2) {
            return (data[0][0] * data[1][1] -
                    data[0][1] * data[1][0]);
        } else {
            double result = 0.0;

            for (int col = 0; col < data[0].length; ++col) {
                MatrixDeterminantCalculator sub = subMatrix(this, 1, col + 1);

                result += (Math.pow(-1, 1 + col + 1) *
                        data[0][col] * calculateDeterminant(sub));
            }

            return result;
        }
    }
}
