package by.epam.task1b.repository.specification;

import by.epam.task1b.entity.Figure;

public class TetrahedronByVolumeSpecification implements TetrahedronSpecification {
    private double volume;

    public TetrahedronByVolumeSpecification(){}

    public TetrahedronByVolumeSpecification(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Figure figure) {
        return false;
    }
}
