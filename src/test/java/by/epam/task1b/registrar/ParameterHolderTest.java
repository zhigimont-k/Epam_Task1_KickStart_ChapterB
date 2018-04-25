package by.epam.task1b.registrar;

import by.epam.task1b.entity.Point;
import by.epam.task1b.entity.Tetrahedron;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

public class ParameterHolderTest {
    private ArrayList<Tetrahedron> list;

    @BeforeClass
    public void init(){
        list = new ArrayList<>();
        list.add(new Tetrahedron(
                new Point(1, 2, 3), new Point(4, 5, 6),
                new Point(6, 8, 6), new Point(1, 4, 6)));
        list.add(new Tetrahedron(
                new Point(2, 2, 8), new Point(4, 4, 6),
                new Point(7, 8, 6), new Point(1, 5, 6)));
    }
}
