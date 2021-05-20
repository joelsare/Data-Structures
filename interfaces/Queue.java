package edu.unomaha.csci3320.interfaces;

import java.util.NoSuchElementException;

public interface Queue<T>
{
	/**
	 * Adds the given element to the end of the queue (analogous to enqueue).
	 */
	boolean add(T x) throws NullPointerException;
	
	/**
	 * Removes and returns the element at the front of the queue.
	 */
	T dequeue() throws NoSuchElementException;
	
	/**
	 * Adds the given element to the end of the queue.
	 */
	boolean enqueue(T x) throws NullPointerException;
	
	/**
	 * Check if the queue is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Returns the element at the front of the queue.
	 */
	T peek() throws NoSuchElementException;
	
	/**
	 * Removes and returns the element at the front of the queue (analogous to dequeue).
	 */
	T remove() throws NoSuchElementException;
	
	/**
	 * Returns the number of elements in this queue.
	 */
	int size();
	
	/**
	 * Returns an array containing all of the elements in this stack (preserving their order).
	 */
	Object[] toArray();
}
