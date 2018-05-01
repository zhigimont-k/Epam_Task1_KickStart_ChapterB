package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;

public class SortTetrahedronByIdSpecification implements SortTetrahedronSpecification {
    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return (int) (o2.getId() - o1.getId());
    }
}
