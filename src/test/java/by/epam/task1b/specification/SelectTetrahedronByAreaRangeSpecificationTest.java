package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SelectTetrahedronByAreaRangeSpecificationTest {
    @Test(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void query() {
        Set<Tetrahedron> expected = new HashSet<>();
        Set<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SelectTetrahedronByAreaRangeSpecification(30, 100));
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(0, 0, 15), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        expected.add(tetrahedron1);
        expected.add(tetrahedron2);
        Assert.assertEquals(result, expected);
    }
}