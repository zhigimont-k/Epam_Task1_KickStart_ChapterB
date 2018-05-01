package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;

public class SelectTetrahedronByIdSpecification implements SelectTetrahedronSpecification {
    private long id;

    public SelectTetrahedronByIdSpecification(){}

    public SelectTetrahedronByIdSpecification(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return tetrahedron.getId() == id;
    }
}
