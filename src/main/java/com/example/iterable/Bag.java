package com.example.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Bag<E> implements Container<E> {
    
    private ArrayList<E> elements;
    
    public Bag() {
        this.elements = new ArrayList<>();
    }
    
    @Override
    public void add(E item) {
        elements.add(item);
    }
    
    @Override
    public boolean remove(E item) {
        return elements.remove(item);
    }
    
    @Override
    public boolean contains(E item) {
        return elements.contains(item);
    }
    
    @Override
    public int size() {
        return elements.size();
    }
    
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    @Override
    public Iterator<E> iterator() {
        return new BagIterator();
    }
    
    @Override
    public void forEach(Consumer<? super E> action) {
        elements.forEach(action);
    }
    
    @Override
    public Spliterator<E> spliterator() {
        return elements.spliterator();
    }
    
    private class BagIterator implements Iterator<E> {
        private int currentIndex = 0;
        
        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }
        
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException(""No more elements in the bag"");
            }
            return elements.get(currentIndex++);
        }
    }
}