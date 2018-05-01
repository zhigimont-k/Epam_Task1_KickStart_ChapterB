package by.epam.task1b.specification;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class TetrahedronByAreaRangeSpecification implements TetrahedronSpecification{
    private double max;
    private double min;

    public TetrahedronByAreaRangeSpecification(){}

    public TetrahedronByAreaRangeSpecification(double min, double max) {
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
    public boolean specified(Figure figure) {
        Tetrahedron tetrahedron = (Tetrahedron) figure;
        return ParameterKeeper.getInstance().getArea(tetrahedron.getId()) > min &&
                ParameterKeeper.getInstance().getArea(tetrahedron.getId()) < max;
    }
}
