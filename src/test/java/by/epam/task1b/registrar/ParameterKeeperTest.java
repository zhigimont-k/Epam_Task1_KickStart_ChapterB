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
    private Tetrahedron changedTetrahedron;
    private Map<Long, TetrahedronParameter> expectedMap;

    @Test
    public void add() {
        changedTetrahedron = new Tetrahedron(
                new Point(6, 2, 3), new Point(4, 5, 7),
                new Point(6, 8, 7), new Point(1, 4, 7), 122);
        expectedMap = new HashMap<>();
        TetrahedronAction action = new TetrahedronAction();
        for (Tetrahedron tetrahedron : TetrahedronRepository.getInstance().getStore()){
            expectedMap.put(tetrahedron.getId(), new TetrahedronParameter(action.calculateSurfaceArea(tetrahedron),
                    action.calculateVolume(tetrahedron)));
        }
        expectedMap.put(changedTetrahedron.getId(), new TetrahedronParameter(action.calculateSurfaceArea(changedTetrahedron),
                action.calculateVolume(changedTetrahedron)));
        TetrahedronRepository.getInstance().add(changedTetrahedron);
        Assert.assertEquals(ParameterKeeper.getInstance().getParameterMap(), expectedMap);
    }

    @Test
    public void remove(){
        expectedMap.remove(changedTetrahedron.getId());
        TetrahedronRepository.getInstance().remove(changedTetrahedron);
        Assert.assertEquals(ParameterKeeper.getInstance().getParameterMap(), expectedMap);
    }
}
