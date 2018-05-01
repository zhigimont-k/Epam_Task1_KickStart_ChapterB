package by.epam.task1b.registrar;

public class TetrahedronParameter {
    private double volume;
    private double surfaceArea;

    public TetrahedronParameter(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return "(" + volume +
                ", " + surfaceArea +
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
}
