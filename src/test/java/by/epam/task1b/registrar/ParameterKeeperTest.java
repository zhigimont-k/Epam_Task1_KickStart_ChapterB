package by.epam.task1b.registrar;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.observer.TetrahedronObserver;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterKeeperTest {
    private List<Tetrahedron> list;
    private Map<Long, TetrahedronParameter> expected;
    private Tetrahedron changed;

    @BeforeClass(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void init() {
        TetrahedronRepository.getInstance().clear();
        expected = new HashMap<>();
        changed = new Tetrahedron(
                new Point(1, 3, 3), new Point(4, 9, 11),
                new Point(2, 1, 11), new Point(1, 2, 11));
        list = new ArrayList<>();
        list.add(changed);
        list.add(new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6)));
        list.add(new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6)));
        for (Tetrahedron tetrahedron : list) {
            TetrahedronRepository.getInstance().add(tetrahedron);
        }
    }

    @DataProvider(name = "dataProviderAdd")
    public Object[][] provideDataAdd() {
        TetrahedronAction action = new TetrahedronAction();
        for (Tetrahedron tetrahedron : list) {
            expected.put(tetrahedron.getId(), new TetrahedronParameter(
                    action.calculateSurfaceArea(tetrahedron), action.calculateVolume(tetrahedron)));
        }
        Map<Long, TetrahedronParameter> result = new HashMap<>();
        return new Object[][]{{ParameterKeeper.getInstance().getParameterMap(), expected}};
    }

    @Test(dataProvider = "dataProviderAdd", dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void add(Map<Long, TetrahedronParameter> result, Map<Long, TetrahedronParameter> expected) {
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "dataProviderUpdate")
    public Object[][] provideDataUpdate() {
        changed.addObserver(new TetrahedronObserver());
        changed.setPoint(1, new Point(1, 2, 11));
        return new Object[][]{{ParameterKeeper.getInstance().getParameterMap(), expected}};
    }

    @Test(dataProvider = "dataProviderUpdate", dependsOnMethods = {"add"})
    public void update(Map<Long, TetrahedronParameter> result, Map<Long, TetrahedronParameter> expected) {
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "dataProviderRemove")
    public Object[][] provideDataRemove() {
        expected.remove(changed.getId());
        TetrahedronRepository.getInstance().remove(changed);
        return new Object[][]{{ParameterKeeper.getInstance().getParameterMap(), expected}};
    }

    @Test(dataProvider = "dataProviderRemove", dependsOnMethods = {"add"})
    public void remove(Map<Long, TetrahedronParameter> result, Map<Long, TetrahedronParameter> expected) {
        Assert.assertEquals(result, expected);
    }
}
