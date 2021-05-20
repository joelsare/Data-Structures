package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.interfaces.Sequence;

public class LinkedListRecursive<T extends Comparable<T>> implements Sequence<T>
{
	class Node
	{
		private T data;
		
		Node next;
		
		public Node(T dataIn, Node nextIn)
		{
			data = dataIn;
			next = nextIn;
		}
	}
	
	private Node head;
	private int size = 0;
	
	public boolean add(int index, T x)  throws IndexOutOfBoundsException, NullPointerException
	{
		if (index < 0 || index > size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		head = addHelper(head, index, x);
		size++;
		return true;
	}
	
	private Node addHelper(Node xs, int index, T x)
	{
		if (index == 0)
		{
			return new Node (x, xs);
		}
		xs.next = addHelper(xs.next, index - 1, x);
		return xs;
	}

	public boolean add(T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		head = addHelper(head, x);
		size++;
		return true;
	}
	
	private Node addHelper(Node xs, T x)
	{
		if (xs == null)
		{
			return new Node(x, null);
		}
		xs.next = addHelper(xs.next, x);
		return xs;
	}
	
	public boolean contains(T x)
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		return containsHelper(head, x);
	}
	
	private boolean containsHelper(Node xs, T x)
	{
		if (xs == null)
		{
			return false;
		}
		else if (xs.data.compareTo(x) == 0)
		{
			return true;
		}
		else
		{
			return containsHelper(xs.next, x);
		}
	}
	
	public T get(int index)
	{
		if (index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		return getHelper(head, index);
	}
	
	private T getHelper(Node xs, int index)
	{
		if (index == 0)
		{
			return xs.data;
		}
		else
		{
			return getHelper(xs.next, index - 1);
		}
	}
	
	public void clear()
	{
		head = null;
		size = 0;
	}
	
	public int indexOf(T x)
	{
		return indexOfHelper(0, x);
	}
	
	public int indexOfHelper(int index, T x)
	{
		if (index == size())
		{
			return -1;
		}
		else if (get(index).compareTo(x) == 0)
		{
			return index;
		}
		else
		{
			return indexOfHelper(index + 1, x);
		}
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public T remove(int index)
	{
		T data = get(index);
		head = removeHelper(head, index);
		return data;
	}
	
	private Node removeHelper(Node xs, int index)
	{
		if (index == 0)
		{
			xs = xs.next;
		}
		else
		{
			xs.next = removeHelper(xs.next, index - 1);
		}
		return xs;
	}
	
	public boolean remove(T x)
	{
		int val = indexOf(x);
		
		if (val == -1)
		{
			return false;
		}
		else
		{
			remove(val);
			return true;
		}
	}
	
	public void set(int index, T x)
	{
		setHelper(head, 0, index, x);
	}
	
	private void setHelper(Node xs, int current, int index, T x)
	{
		if (index == current)
		{
			xs.data = x;
		}
		else
		{
			setHelper(xs.next, current + 1, index, x);
		}
	}
	
	public int size()
	{
		return size;
	}
	
	public Object[] toArray()
	{
		return null;
	}
	
	public String toString()
	{
		return "Yeet";
	}
}
