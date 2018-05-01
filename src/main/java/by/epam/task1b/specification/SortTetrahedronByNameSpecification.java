package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;

public class SortTetrahedronByNameSpecification implements SortTetrahedronSpecification {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
