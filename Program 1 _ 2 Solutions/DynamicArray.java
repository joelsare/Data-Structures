package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.interfaces.Sequence;

import java.util.Arrays;

public class DynamicArray<T extends Comparable<T>> implements Sequence<T> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int GROWTH_FACTOR = 2;
    private static final int RESIZE_LIMIT = 2;

    private T[] data;
    private int size;

    /**
     * Initialize an empty dynamic array.
     */
    public DynamicArray() {
        this(INITIAL_CAPACITY);
    }

    private DynamicArray(int capacity) {
        this.data = (T[]) new Comparable[capacity];
        this.size = 0;
    }

    /**
     * Inserts the given element at the specified index position within the sequence. The element currently at that
     * index position (and all subsequent elements) are shifted to the right.
     *
     * @param index the index at which the given element is to be inserted
     * @param x     the element to insert
     * @return {@code true} if and only if adding the element changed the sequence
     * @throws IndexOutOfBoundsException if the index is invalid {@code (index < 0 || index > size())}
     * @throws NullPointerException      if the given element is {@code null}
     */
    @Override
    public boolean add(int index, T x) throws IndexOutOfBoundsException, NullPointerException {
        indexBoundsCheck(index);
        datumValidityCheck(x);

        if (resizeRequired()) {
            resize();
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = x;
        size++;

        return false;
    }

    /**
     * Adds the specified element to the end of the sequence.
     *
     * @param x the element to add
     * @return {@code true} if and only if adding the element changed the sequence
     * @throws NullPointerException if the given element is {@code null}
     */
    @Override
    public boolean add(T x) throws NullPointerException {
        datumValidityCheck(x);

        if (resizeRequired()) {
            resize();
        }

        data[size] = x;
        size++;

        return true;
    }

    /**
     * Returns the capacity of the underlying backing store (as opposed to the size of
     * the sequence itself).
     *
     * @return the capacity of the underlying backing store
     */
    public int capacity() {
        return data.length - size();
    }

    /**
     * Removes all of the elements from the sequence.
     */
    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    /**
     * Check if the given element belongs to the sequence.
     *
     * @param x the element to check for
     * @return {@code true} if and only if the sequence contains the given element
     * @throws NullPointerException if the given element is {@code null}
     */
    @Override
    public boolean contains(T x) throws NullPointerException {
        return indexOf(x) != -1;
    }

    /**
     * Returns the element at the given position in the sequence.
     *
     * @param index the index of the element to return
     * @return the element at the given position in the sequence
     * @throws IndexOutOfBoundsException if the index is invalid {@code (index < 0 || index >= size())}
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        indexBoundsCheck(index);

        return data[index];
    }

    /**
     * Returns the index position of the first occurrence of the given element within the sequence or -1 if it does not
     * belong.
     *
     * @param x the element to search for
     * @return the index position of the first occurrence of the given element within the sequence or -1 if it does not
     * belong
     * @throws NullPointerException if the given element is {@code null}
     */
    @Override
    public int indexOf(T x) throws NullPointerException {
        datumValidityCheck(x);

        boolean found = false;
        int i = 0;

        while (!found && i < size()) {
            int comparisonResult = data[i].compareTo(x);
            if (comparisonResult == 0) {
                found = true;
            } else {
                i++;
            }
        }

        return (found) ? i : -1;
    }

    /**
     * Check if the sequence is empty.
     *
     * @return {@code true} if and only if the sequence is empty.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Removes the element at the given position in the sequence.
     *
     * @param index the index position of the element to be removed
     * @return the element at the given position in the sequence
     * @throws IndexOutOfBoundsException if the index is invalid {@code (index < 0 || index >= size())}
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        indexBoundsCheck(index);

        T datum = data[index];
        size--;

        if (index != size) {
            System.arraycopy(data, index + 1, data, index, size - index);
        }

        data[size] = null;

        return datum;
    }

    /**
     * Remove the first occurrence of the given element from the sequence (if present).
     *
     * @param x the element to be removed from this list
     * @return {@code true} if and only if removing the element changed the sequence
     * @throws NullPointerException if the given element is {@code null}
     */
    @Override
    public boolean remove(T x) throws NullPointerException {
        datumValidityCheck(x);

        int index = indexOf(x);

        if (index == -1) {
            return false;
        }

        remove(index);

        return true;
    }

    /**
     * Replaces the element at the given position of the sequence with the specified element.
     *
     * @param index index of the element to replace
     * @param x     the new element
     * @throws IndexOutOfBoundsException if the index is invalid {@code (index < 0 || index >= size())}
     * @throws NullPointerException      if the given element is {@code null}
     */
    @Override
    public void set(int index, T x) throws IndexOutOfBoundsException, NullPointerException {
        indexBoundsCheck(index);
        datumValidityCheck(x);

        data[index] = x;
    }

    /**
     * Returns the number of elements in this sequence.
     *
     * @return the number of elements in this sequence
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an array containing all of the elements in this sequence (preserving their order).
     *
     * @return an array containing all of the elements in this sequence (preserving their order)
     */
    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];

        if (size() >= 0) {
            System.arraycopy(data, 0, objects, 0, size());
        }

        return objects;
    }

    /**
     * Return a {@code String} representation of the linked list.
     *
     * @return a {@code String} representation of the linked list.
     */
    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append("[");

        int i = 0;
        if (i < size()) {
            stringRepresentation.append(data[i]);
            do {
                i++;
                if (i < size()) {
                    stringRepresentation.append(", ").append(data[i]);
                }
            } while (i < size());
        }

        stringRepresentation.append("]");

        return stringRepresentation.toString();
    }

    /**
     * Determine whether or not the backing store needs to be resized or not. The backing
     * store needs to be resized when the difference between the size of the sequence
     * store in the array and the length of the array is less than the limit specified
     * by {@code RESIZE_LIMIT}.
     *
     * @return {@code true} if and only if the backing store must be resized
     */
    private boolean resizeRequired() {
        return (capacity() - size()) <= RESIZE_LIMIT;
    }

    private void resize() {
        // allocate the new backing store using the default resize factor
        T[] temp = (T[]) new Comparable[size() * GROWTH_FACTOR];

        // copy the contents over to the new backing store
        System.arraycopy(data, 0, temp, 0, size);

        // reset the dynamic array to use the new backing store
        // note that the size is unchanged
        data = temp;
    }

    /**
     * Determine whether or not the given index position is valid.
     *
     * @param index the index to check
     * @return {@code true} if and only if the index is valid {@code (index < 0 || index >= size())}
     */
    private boolean isValidIndex(int index) {
        return (0 <= index) && (index < size);
    }

    /**
     * Private argument validation function - determines if the given index position is defined, and if not, throws a
     * corresponding {@code IndexOutOfBoundsException}.
     *
     * @param index the index position to validate
     * @throws IndexOutOfBoundsException if the given index position is invalid
     */
    private void indexBoundsCheck(int index) throws IndexOutOfBoundsException {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException(String.format("index position %d is undefined", index));
        }
    }

    /**
     * Private argument validation function - determines if the given element is defined, and if not, throws a
     * corresponding {@code NullPointerException}.
     *
     * @param x the element to validate
     * @throws NullPointerException if the given element is not defined
     */
    private void datumValidityCheck(T x) throws NullPointerException {
        if (x == null) {
            throw new NullPointerException("null reference given as datum");
        }
    }
}
