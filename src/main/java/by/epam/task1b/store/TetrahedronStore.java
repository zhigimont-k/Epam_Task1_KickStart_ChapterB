package by.epam.task1b.store;

import by.epam.task1b.entity.Figure;
import by.epam.task1b.entity.Tetrahedron;

import java.util.*;

public class TetrahedronStore implements Iterable<Tetrahedron> {
    private Set<Tetrahedron> store;
    private static TetrahedronStore instance;

    private TetrahedronStore(){
        store = new HashSet<>();
    }

    public static TetrahedronStore getInstance(){
        if (instance == null){
            instance = new TetrahedronStore();
        }
        return instance;
    }

    public Tetrahedron get(long id){
        for (Tetrahedron tetrahedron : store){
            if (id == tetrahedron.getId()){
                return tetrahedron;
            }
        }
        return null;
    }

    public Set<Tetrahedron> getStore() {
        return Collections.unmodifiableSet(store);
    }

    public void add(Figure figure) {
        store.add((Tetrahedron) figure);
    }

    public void remove(Figure figure) {
        store.remove(figure);
    }


    @Override
    public Iterator<Tetrahedron> iterator() {
        return store.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        TetrahedronStore other = (TetrahedronStore) o;
        return store.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (Tetrahedron tetrahedron : store) {
            hash += hash * 31 + tetrahedron.hashCode();
        }
        return hash;
    }

    @Override
    public String toString() {
        return store.toString();
    }
}
