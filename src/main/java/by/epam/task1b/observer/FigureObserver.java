package by.epam.task1b.observer;

import by.epam.task1b.entity.Figure;

import java.util.EventObject;

public interface FigureObserver {
    //void add(Figure figure);
    //void remove(Figure figure);
    void handleEvent(EventObject event);
}
