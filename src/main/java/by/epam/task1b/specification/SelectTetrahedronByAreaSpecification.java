package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

public class SelectTetrahedronByAreaSpecification implements SelectTetrahedronSpecification {
    private double area;

    public SelectTetrahedronByAreaSpecification(){}
    public SelectTetrahedronByAreaSpecification(double area){
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return ParameterKeeper.getInstance().getArea(tetrahedron.getId()) == area;
    }

}
