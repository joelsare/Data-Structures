package edu.unomaha.csci3320.interfaces;

import java.util.NoSuchElementException;

public interface Stack<T>
{
	/**
	 * Adds the given element to the top of the stack (analogous to push).
	 */
	boolean add(T x) throws NullPointerException;
	
	/**
	 * Check if the stack is empty.
	 */
	boolean isEmpty(); 
	
	/**
	 * Returns the element at the top of the stack.
	 */
	T peek() throws NoSuchElementException;

	/**
	 * Removes and returns the element at the top of the stack.
	 */
	T pop() throws NoSuchElementException;
	
	/**
	 * Adds the given element to the top of the stack.
	 */
	boolean push(T x) throws NullPointerException;
	
	/**
	 * Returns the number of elements in this stack.
	 */
	int size();
	
	/**
	 * Returns an array containing all of the elements in this stack (preserving their order).
	 */
	Object[] toArray();
}
