package by.epam.task1b.specification;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Tetrahedron;

public class SortTetrahedronByVolumeSpecification implements SortTetrahedronSpecification {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        TetrahedronAction action = new TetrahedronAction();
        return Double.compare(action.calculateVolume(o1), action.calculateVolume(o2));
    }
}
