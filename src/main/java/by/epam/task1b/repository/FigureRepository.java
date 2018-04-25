package by.epam.task1b.repository;

import by.epam.task1b.repository.specification.FigureSpecification;

import java.util.List;

public interface FigureRepository<T> {
    void add(T element);
    void remove(T element);
    List<T> query(FigureSpecification specification);
}
