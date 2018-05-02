package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SelectTetrahedronByVolumeSpecificationTest {

    @Test(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void query() {
        Tetrahedron tetrahedron = new Tetrahedron(
                new Point(0, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Set<Tetrahedron> expected = new HashSet<>();
        Set<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SelectTetrahedronByVolumeSpecification(3.5));
        expected.add(tetrahedron);
        Assert.assertEquals(result, expected);
    }
}
