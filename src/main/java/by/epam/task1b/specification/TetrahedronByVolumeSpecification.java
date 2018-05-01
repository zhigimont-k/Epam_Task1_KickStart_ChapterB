package by.epam.task1b.specification;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

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
        Tetrahedron tetrahedron = (Tetrahedron) figure;
        return ParameterKeeper.getInstance().getVolume(tetrahedron.getId()) == volume;
    }
}