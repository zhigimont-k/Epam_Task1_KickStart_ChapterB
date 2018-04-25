package by.epam.task1b.registrar;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.observer.TetrahedronEvent;
import by.epam.task1b.observer.TetrahedronObserver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ParameterHolder {
    private static ParameterHolder instance;
    private Map<Long, TetrahedronParameter> parameterMap;
    private TetrahedronObserver observer;
    private TetrahedronAction action;
    private static Logger logger = LogManager.getLogger();

    private ParameterHolder() {
        parameterMap = new HashMap<>();
        action = new TetrahedronAction();
        observer = new TetrahedronObserver();
    }

    public static ParameterHolder getInstance() {
        if (instance == null) {
            instance = new ParameterHolder();
        }
        return instance;
    }

    public TetrahedronObserver getObserver() {
        return observer;
    }

    public void put(long key, double area, double volume) {
        parameterMap.put(key, new TetrahedronParameter(area, volume));
        logger.log(Level.INFO, "Value was added to parameter map. Current map:\n"+parameterMap);
    }

    public void remove(Object key) {
        parameterMap.remove(key);
        logger.log(Level.INFO, "Value was removed from parameter map. Current map:\n"+parameterMap);
    }

    public void update(TetrahedronEvent event){
        Tetrahedron changed = event.getSource();
        parameterMap.put(changed.getId(),
                new TetrahedronParameter(action.calculateSurfaceArea(changed), action.calculateVolume(changed)));
        logger.log(Level.INFO, "Value was changed in parameter map. Current map:\n"+parameterMap);
    }

    @Override
    public String toString() {
        return "Parameters: " + parameterMap;
    }
}

class TetrahedronParameter {
    private double volume;
    private double surfaceArea;

    TetrahedronParameter(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    @Override
    public String toString() {
        return "(" + volume +
                ", " + surfaceArea +
                ')';
    }
}
