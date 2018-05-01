package by.epam.task1b.repository;

import by.epam.task1b.specification.FigureSpecification;

import java.util.List;
import java.util.Set;

public interface FigureRepository<T> {
    void add(T element);
    void remove(T element);
    Set<T> query(FigureSpecification specification);
}
