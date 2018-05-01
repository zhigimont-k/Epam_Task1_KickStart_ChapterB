package by.epam.task1b.registrar;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public void put(long key, double area, double volume) {
        parameterMap.put(key, new TetrahedronParameter(area, volume));
        logger.log(Level.INFO, "Value was added to parameter map. Current map:\n" + parameterMap);
    }

    public void update(long key, double area, double volume){
        logger.log(Level.INFO, "Element value was changed in parameter keeper.");
        parameterMap.replace(key, new TetrahedronParameter(area, volume));
        logger.log(Level.INFO, "Current parameter keeper:\n" + parameterMap);
    }

    public void remove(Object key) {
        parameterMap.remove(key);
        logger.log(Level.INFO, "Value was removed from parameter map. Current map:\n" + parameterMap);
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
