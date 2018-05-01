package by.epam.task1b.repository.specification;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;

public class TetrahedronByNameSpecification implements TetrahedronSpecification {
    private String name;

    public TetrahedronByNameSpecification(){}

    public TetrahedronByNameSpecification(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(Figure figure) {
        Tetrahedron tetrahedron = (Tetrahedron) figure;
        return tetrahedron.getName().equals(name);
    }
}
