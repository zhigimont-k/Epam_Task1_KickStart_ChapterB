package by.epam.task1b.specification;

import by.epam.task1b.entity.Tetrahedron;

public class SelectTetrahedronByNameSpecification implements SelectTetrahedronSpecification {
    private String name;

    public SelectTetrahedronByNameSpecification(){}

    public SelectTetrahedronByNameSpecification(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return tetrahedron.getName().equals(name);
    }
}
