package by.epam.task1b.specification;

import by.epam.task1b.entity.Figure;

import java.util.Comparator;

@FunctionalInterface
public interface SortFigureSpecification<T extends Figure> extends Comparator<T> {
}
