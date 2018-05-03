package by.epam.task1b.observer;

import by.epam.task1b.action.TetrahedronAction;
import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.registrar.ParameterKeeper;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TetrahedronObserverTest {
    private Tetrahedron changedTetrahedron;

    @BeforeClass
    public void init() {
        TetrahedronObserver observer = new TetrahedronObserver();
        changedTetrahedron = new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        TetrahedronRepository.getInstance().add(changedTetrahedron);
        for (Tetrahedron tetrahedron : TetrahedronRepository.getInstance()){
            tetrahedron.addObserver(observer);
        }
    }

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        TetrahedronAction action = new TetrahedronAction();
        double area1 = action.calculateSurfaceArea(changedTetrahedron);
        double areaParameter1 = ParameterKeeper.getInstance().getArea(changedTetrahedron.getId());
        double volume1 = action.calculateVolume(changedTetrahedron);
        double volumeParameter1 = ParameterKeeper.getInstance().getVolume(changedTetrahedron.getId());
        changedTetrahedron.setPoint(0, new Point(0, 0, 15));
        double area2 = action.calculateSurfaceArea(changedTetrahedron);
        double areaParameter2 = ParameterKeeper.getInstance().getArea(changedTetrahedron.getId());
        double volume2 = action.calculateVolume(changedTetrahedron);
        double volumeParameter2 = ParameterKeeper.getInstance().getVolume(changedTetrahedron.getId());
        return new Object[][]{{areaParameter1, area1}, {volumeParameter1, volume1}, {areaParameter2, area2},
                {volume2, volumeParameter2}};
    }

    @Test(dataProvider = "dataProvider")
    public void handleEvent(double value, double expected){
        Assert.assertEquals(value, expected);
    }
}
