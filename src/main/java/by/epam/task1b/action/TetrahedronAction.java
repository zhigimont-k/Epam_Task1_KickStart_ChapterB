package by.epam.task1b.action;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.matrix.MatrixDeterminantCalculator;

public class TetrahedronAction {
    private static final int POINTS_NUMBER = 4;

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        double area = calculateTriangleArea(tetrahedron.getPoint(0), tetrahedron.getPoint(1), tetrahedron.getPoint(2));
        area += calculateTriangleArea(tetrahedron.getPoint(0), tetrahedron.getPoint(1), tetrahedron.getPoint(3));
        area += calculateTriangleArea(tetrahedron.getPoint(0), tetrahedron.getPoint(2), tetrahedron.getPoint(3));
        area += calculateTriangleArea(tetrahedron.getPoint(1), tetrahedron.getPoint(2), tetrahedron.getPoint(3));
        return area;
    }

    private double calculateTriangleArea(Point point1, Point point2, Point point3) {
        PointAction action = new PointAction();
        double sideA = action.calculateDistance(point1, point2);
        double sideB = action.calculateDistance(point2, point3);
        double sideC = action.calculateDistance(point1, point3);
        double halfPerimeter = (sideA + sideB + sideC) / 2;
        return Math.sqrt((halfPerimeter * (halfPerimeter - sideA) *
                (halfPerimeter - sideB) * (halfPerimeter - sideC)));
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double[][] coordinates = new double[POINTS_NUMBER][POINTS_NUMBER];
        for (int i = 0; i < POINTS_NUMBER; i++) {
            for (int j = 0; j < POINTS_NUMBER; j++) {
                if (j == 0) {
                    coordinates[i][j] = 1;
                }
                if (j == 1) {
                    coordinates[i][j] = tetrahedron.getPoint(i).getX();
                }
                if (j == 2) {
                    coordinates[i][j] = tetrahedron.getPoint(i).getY();
                }
                if (j == 3) {
                    coordinates[i][j] = tetrahedron.getPoint(i).getZ();
                }
            }
        }
        return Math.abs(new MatrixDeterminantCalculator(coordinates).calculateDeterminant() / 6);
    }


}
