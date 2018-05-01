package by.epam.task1b.entity;


import by.epam.task1b.observer.FigureObserver;
import by.epam.task1b.observer.ObservableEntity;
import by.epam.task1b.observer.TetrahedronEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Tetrahedron extends Figure implements ObservableEntity {
    private List<Point> points = new ArrayList<>();
    private String name = "";
    private long id;
    private FigureObserver observer;

    public Tetrahedron() {
        id = UUID.randomUUID().getMostSignificantBits();
    }

    public Tetrahedron(Point point1, Point point2, Point point3, Point point4) {
        this();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
    }

    public Tetrahedron(Point point1, Point point2, Point point3, Point point4, String name){
        this(point1, point2, point3, point4);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPoint(int index, Point point){
        points.set(index, point);
        notifyObservers();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public void setPoints(Collection<? extends Point> c){
        points = new ArrayList<>();
        points.addAll(c);
        notifyObservers();
    }

    @Override
    public void addObserver(FigureObserver observer) {
        this.observer = observer;
    }

    @Override
    public void removeObserver(FigureObserver observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null){
            observer.handleEvent(new TetrahedronEvent(this));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tetrahedron other = (Tetrahedron) o;
        int arraySize = points.size();
        for (int i = 0; i < arraySize; i++) {
            if (!points.get(i).equals(other.points.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (Point point : points) {
            hash += hash * 31 + point.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", points=" + points +
                '}';
    }
}
