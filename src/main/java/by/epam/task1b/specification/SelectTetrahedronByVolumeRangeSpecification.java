package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class SelectTetrahedronByVolumeRangeSpecification implements SelectTetrahedronSpecification {
    private double max;
    private double min;

    public SelectTetrahedronByVolumeRangeSpecification(){}

    public SelectTetrahedronByVolumeRangeSpecification(double min, double max) {
        this.max = max;
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return ParameterKeeper.getInstance().getVolume(tetrahedron.getId()) > min &&
                ParameterKeeper.getInstance().getVolume(tetrahedron.getId()) < max;
    }
}
