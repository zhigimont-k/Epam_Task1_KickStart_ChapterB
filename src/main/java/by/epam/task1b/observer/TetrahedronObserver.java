package by.epam.task1b.observer;

import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterHolder;

import java.util.ArrayList;

public class TetrahedronObserver {
    private ArrayList<Tetrahedron> list = new ArrayList<>();
    public void addObservable(Tetrahedron tetrahedron) {
        list.add(tetrahedron);
    }
    public void removeObservable(Tetrahedron tetrahedron){
        list.remove(tetrahedron);
    }
    public void handleEvent(TetrahedronEvent event){
        ParameterHolder.getInstance().update(event);
    }
}
