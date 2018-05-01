package by.epam.task1b.registrar;

public class TetrahedronParameter {
    private double surfaceArea;
    private double volume;

    public TetrahedronParameter(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "(" + surfaceArea +
                ", " + volume +
                ')';
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TetrahedronParameter that = (TetrahedronParameter) o;
        return surfaceArea == that.surfaceArea && volume == that.volume;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += hash * 31 + surfaceArea + volume;
        return hash;
    }
}
