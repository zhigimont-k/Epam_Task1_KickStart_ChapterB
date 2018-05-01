package by.epam.task1b.observer;

public interface ObservableEntity {
    void addObserver(FigureObserver observer);
    void removeObserver(FigureObserver observer);
    void notifyObservers();
}
