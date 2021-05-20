package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.interfaces.Sequence;

public class LinkedList<T extends Comparable<T>> implements Sequence<T> {

    // A linked list is defined in terms of nodes, where a node is simple record
    // comprised of a datum and a reference to the next node in the sequence.

    class Node {
        T datum;
        Node next;

        Node(T datum) {
            this(datum, null);
        }

        Node(T datum, Node next) {
            this.datum = datum;
            this.next = next;
        }
    }

    // An individual list is defined in terms of a reference to its first node in the
    // sequence (referred to as its head). In addition, the current size of the list
    // is maintained.

    private Node head;
    private int size;

    /**
     * Initializes an empty list.
     */
    public LinkedList() {
        head = null;
        size = 0;
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

        if (index == 0)
        {
            head = new Node(x, head);
        } 
        else
        {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
            {
                temp = temp.next;
            }

            Node node = new Node(x, null);
            node.next = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    /**
     * Adds the specified element to the end of the sequence.
     *
     * @param x the element to add
     * @return {@code true} if and only if adding the element changed the sequence
     * @throws NullPointerException if the given element is {@code null}
     */
    @Override
    public boolean add(T x) throws NullPointerException
    {
        datumValidityCheck(x);

        if (head == null)
        {
            head = new Node(x);
        } 
        else
        {
            Node temp = head;

            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = new Node(x);
        }
        size++;
        return true;
    }

    /**
     * Removes all of the elements from the sequence.
     */
    @Override
    public void clear() {
        head = null;
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

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.datum;
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

        Node temp = head;
        boolean found = false;
        int i = 0;

        while (!found && temp != null) {
            int comparisonResult = temp.datum.compareTo(x);
            if (comparisonResult == 0) {
                found = true;
            } else {
                temp = temp.next;
                i++;
            }
        }

        if (found)
		return i;
	else
		return -1;
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
    public T remove(int index) throws IndexOutOfBoundsException
    {
        indexBoundsCheck(index);
        if (index == 0)
        {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++)
        {
            temp = temp.next;
        }
        T data = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return data;
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

        // if the list is empty, nothing needs to be done
        if (isEmpty()) {
            return false;
        }

        // if the object to be removed is the first element of the list, we treat this as a special case
        if (head.datum.compareTo(x) == 0) {
            head = head.next;
            size--;
            return true;
        }

        // otherwise, we have to find the node which immediately precedes the one containing x (if it exists)
        Node temp = head;
        while ((temp.next != null) && (temp.next.datum.compareTo(x) != 0)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return false;
        }

        temp.next = temp.next.next;
        size--;
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
    public void set(int index, T x) throws IndexOutOfBoundsException, NullPointerException
    {
        indexBoundsCheck(index);
        datumValidityCheck(x);

        Node temp = head;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        temp.datum = x;
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

        Node temp = head;
        for (int i = 0; i < size(); i++) {
            objects[i] = temp.datum;
            temp = temp.next;
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

        Node temp = head;
        if (temp != null) {
            stringRepresentation.append(temp.datum);
            do {
                temp = temp.next;
                if (temp != null) {
                    stringRepresentation.append(", ").append(temp.datum);
                }
            } while (temp != null);
        }

        stringRepresentation.append("]");

        return stringRepresentation.toString();
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