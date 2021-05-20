package edu.unomaha.csci3320.datatypes;

import java.util.NoSuchElementException;

import edu.unomaha.csci3320.interfaces.Sequence;
import edu.unomaha.csci3320.interfaces.Stack;

public class BasicStack<T extends Comparable<T>> implements Stack<T>
{
	Sequence<T> list;
	
	/**
	 * Constructs a new empty stack.
	 */
	public BasicStack()
	{
		list = new LinkedList<T>();
	}
	
	/**
	 * Adds the given element to the top of the stack (analogous to push).
	 */
	public boolean add(T x) throws NullPointerException
	{
		return push(x);
	}
	
	/**
	 * Checks to see if value is null.
	 */
	private void checkNull(T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
	}
	
	/**
	 * Check if the stack is empty.
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	/**
	 * Returns the element at the top of the stack.
	 */
	public T peek() throws NoSuchElementException
	{
		checkEmpty();
		return list.get(0);
	}
	
	/**
	 * Checks to see if stack is empty.
	 */
	private void checkEmpty() throws NoSuchElementException
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes and returns the element at the top of the stack.
	 */
	public T pop() throws NoSuchElementException
	{
		checkEmpty();
		return list.remove(0);
	}
	
	/**
	 * Adds the given element to the top of the stack.
	 */
	public boolean push(T x) throws NullPointerException
	{
		checkNull(x);
		return list.add(0, x);
	}
	
	/**
	 * Returns the number of elements in this stack.
	 */
	public int size()
	{
		return list.size();
	}
	
	/**
	 * Returns an array containing all of the elements in this stack (preserving their order).
	 */
	public Object[] toArray()
	{
		return list.toArray();
	}
}
