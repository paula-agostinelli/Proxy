package org.example.ejercicio1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class TelefonoProxy implements Set<Telefono> {
    private int idDePersona;
    private PersonaDao personaDao;

    public TelefonoProxy(int idDePersona, PersonaDao personaDao) {
        this.idDePersona = idDePersona;
        this.personaDao = personaDao;
    }
    @Override
    public boolean add(Telefono telefono) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Telefono> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return personaDao.telefonosDePersona(this.idDePersona).toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
