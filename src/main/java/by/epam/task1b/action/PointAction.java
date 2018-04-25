package by.epam.task1b.action;

import by.epam.task1b.entity.Point;

public class PointAction {

    public double calculateDistance(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) +
                Math.pow(second.getY() - first.getY(), 2) +
                Math.pow(second.getZ() - first.getZ(), 2));
    }

}
