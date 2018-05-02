package by.epam.task1b.observer;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;
import by.epam.task1b.repository.TetrahedronRepository;
import by.epam.task1b.store.TetrahedronStore;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TetrahedronObserverTest {
    private TetrahedronObserver observer;
    private Tetrahedron tetrahedron;

    @BeforeClass
    public void init() {
        observer = new TetrahedronObserver();
        tetrahedron = new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        TetrahedronRepository.getInstance().add(tetrahedron);
        for (Tetrahedron tetrahedron : TetrahedronRepository.getInstance()){
            tetrahedron.addObserver(observer);
        }
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        TetrahedronAction action = new TetrahedronAction();
        double area1 = action.calculateSurfaceArea(tetrahedron);
        double areaParameter1 = ParameterKeeper.getInstance().getArea(tetrahedron.getId());
        double volume1 = action.calculateVolume(tetrahedron);
        double volumeParameter1 = ParameterKeeper.getInstance().getVolume(tetrahedron.getId());
        tetrahedron.setPoint(0, new Point(0, 0, 15));
        double area2 = action.calculateSurfaceArea(tetrahedron);
        double areaParameter2 = ParameterKeeper.getInstance().getArea(tetrahedron.getId());
        double volume2 = action.calculateVolume(tetrahedron);
        double volumeParameter2 = ParameterKeeper.getInstance().getVolume(tetrahedron.getId());
        return new Object[][]{{areaParameter1, area1}, {volumeParameter1, volume1}, {areaParameter2, area2},
                {volume2, volumeParameter2}};
    }

    @Test(dataProvider = "dataProvider")
    public void handleEvent(double value, double expected){
        Assert.assertEquals(value, expected);
    }
}
