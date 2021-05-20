package edu.unomaha.csci3320.datatypes;

import java.util.NoSuchElementException;

import edu.unomaha.csci3320.interfaces.Queue;
import edu.unomaha.csci3320.interfaces.Sequence;

public class BasicQueue<T extends Comparable <T>> implements Queue<T>
{
	Sequence<T> list;
	
	/**
	 * Constructs a new empty queue.
	 */
	public BasicQueue()
	{
		list = new LinkedList<T>();
	}
	
	/**
	 * Adds the given element to the end of the queue (analogous to enqueue).
	 */
	public boolean add(T x) throws NullPointerException
	{
		return enqueue(x);
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
	 * Removes and returns the element at the front of the queue.
	 */
	public T dequeue() throws NoSuchElementException
	{
		checkEmpty();
		return list.remove(0);
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
	 * Adds the given element to the end of the queue.
	 */
	public boolean enqueue(T x) throws NullPointerException
	{
		checkNull(x);
		return list.add(x);
	}
	
	/**
	 * Check if the queue is empty.
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	/**
	 * Returns the element at the front of the queue.
	 */
	public T peek() throws NoSuchElementException
	{
		checkEmpty();
		return list.get(0);
	}
	
	/**
	 * Removes and returns the element at the front of the queue (analogous to dequeue).
	 */
	public T remove() throws NoSuchElementException
	{
		return dequeue();
	}
	
	/**
	 * Returns the number of elements in this queue.
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
