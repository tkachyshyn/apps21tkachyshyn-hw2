package ua.edu.ucu.collections.immutable;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableLinkedListTest {
    ImmutableLinkedList lst = new ImmutableLinkedList();
    Object[] arr = new Object[4];

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Object[] arr = {1, 1, 1, 1};
        lst = new ImmutableLinkedList(arr);
    }


    @org.junit.jupiter.api.Test
    void testAdd() {
        Object e = 1;
        Object[] arr1 = {1, 1, 1, 1, 1};
        ImmutableList res = lst.add(e);
        assertArrayEquals(res.toArray(), arr1);

    }

    @org.junit.jupiter.api.Test
    void testAddAll() {
        Object[] e = {1, 1};
        Object[] arr1 = {1, 1, 1, 1, 1, 1};
        ImmutableList res = lst.addAll(e);
        assertArrayEquals(res.toArray(), arr1);
    }

    @org.junit.jupiter.api.Test
    void testGet() {
        Object val = 1;
        assertEquals(lst.get(0), val);
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        Object[] arr1 = {1, 1, 1, 1};
        ImmutableList res = lst.remove(0);
        assertArrayEquals(res.toArray(), arr1);
    }


    @org.junit.jupiter.api.Test
    void testIndexOf() {
        assertEquals(lst.indexOf(1), 0);
    }

    @org.junit.jupiter.api.Test
    void testSize() {
        assertEquals(lst.size(), 4);
    }

    @org.junit.jupiter.api.Test
    void testClear() {
        Object arr[] = new Object[0];
        assertArrayEquals(lst.clear().toArray(), arr);
    }

    @org.junit.jupiter.api.Test
    void testIsEmpty() {
        lst = new ImmutableLinkedList();
        assertEquals(lst.isEmpty(), true);
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
        Object[] arr = {1, 1, 1, 1};
        lst = new ImmutableLinkedList(arr);
        assertArrayEquals(lst.toArray(), arr);
    }

    @org.junit.jupiter.api.Test
    void testAddFirst() {
    }

    @org.junit.jupiter.api.Test
    void testAddLast() {
    }

    @org.junit.jupiter.api.Test
    void getHead() {
    }

    @org.junit.jupiter.api.Test
    void getTail() {
    }

    @org.junit.jupiter.api.Test
    void getFirst() {
    }

    @org.junit.jupiter.api.Test
    void getLast() {
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
    }
}