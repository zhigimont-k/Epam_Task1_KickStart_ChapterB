package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class SelectTetrahedronByAreaRangeSpecification implements SelectTetrahedronSpecification {
    private double max;
    private double min;

    public SelectTetrahedronByAreaRangeSpecification(){}

    public SelectTetrahedronByAreaRangeSpecification(double min, double max) {
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
        return ParameterKeeper.getInstance().getArea(tetrahedron.getId()) > min &&
                ParameterKeeper.getInstance().getArea(tetrahedron.getId()) < max;
    }
}
