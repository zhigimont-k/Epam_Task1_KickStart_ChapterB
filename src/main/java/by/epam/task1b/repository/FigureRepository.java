package by.epam.task1b.repository;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.specification.SelectFigureSpecification;
import by.epam.task1b.specification.SortFigureSpecification;

import java.util.Set;

public interface FigureRepository<T extends Figure> {
    void add(T element);
    void remove(T element);
    Set<T> query(SelectFigureSpecification specification);
    List<T> query(SortFigureSpecification specification);
}
