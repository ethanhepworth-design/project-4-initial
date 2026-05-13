package com.example.iterable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    
    private Bag<String> bag;
    
    @BeforeEach
    void setUp() {
        bag = new Bag<>();
    }
    
    @Test
    void testNewBagIsEmpty() {
        assertTrue(bag.isEmpty());
    }
    
    @Test
    void testNewBagSizeIsZero() {
        assertEquals(0, bag.size());
    }
    
    @Test
    void testAddSingleElement() {
        bag.add(""apple"");
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }
    
    @Test
    void testAddMultipleElements() {
        bag.add(""apple"");
        bag.add(""banana"");
        bag.add(""cherry"");
        assertEquals(3, bag.size());
    }
    
    @Test
    void testContains() {
        bag.add(""apple"");
        assertTrue(bag.contains(""apple""));
        assertFalse(bag.contains(""banana""));
    }
    
    @Test
    void testRemove() {
        bag.add(""apple"");
        assertTrue(bag.remove(""apple""));
        assertFalse(bag.remove(""banana""));
        assertEquals(0, bag.size());
    }
    
    @Test
    void testIteratorHasNext() {
        bag.add(""apple"");
        Iterator<String> iter = bag.iterator();
        assertTrue(iter.hasNext());
    }
    
    @Test
    void testIteratorNext() {
        bag.add(""apple"");
        bag.add(""banana"");
        Iterator<String> iter = bag.iterator();
        assertEquals(""apple"", iter.next());
        assertEquals(""banana"", iter.next());
        assertFalse(iter.hasNext());
    }
    
    @Test
    void testForEachLoop() {
        bag.add(""a"");
        bag.add(""b"");
        StringBuilder sb = new StringBuilder();
        for (String s : bag) {
            sb.append(s);
        }
        assertEquals(""ab"", sb.toString());
    }
    
    @Test
    void testEmptyBagOperations() {
        assertFalse(bag.contains(""test""));
        assertFalse(bag.remove(""test""));
        assertEquals(0, bag.size());
    }
    
    @Test
    void testNullHandling() {
        bag.add(null);
        assertEquals(1, bag.size());
        assertTrue(bag.contains(null));
    }
    
    // Extra Credit Tests
    
    @Test
    void testForEachMethod() {
        bag.add(""x"");
        bag.add(""y"");
        bag.add(""z"");
        StringBuilder sb = new StringBuilder();
        bag.forEach(item -> sb.append(item));
        assertEquals(""xyz"", sb.toString());
    }
    
    @Test
    void testSpliterator() {
        bag.add(""a"");
        bag.add(""b"");
        bag.add(""c"");
        Spliterator<String> spliterator = bag.spliterator();
        assertNotNull(spliterator);
        assertEquals(3, spliterator.estimateSize());
    }
    
    @Test
    void testSpliteratorTryAdvance() {
        bag.add(""1"");
        bag.add(""2"");
        Spliterator<String> spliterator = bag.spliterator();
        StringBuilder sb = new StringBuilder();
        spliterator.forEachRemaining(item -> sb.append(item));
        assertEquals(""12"", sb.toString());
    }
}