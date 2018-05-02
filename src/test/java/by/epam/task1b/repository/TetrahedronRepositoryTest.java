package by.epam.task1b.repository;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class TetrahedronRepositoryTest {
    private Set<Tetrahedron> expectedSet;
    private Tetrahedron removedTetrahedron;

    @BeforeClass
    public void init() {
        removedTetrahedron = new Tetrahedron(
                new Point(5, 6, 7), new Point(4, 5, 9),
                new Point(6, 8, 9), new Point(1, 4, 9));
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(0, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        tetrahedron2.setId(42);
        Tetrahedron tetrahedron3 = new Tetrahedron(
                new Point(1, 3, 5), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        tetrahedron3.setName("Tetrahedron C");
        expectedSet = new HashSet<>();
        expectedSet.add(tetrahedron1);
        expectedSet.add(tetrahedron2);
        expectedSet.add(tetrahedron3);
        expectedSet.add(removedTetrahedron);
    }

    @Test
    public void add() {
        for (Tetrahedron tetrahedron : expectedSet) {
            TetrahedronRepository.getInstance().add(tetrahedron);
        }
        Assert.assertEquals(TetrahedronRepository.getInstance().getStore(), expectedSet);
    }

    @Test(dependsOnMethods = {"add"})
    public void remove() {
        TetrahedronRepository.getInstance().remove(removedTetrahedron);
        expectedSet.remove(removedTetrahedron);
        Assert.assertEquals(TetrahedronRepository.getInstance().getStore(), expectedSet);
    }
}
