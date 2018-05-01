package by.epam.task1b.repository.specification;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;

public class TetrahedronByIdSpecification implements TetrahedronSpecification{
    private long id;

    public TetrahedronByIdSpecification(){}

    public TetrahedronByIdSpecification(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Figure figure) {
        Tetrahedron tetrahedron = (Tetrahedron) figure;
        return tetrahedron.getId() == id;
    }
}
