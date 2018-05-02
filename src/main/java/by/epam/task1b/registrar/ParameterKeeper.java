package by.epam.task1b.registrar;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParameterKeeper {
    private static Logger logger = LogManager.getLogger();
    private static ParameterKeeper instance;
    private Map<Long, TetrahedronParameter> parameterMap;

    private ParameterKeeper() {
        parameterMap = new HashMap<>();
    }

    public static ParameterKeeper getInstance() {
        if (instance == null) {
            instance = new ParameterKeeper();
        }
        return instance;
    }

    public void add(long id, double area, double volume) {
        parameterMap.put(id, new TetrahedronParameter(area, volume));
        logger.log(Level.INFO, "Value was added to parameter map. Current map:\n" + parameterMap);
    }

    public void update(long id, double area, double volume){
        parameterMap.replace(id, new TetrahedronParameter(area, volume));
        logger.log(Level.INFO, "Element value was changed in parameter keeper. Current parameter keeper:\n" + parameterMap);
    }

    public void remove(long id) {
        parameterMap.remove(id);
        logger.log(Level.INFO, "Value was removed from parameter keeper. Current parameter keeper:\n" + parameterMap);
    }

    public Map<Long, TetrahedronParameter> getParameterMap() {
        return Collections.unmodifiableMap(parameterMap);
    }


    public double getArea(long id){
        return parameterMap.get(id).getSurfaceArea();
    }

    public double getVolume(long id){
        return parameterMap.get(id).getVolume();
    }

    @Override
    public String toString() {
        return parameterMap.toString();
    }
}
