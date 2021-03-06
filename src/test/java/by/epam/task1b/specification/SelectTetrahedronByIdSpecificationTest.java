package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class SelectTetrahedronByIdSpecificationTest {

    @Test(dependsOnMethods = {"by.epam.task1b.repository.TetrahedronRepositoryTest.add"})
    public void query() {
        Set<Tetrahedron> expected = new HashSet<>();
        Tetrahedron tetrahedron = new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6), 42);
        Set<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SelectTetrahedronByIdSpecification(tetrahedron.getId()));
        expected.add(tetrahedron);
        Assert.assertEquals(result, expected);
    }
}
