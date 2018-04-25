package by.epam.task1b.repository;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterHolder;
import by.epam.task1b.repository.specification.FigureSpecification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TetrahedronRepository implements FigureRepository<Tetrahedron> {
    private Set<Tetrahedron> store;
    private static TetrahedronRepository instance;
    private static Logger logger = LogManager.getLogger();


    private TetrahedronRepository() {
        store = new HashSet<>();
    }

    public static TetrahedronRepository getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepository();
        }
        return instance;
    }

    public void add(Tetrahedron tetrahedron) {
        store.add(tetrahedron);
        TetrahedronAction action = new TetrahedronAction();
        logger.log(Level.INFO, "Element was added. Current repository:\n" + instance);
        ParameterHolder.getInstance().put(tetrahedron.getId(), action.calculateSurfaceArea(tetrahedron),
                action.calculateVolume(tetrahedron));
        tetrahedron.addObserver(ParameterHolder.getInstance().getObserver());
    }

    public void remove(Tetrahedron tetrahedron) {
        store.remove(tetrahedron);
        logger.log(Level.INFO, "Element was removed. Current repository:\n" + instance);
        ParameterHolder.getInstance().remove(tetrahedron.getId());
    }

    public void setName(long id, String name) {
        for (Tetrahedron tetrahedron : store) {
            if (tetrahedron.getId() == id) {
                tetrahedron.setName(name);
            }
        }
        logger.log(Level.INFO, "Element was changed. Current repository:\n" + instance);
    }

    public void setPoint(long id, int index, Point point) {
        for (Tetrahedron tetrahedron : store) {
            if (tetrahedron.getId() == id) {
                tetrahedron.setPoint(index, point);
            }
        }
        logger.log(Level.INFO, "Element was changed. Current repository:\n" + instance);
    }

    public List<Tetrahedron> query(FigureSpecification specification) {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Repository: " + store;
    }
}
