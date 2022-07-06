package com.specialist.bodrov.homework.MyArrayList;

import jdk.internal.util.ArraysSupport;
import java.util.Arrays;
import java.util.Objects;

/**
 * Resizable-array implementation of the {@code List} interface.
 * Implements operations {@code add}, {@code get}, {@code size},
 * {@code remove}. This class provides methods to manipulate
 * the size of the array that is used internally to store integer values.
 * The {@code size}, {@code get} run in constant time.
 * The {@code add} operation runs in amortized constant time, that is,
 * adding n elements requires O(n) time.
 * The {@code remove} operation runs in linear time.
 * Each {@code MyIntList} instance has a capacity. The capacity is the
 * size of the array used to store the integer elements in the list.
 * It is always at least as large as the list size. As elements are added
 * to MyIntList its capacity grows automatically.
 * An application can increase the capacity of an {@code MyIntList}
 * instance before adding a large number of elements using the
 * {@code ensureCapacity}. This may reduce the amount of incremental
 * reallocation.
 */
public class MyIntList
{
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     */
    private static final int[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances.
     * Distinguished this from {@code EMPTY_ELEMENTDATA}
     * to know how much to inflate when first integer element is added.
     */
    private static final int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * The array buffer into which the elements of the MyIntList are stored.
     * The capacity of the MyIntList is the length of this array buffer.
     * Any empty MyIntList with elementData ==
     * {@code DEFAULTCAPACITY_EMPTY_ELEMENTDATA}
     */
    transient int[] elementData; // non-private to simplify nested class access

    /**
     * The size of the MyIntList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     */
    public MyIntList(int initialCapacity)
    {
        if (initialCapacity > 0) {
            this.elementData = new int[initialCapacity];
        }
        else if (0 == initialCapacity) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
        else {
            // to be done
            // throw Exception
        }
    }

    /**
     * Constructs an empty list with an initial capacity ==
     * {@code DEFAULT_CAPACITY}
     */
    public MyIntList()
    {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Trims the capacity of this {@code MyIntList} instance to be
     * the list's current size. An application can use this operation
     * to minimize the storage of an {@code MyIntList} instance.
     */
    public void trimToSize()
    {
        if (size < elementData.length) {
            elementData = (size == 0) ?
                EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * Increases the capacity of this {@code MyIntList} instance,
     * if necessary, to ensure that it can hold at least the number of
     * elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity > elementData.length &&
            !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA &&
            minCapacity <= DEFAULT_CAPACITY))
        {
            grow(minCapacity);
        }
    }

    /**
     * Increases the capacity to ensure that it can hold at least the number
     * of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private int[] grow(int minCapacity)
    {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 ||
            elementData!= DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
        {
            int newCapacity = ArraysSupport.newLength(
                oldCapacity, minCapacity - oldCapacity,
                oldCapacity >> 1
            );
            return elementData = Arrays.copyOf(elementData, newCapacity);
        }
        else {
            return elementData =
                new int[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private int[] grow() {
        return grow(size + 1);
    }

    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    public int size()
    {
        return size;
    }

    /**
     * Returns an array containing all the integer elements in this list
     * in proper sequence (from first to last element).
     *
     * @return an array containing all the integer elements in this list
     * in proper sequence
     */
    public int[] toArray()
    {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index)
    {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    /**
     * Replaces the element at the specified position in this list
     * with the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public int set(int index, int element)
    {
        Objects.checkIndex(index, size);
        int oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    private void add(int el, int[] elementData, int s)
    {
        if (s == elementData.length) {
            elementData = grow();
        }
        elementData[s] = el;
        size = s + 1;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param el element to be appended to this list
     * @return {@code true}
     */
    public boolean add(int el) {
        add(el, elementData, size);
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any)
     * and any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted.
     * @param el element to be inserted
     */
    public void add(int index, int el)
    {
        final int s;
        int[] elementData;
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
        System.arraycopy(
            elementData, index, elementData, index + 1, s - index);
        elementData[index] = el;
        size = s + 1;
    }
}