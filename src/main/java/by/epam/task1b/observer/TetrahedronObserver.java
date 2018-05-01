package by.epam.task1b.observer;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;

import java.util.EventObject;

public class TetrahedronObserver implements FigureObserver {
    @Override
    public void handleEvent(EventObject event) {
        TetrahedronEvent tetrahedronEvent = (TetrahedronEvent) event;
        Tetrahedron tetrahedron = tetrahedronEvent.getSource();
        TetrahedronAction action = new TetrahedronAction();
        ParameterKeeper.getInstance().update(tetrahedron.getId(),
                action.calculateSurfaceArea(tetrahedron), action.calculateVolume(tetrahedron));
    }
}
