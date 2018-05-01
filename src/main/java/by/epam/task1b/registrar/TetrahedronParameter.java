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
}
