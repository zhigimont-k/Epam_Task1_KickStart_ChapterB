package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SelectTetrahedronByVolumeRangeSpecificationTest {

    @Test(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void query() {
        Tetrahedron tetrahedron = new Tetrahedron(
                new Point(1, 3, 5), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6));
        Set<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SelectTetrahedronByVolumeRangeSpecification(0, 3));
        Set<Tetrahedron> expected = new HashSet<>();
        expected.add(tetrahedron);
        Assert.assertEquals(result, expected);
    }

}
