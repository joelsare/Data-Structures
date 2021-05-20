package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.interfaces.Sequence;

public class DynamicArray<T extends Comparable<T>> implements Sequence<T>
{
	@SuppressWarnings("unchecked")
	private T[] arr;
	private int numItems;
	
	/**
	 * Constructor for this class.
	 */
	@SuppressWarnings("unchecked")
	public DynamicArray()
	{
		arr = (T[]) new Comparable[10];
		numItems = 0; 
	}
	
	/**
	 * Inserts the given element at the specified index position within the
	 * sequence. The element at that index position (and all subsequent elements)
	 * are shifted to the right.
	 */
	public boolean add (int index, T x) throws IndexOutOfBoundsException, NullPointerException
	{
		validExcParams(index);
		validObject(x);
		checkCapacity();
		
		for (int i = numItems - 1; i >= index; i--)
		{
			arr[i + 1] = arr[i];
		}
		arr[index] = x;
		numItems++;
		return true;
	}
	
	/**
	 * Adds the specified element to the end of the sequence.
	 */
	public boolean add (T x) throws NullPointerException
	{
		validObject(x);
		checkCapacity();
		
		arr[numItems] = x;
		numItems++;
		return true;
	}
	
	/**
	 * Checks the capacity and expands if needed.
	 */
	public void checkCapacity()
	{
		if (capacity() <= 3)
		{
			expand();
		}
	}
	
	/**
	 * Makes a larger array and copies values to it.
	 */
	private void expand()
	{
		@SuppressWarnings("unchecked")
		T[] biggerArray = (T[]) new Comparable[arr.length * 2];
		
		for (int i = 0; i < numItems; i++)
		{
			biggerArray[i] = arr[i];
		}
		
		arr = biggerArray;
	}
	
	/**
	 * Removes all of the elements from the sequence.
	 */
	public void clear()
	{
		numItems = 0;
	}
	
	/**
	 * Check if the given element belongs to the sequence.
	 */
	public boolean contains(T x) throws NullPointerException
	{
		validObject(x);
		
		int val = indexOf(x);
		
		return val != -1;
	}
	
	/**
	 * Returns the element at the given position in the sequence.
	 */
	public T get(int index) throws IndexOutOfBoundsException
	{
		validIncParams(index);
		
		return arr[index];
	}
	
	/**
	 * Returns the index position of the first occurrence of the given element
	 * within the sequence or -1 if it does not belong.
	 */
	public int indexOf(T x) throws NullPointerException
	{
		validObject(x);
		
		int val = -1;
		
		for (int i = 0; i < numItems; i++)
		{
			if (arr[i].compareTo(x) == 0)
			{
				val = i;
				break;
			}
		}
		return val;
	}
	
	/**
	 * Check if the sequence is empty.
	 */
	public boolean isEmpty()
	{
		return numItems == 0;
	}
	
	/**
	 * Removes the element at the given position in the sequence.
	 */
	public T remove(int index) throws IndexOutOfBoundsException
	{
		validIncParams(index);
		
		T data = arr[index];
		
		for (int i = index; i < numItems - 1; i++)
		{
			arr[i] = arr[i + 1];
		}
		numItems--;
		return data;
	}
	
	/**
	 * Remove the first occurrence of the given element from the sequence (if present).
	 */
	public boolean remove(T x) throws NullPointerException
	{
		validObject(x);
		
		if (contains(x))
		{
			remove(indexOf(x));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Replaces the element at the given position of the sequence with the specified
	 * element.
	 */
	public void set(int index, T x) throws IndexOutOfBoundsException, NullPointerException
	{
		validIncParams(index);
		validObject(x);
		
		arr[index] = x;
	}
	
	/**
	 * Returns the number of elements in this sequence.
	 */
	public int size()
	{
		return numItems;
	}
	
	/**
	 * Returns an array containing all of the elements in this sequence (preserving
	 * their order).
	 */
	public Object[] toArray()
	{
		Object[] newArray = new Object[numItems];
		
		for (int i = 0; i < numItems; i++)
		{
			newArray[i] = arr[i];
		}
		
		return newArray;
	}
	
	/**
	 * Returns a String representing this Object.
	 */
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append('[');
		for (int i = 0; i < numItems; i++)
		{
			if (i == numItems - 1)
			{
				s.append(get(i));
			}
			else
			{
				s.append(get(i) + ", ");
			}
		}
		s.append(']');
		return s.toString();
	}
	
	/**
	 * Returns the capacity of the backing store (i.e., the number of free cells within
	 * the underlying array).
	 * @return
	 */
	public int capacity()
	{
		return arr.length - numItems;
	}
	
	/**
	 * Checks to see if index is valid (inclusive).
	 */
	private void validIncParams(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= numItems)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	/**
	 * Checks to see if index is valid (exclusive).
	 */
	private void validExcParams(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index > numItems)
		{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public DynamicArray<T> reverse(DynamicArray xs)
	{
		DynamicArray<T> rev = new DynamicArray<T>();
		int i = xs.size() - 1;
		while (i >= 0)
		{
			rev.add((T) xs.get(i));
			i--;
		}
		return rev;
	}
	
	/**
	 * Checks to see if object is valid.
	 */
	private void validObject(T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
	}
}
