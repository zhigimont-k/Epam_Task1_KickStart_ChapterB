package by.epam.task1b.observer;

public interface ObservableEntity {
    void addObserver(TetrahedronObserver observer);
    void removeObserver(TetrahedronObserver observer);
    void notifyObservers();
}
