package by.epam.task1b.specification;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import by.epam.task1b.repository.TetrahedronRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class TetrahedronByNameSpecificationTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        TetrahedronRepository.getInstance().clear();
        Tetrahedron tetrahedron1 = new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6));
        Tetrahedron tetrahedron2 = new Tetrahedron(
                new Point(12, 21, 31), new Point(14, 25, 10),
                new Point(16, 18, 10), new Point(21, 14, 10));
        Tetrahedron tetrahedron3 = new Tetrahedron(
                new Point(12, 1, 33), new Point(11, 3, 2),
                new Point(16, 12, 2), new Point(17, 14, 2));

        tetrahedron1.setName("");
        tetrahedron2.setName("");
        tetrahedron3.setName("Tetrahedron C");
        TetrahedronRepository.getInstance().add(tetrahedron1);
        TetrahedronRepository.getInstance().add(tetrahedron2);
        TetrahedronRepository.getInstance().add(tetrahedron3);
        Set<Tetrahedron> expected = new HashSet<>();
        Set<Tetrahedron> result = TetrahedronRepository.getInstance().query(
                new SelectTetrahedronByNameSpecification(""));
        expected.add(tetrahedron1);
        expected.add(tetrahedron2);
        return new Object[][]{{result, expected}};
    }

    @Test(dataProvider = "dataProvider")
    public void query(Set<Tetrahedron> result, Set<Tetrahedron> expected) {
        Assert.assertEquals(result, expected);
    }
}
