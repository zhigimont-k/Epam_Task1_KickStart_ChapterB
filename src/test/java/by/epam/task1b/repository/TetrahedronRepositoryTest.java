package by.epam.task1b.repository;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.store.TetrahedronStore;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TetrahedronRepositoryTest {
    private Set<Tetrahedron> tetrahedronSet;
    private Tetrahedron changed;

    @BeforeClass
    public void init() {
        changed = new Tetrahedron(
                new Point(5, 6, 7), new Point(4, 5, 9),
                new Point(6, 8, 9), new Point(1, 4, 9));
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(0, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        Tetrahedron tetrahedron3 = new Tetrahedron(
                new Point(1, 3, 5), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        tetrahedronSet = new HashSet<>();
        tetrahedronSet.add(tetrahedron1);
        tetrahedronSet.add(tetrahedron2);
        tetrahedronSet.add(tetrahedron3);
    }

    @DataProvider(name = "dataProviderAdd")
    public Object[][] provideDataAdd() {
        Set<Tetrahedron> store = new HashSet<>();
        for (Tetrahedron tetrahedron : tetrahedronSet) {
            TetrahedronRepository.getInstance().add(tetrahedron);
        }
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronSet}};
    }

    @Test(dataProvider = "dataProviderAdd")
    public void add(Set<Tetrahedron> repository, Set<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }

    @DataProvider(name = "dataProviderUpdate")
    public Object[][] provideDataUpdate() {
        TetrahedronRepository.getInstance().add(changed);
        tetrahedronSet.add(changed);
        for (Tetrahedron tetrahedron : tetrahedronSet) {
            if (tetrahedron.getId() == changed.getId()) {
                tetrahedron.setName("Tetrahedron A");
            }
        }
        for (Tetrahedron tetrahedron : tetrahedronSet) {
            if (tetrahedron.getId() == changed.getId()) {
                tetrahedron.setPoint(2, new Point(0, 4, 2));
            }
        }
        TetrahedronRepository.getInstance().setName(changed.getId(), "Tetra");
        TetrahedronRepository.getInstance().setPoint(changed.getId(), 2, new Point(0, 4, 2));
        Set<Tetrahedron> store = new HashSet<>();
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronSet}};
    }

    @Test(dataProvider = "dataProviderUpdate")
    public void update(Set<Tetrahedron> repository, Set<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }

    @DataProvider(name = "dataProviderRemove")
    public Object[][] provideDataRemove() {
        TetrahedronRepository.getInstance().remove(changed);
        tetrahedronSet.remove(changed);
        Set<Tetrahedron> store = new HashSet<>();
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronSet}};
    }

    @Test(dataProvider = "dataProviderRemove")
    public void remove(Set<Tetrahedron> repository, Set<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }

    @DataProvider(name = "dataProviderSort")
    public Object[][] provideDataSort(Method method) {
        Object[][] result = null;
        TetrahedronRepository.getInstance().clear();
        List<Tetrahedron> expected = new ArrayList<>();
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(0, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        Tetrahedron tetrahedron3 = new Tetrahedron(
                new Point(1, 3, 5), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        TetrahedronRepository.getInstance().add(tetrahedron1);
        TetrahedronRepository.getInstance().add(tetrahedron2);
        TetrahedronRepository.getInstance().add(tetrahedron3);
        tetrahedron1.setName("Tetrahedron 10");
        tetrahedron2.setName("Tetrahedron 42");
        tetrahedron3.setName("Tetrahedron 13");
        if (method.getName().equals("sortByName")) {
            expected.add(tetrahedron1);
            expected.add(tetrahedron3);
            expected.add(tetrahedron2);
            result = new Object[][]{{TetrahedronRepository.getInstance().sortByName(), expected}};
        }
        if (method.getName().equals("sortById")) {
            expected.add(tetrahedron3);
            expected.add(tetrahedron1);
            expected.add(tetrahedron2);
            expected = expected.stream()
                    .sorted(Comparator.comparing(Tetrahedron::getId))
                    .collect(Collectors.toCollection(ArrayList::new));
            result = new Object[][]{{TetrahedronRepository.getInstance().sortById(), expected}};
        }

        if (method.getName().equals("sortByArea")) {
            expected.add(tetrahedron3);
            expected.add(tetrahedron1);
            expected.add(tetrahedron2);
            result = new Object[][]{{TetrahedronRepository.getInstance().sortByArea(), expected}};
        }

        if (method.getName().equals("sortByVolume")) {
            expected.add(tetrahedron3);
            expected.add(tetrahedron1);
            expected.add(tetrahedron2);
            result = new Object[][]{{TetrahedronRepository.getInstance().sortByVolume(), expected}};
        }
        return result;
    }

    @Test(dataProvider = "dataProviderSort")
    public void sortByName(List<Tetrahedron> result, List<Tetrahedron> expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "dataProviderSort")
    public void sortById(List<Tetrahedron> result, List<Tetrahedron> expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "dataProviderSort")
    public void sortByArea(List<Tetrahedron> result, List<Tetrahedron> expected) {
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "dataProviderSort")
    public void sortByVolume(List<Tetrahedron> result, List<Tetrahedron> expected) {
        Assert.assertEquals(result, expected);
    }
}
