package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTetrahedronByIdSpecificationTest {
    @Test(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void query() {
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(0, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        Tetrahedron tetrahedron3 = new Tetrahedron(
                new Point(1, 3, 5), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        List<Tetrahedron> expected = new ArrayList<>();
        List<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SortTetrahedronByIdSpecification());
        expected.add(tetrahedron2);
        expected.add(tetrahedron3);
        expected.add(tetrahedron1);
        Assert.assertEquals(result, expected);
    }
}
