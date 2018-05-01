package by.epam.task1b.entity;

public class Point {
    private double x;
    private double y;
    private double z;
    private String name = "";

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(double x, double y, double z, String name){
        this(x, y, z);
        this.name = name;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point other = (Point) o;
        return x == other.x && y == other.y && z == other.z && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += hash * 31 + x + y + z + name.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return name + "(" + x +
                ", " + y +
                ", " + z +
                ')';
    }
}
