package by.epam.task1b.specification;

import by.epam.task1b.entity.Figure;

@FunctionalInterface
public interface SelectFigureSpecification<T extends Figure> {
    boolean specified(T figure);
}
