package by.epam.task1b.repository;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;
import by.epam.task1b.specification.*;
import by.epam.task1b.store.TetrahedronStore;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TetrahedronRepository implements FigureRepository<Tetrahedron>, Iterable<Tetrahedron> {
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

    public void clear() {
        TetrahedronStore.getInstance().clear();
        logger.log(Level.INFO, "All elements were removed. Current repository:\n" + instance);
        ParameterKeeper.getInstance().clear();
    }

    public Tetrahedron getTetrahedron(long id) {
        return TetrahedronStore.getInstance().get(id);
    }

    public Set<Tetrahedron> getStore() {
        return TetrahedronStore.getInstance().getStore();
    }

    @Override
    public Set<Tetrahedron> query(SelectFigureSpecification specification) {
        SelectTetrahedronSpecification tetrahedronSpecification = (SelectTetrahedronSpecification) specification;
        return TetrahedronStore.getInstance().getStore().stream()
                .filter(tetrahedronSpecification::specified)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public List<Tetrahedron> query(SortFigureSpecification specification) {
        SortTetrahedronSpecification tetrahedronSpecification = (SortTetrahedronSpecification) specification;
        return TetrahedronStore.getInstance().getStore().stream()
                .sorted(tetrahedronSpecification.thenComparing(new SortTetrahedronByIdSpecification()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Iterator<Tetrahedron> iterator() {
        return TetrahedronStore.getInstance().iterator();
    }

    @Override
    public String toString() {
        return "Repository: "
                + TetrahedronStore.getInstance()
                ;
    }
}
