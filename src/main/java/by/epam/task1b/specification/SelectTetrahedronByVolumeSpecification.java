package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class SelectTetrahedronByVolumeSpecification implements SelectTetrahedronSpecification {
    private double volume;

    public SelectTetrahedronByVolumeSpecification(){}

    public SelectTetrahedronByVolumeSpecification(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return ParameterKeeper.getInstance().getVolume(tetrahedron.getId()) == volume;
    }
}
