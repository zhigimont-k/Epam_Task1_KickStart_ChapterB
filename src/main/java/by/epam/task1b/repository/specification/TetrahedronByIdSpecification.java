package by.epam.task1b.repository.specification;

import by.epam.task1b.entity.Figure;

public class TetrahedronByIdSpecification implements TetrahedronSpecification{
    @Override
    public boolean specified(Figure figure) {
        return false;
    }
}
