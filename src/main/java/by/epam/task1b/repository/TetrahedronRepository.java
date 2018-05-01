package by.epam.task1b.repository;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;
import by.epam.task1b.specification.FigureSpecification;
import by.epam.task1b.specification.TetrahedronSpecification;
import by.epam.task1b.store.TetrahedronStore;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TetrahedronRepository implements FigureRepository<Tetrahedron> {
    private static Logger logger = LogManager.getLogger();
    private static TetrahedronRepository instance;

    private TetrahedronRepository() {
    }

    public static TetrahedronRepository getInstance() {
        if (instance == null) {
            instance = new TetrahedronRepository();
        }
        return instance;
    }

    public void add(Tetrahedron tetrahedron) {
        TetrahedronStore.getInstance().add(tetrahedron);
        logger.log(Level.INFO, "Element was added. Current repository:\n" + instance);
        TetrahedronAction action = new TetrahedronAction();
        ParameterKeeper.getInstance().add(tetrahedron.getId(), action.calculateSurfaceArea(tetrahedron),
                action.calculateVolume(tetrahedron));
    }

    public void remove(Tetrahedron tetrahedron) {
        TetrahedronStore.getInstance().remove(tetrahedron);
        logger.log(Level.INFO, "Element was removed. Current repository:\n" + instance);
        ParameterKeeper.getInstance().remove(tetrahedron.getId());
    }

    public void clear(){
        TetrahedronStore.getInstance().clear();
        logger.log(Level.INFO, "All elements were removed. Current repository:\n" + instance);
        ParameterKeeper.getInstance().clear();
    }

    public void setName(long id, String name) {
        logger.log(Level.INFO, "Element name was changed in repository.");
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            if (tetrahedron.getId() == id) {
                tetrahedron.setName(name);
            }
        }
        logger.log(Level.INFO, "Current repository:\n" + instance);
    }

    public void setPoint(long id, int index, Point point) {
        logger.log(Level.INFO, "Element value was changed in repository.");
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            if (tetrahedron.getId() == id) {
                tetrahedron.setPoint(index, point);
            }
        }
        logger.log(Level.INFO, "Current repository:\n" + instance);
    }

    public Set<Tetrahedron> query(FigureSpecification specification) {
        TetrahedronSpecification tetrahedronSpecification = (TetrahedronSpecification) specification;
        return TetrahedronStore.getInstance().getStore().stream()
                .filter(tetrahedronSpecification::specified)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public List<Tetrahedron> sortByName() {
        return TetrahedronStore.getInstance().getStore().stream()
                .sorted(Comparator.comparing(Tetrahedron::getName)
                        .thenComparing(Tetrahedron::getId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Tetrahedron> sortById() {
        return TetrahedronStore.getInstance().getStore().stream()
                .sorted(Comparator.comparing(Tetrahedron::getId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Tetrahedron> sortByArea() {
        TetrahedronAction action = new TetrahedronAction();
        return TetrahedronStore.getInstance().getStore().stream()
                .sorted(Comparator.comparing(action::calculateSurfaceArea)
                        .thenComparing(Tetrahedron::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Tetrahedron> sortByVolume() {
        TetrahedronAction action = new TetrahedronAction();
        return TetrahedronStore.getInstance().getStore().stream()
                .sorted(Comparator.comparing(action::calculateVolume)
                .thenComparing(Tetrahedron::getName))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Repository: "
                + TetrahedronStore.getInstance()
                ;
    }
}
