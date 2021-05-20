package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.interfaces.Sequence;

public class LinkedList<T extends Comparable <T>> implements Sequence<T>
{

	class Node
	{
		private T data;
		
		Node next;
		
		public Node(T dataIn, Node nextIn)
		{
			setData(dataIn);
			setNext(nextIn);
		}
		
		public void setData(T dataIn)
		{
			data = dataIn;
		}
		
		public T getData()
		{
			return data;
		}
		
		public void setNext(Node nextIn)
		{
			next = nextIn;
		}
		
		public Node getNext()
		{
			return next;
		}
	}
	
	private Node head;
	private Node tail;
	private int numElements;
	
	public LinkedList()
	{
		clear();
	}
	
	public boolean add(int index, T x) throws IndexOutOfBoundsException, NullPointerException
	{
		if (index < 0 || index > size())
		{
			throw new IndexOutOfBoundsException();
		}
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		if (index == 0 && !isEmpty())
		{
			Node newNode = new Node(x, head);
			head = newNode;
			numElements++;
		}
		else if (index < numElements && !isEmpty())
		{
			Node prev = getNode(index - 1);
			Node newNode = new Node(x, prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
		else
		{
			add(x);
		}
		return true;
	}
	
	public boolean add (T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		Node newNode = new Node(x, null);
		
		if (head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.setNext(newNode);
			tail = newNode;
		}
		numElements++;
		return true;
	}

	public void clear()
	{
		head = null;
		tail = null;
		numElements = 0;
	}
	
	public boolean contains(T x) throws NullPointerException
	{	
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		int val = indexOf(x);
		return val != -1;
	}
	
	public T get(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index >= size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		return getNode(index).getData();
	}
	
	private Node getNode(int index) throws IndexOutOfBoundsException
	{
		Node newNode = head;
		return getNodeHelper(0, index, newNode);
	}
	
	private Node getNodeHelper(int s, int index, Node node)
	{
		if (s == index)
		{
			return node;
		}
		else
		{
			return getNodeHelper(s + 1, index, node.getNext());
		}
	}
	
	public int indexOf(T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		return indexOfHelper(0, x);
	}
	
	private int indexOfHelper(int index, T x)
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
		return numElements == 0;
	}
	
	public T remove(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index > size() - 1)
		{
			throw new IndexOutOfBoundsException();
		}
		
		T data;
		
		if (size() == 1)
		{
			data = head.getData();
			head = null;
			tail = null;
		}
		else if (index == 0)
		{
			data = head.getData();
			head = head.getNext();
		}
		else
		{
			Node prev = getNode(index - 1);
			data = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
			if (index == size() - 1)
			{
				tail = prev;
			}
		}
		numElements--;
		return data;
	}
	
	public boolean remove(T x) throws NullPointerException
	{
		if (x == null)
		{
			throw new NullPointerException();
		}
		
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
	
	public void set(int index, T x) throws IndexOutOfBoundsException, NullPointerException
	{
		if (index < 0 || index > size() - 1)
		{
			throw new IndexOutOfBoundsException();
		}
		if (x == null)
		{
			throw new NullPointerException();
		}
		
		Node temp = getNode(index);
		temp.setData(x);
	}
	
	public int size()
	{
		return numElements;
	}
	
	public Object[] toArray()
	{
		Object[] result = new Object[size()];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = get(i);
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		String result = "[";
		for (int i = 0; i < size(); i++)
		{
			if (i == size() - 1)
			{
				result += "" + get(i);
			}
			else
			{
				result += "" + get(i) + ", ";
			}
		}
		result += "]";
		return result;
	}
	
}
