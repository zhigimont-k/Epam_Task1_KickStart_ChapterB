package by.epam.task1b.action.matrix;

public class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    private Matrix(int rows, int cols) {
        data = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Matrix(double[][] data) {
        this.data = data.clone();
        rows = this.data.length;
        cols = this.data[0].length;
    }

    private Matrix subMatrix(Matrix matrix, int excludeRow, int excludeCol) {
        Matrix result = new Matrix(matrix.rows - 1, matrix.cols - 1);

        for (int row = 0, p = 0; row < matrix.rows; ++row) {
            if (row != excludeRow - 1) {
                for (int col = 0, q = 0; col < matrix.cols; ++col) {
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

    public double determinant(Matrix matrix) {
        if (matrix.cols == 1) {
            return matrix.data[0][0];
        } else if (matrix.cols == 2) {
            return (matrix.data[0][0] * matrix.data[1][1] -
                    matrix.data[0][1] * matrix.data[1][0]);
        } else {
            double result = 0.0;

            for (int col = 0; col < matrix.cols; ++col) {
                Matrix sub = subMatrix(matrix, 1, col + 1);

                result += (Math.pow(-1, 1 + col + 1) *
                        matrix.data[0][col] * determinant(sub));
            }

            return result;
        }
    }
}
