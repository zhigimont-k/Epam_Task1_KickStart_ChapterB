package by.epam.task1b.repository.specification;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class TetrahedronByAreaSpecification implements TetrahedronSpecification{
    private double area;

    public TetrahedronByAreaSpecification(){}
    public TetrahedronByAreaSpecification(double area){
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Figure figure) {
        Tetrahedron tetrahedron = (Tetrahedron) figure;
        return ParameterKeeper.getInstance().getArea(tetrahedron.getId()) == area;
    }

}
