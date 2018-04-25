package by.epam.task1b.observer;

import by.epam.task1b.entity.Tetrahedron;

import java.util.EventObject;

public class TetrahedronEvent extends EventObject {
    public TetrahedronEvent(Tetrahedron source) {
        super(source);
    }

    @Override
    public Tetrahedron getSource() {
        return (Tetrahedron) super.getSource();
    }
}
