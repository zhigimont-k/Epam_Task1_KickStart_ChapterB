package by.epam.task1b.specification;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Tetrahedron;

public class SortTetrahedronByAreaSpecification implements SortTetrahedronSpecification{
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        TetrahedronAction action = new TetrahedronAction();
        return (int) (action.calculateSurfaceArea(o2) - action.calculateVolume(o1));
    }
}
