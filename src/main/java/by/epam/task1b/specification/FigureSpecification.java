package by.epam.task1b.specification;

import by.epam.task1b.entity.Figure;

@FunctionalInterface
public interface FigureSpecification {
    boolean specified(Figure figure);
}