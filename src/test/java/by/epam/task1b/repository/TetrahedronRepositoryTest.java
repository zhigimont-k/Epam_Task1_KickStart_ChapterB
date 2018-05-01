package by.epam.task1b.repository;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.store.TetrahedronStore;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TetrahedronRepositoryTest {
    private ArrayList<Tetrahedron> tetrahedronList;

    @BeforeClass
    public void init() {
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        tetrahedronList = new ArrayList<>();
        tetrahedronList.add(tetrahedron1);
        tetrahedronList.add(tetrahedron2);
    }

    @DataProvider(name = "dataProviderAdd")
    public Object[][] provideDataAdd(){
        ArrayList<Tetrahedron> store = new ArrayList<>();
        for (Tetrahedron tetrahedron : tetrahedronList) {
            TetrahedronRepository.getInstance().add(tetrahedron);
        }
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()){
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronList}};
    }

    @Test(dataProvider = "dataProviderAdd")
    public void add(ArrayList<Tetrahedron> repository, ArrayList<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }

    @DataProvider(name = "dataProviderChange")
    public Object[][] provideDataChange(){
        tetrahedronList.get(0).setName("Tetra");
        tetrahedronList.get(0).setPoint(2, new Point(0, 4, 2));
        TetrahedronRepository.getInstance().setName(tetrahedronList.get(0).getId(), "Tetra");
        TetrahedronRepository.getInstance().setPoint(tetrahedronList.get(0).getId(), 2, new Point(0, 4, 2));
        ArrayList<Tetrahedron> store = new ArrayList<>();
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronList}};
    }

    @Test(dataProvider = "dataProviderChange")
    public void change(ArrayList<Tetrahedron> repository, ArrayList<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }

    @DataProvider(name = "dataProviderRemove")
    public Object[][] provideDataRemove(){
        TetrahedronRepository.getInstance().remove(tetrahedronList.get(1));
        tetrahedronList.remove(1);
        ArrayList<Tetrahedron> store = new ArrayList<>();
        for (Tetrahedron tetrahedron : TetrahedronStore.getInstance()) {
            store.add(tetrahedron);
        }
        return new Object[][]{{store, tetrahedronList}};
    }

    @Test(dataProvider = "dataProviderRemove")
    public void remove(ArrayList<Tetrahedron> repository, ArrayList<Tetrahedron> expected) {
        Assert.assertEquals(repository, expected);
    }
}
