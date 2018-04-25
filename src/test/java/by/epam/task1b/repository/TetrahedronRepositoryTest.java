package by.epam.task1b.repository;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TetrahedronRepositoryTest {
    private ArrayList<Tetrahedron> list;

    @BeforeClass
    public void init() {
        list = new ArrayList<>();
        list.add(new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6)));
        list.add(new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6)));
    }

    @Test
    public void add() {
        for (Tetrahedron tetrahedron : list) {
            TetrahedronRepository.getInstance().add(tetrahedron);
        }
        TetrahedronRepository.getInstance().add(new Tetrahedron(
                new Point(2, 4, 0), new Point(3, 2, 8),
                new Point(6, 8, 8), new Point(1, 4, 8))
        );
    }

    @Test
    public void change() {
        TetrahedronRepository.getInstance().setName(list.get(0).getId(), "Tetra");
        TetrahedronRepository.getInstance().setPoint(list.get(1).getId(), 2, new Point(0, 4, 2));
    }

    @Test
    public void remove() {
        TetrahedronRepository.getInstance().remove(list.get(0));
    }
}
