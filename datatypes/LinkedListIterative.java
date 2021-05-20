package edu.unomaha.csci3320.datatypes;

import edu.unomaha.csci3320.datatypes.LinkedListRecursive.Node;
import edu.unomaha.csci3320.interfaces.Sequence;

public class LinkedListIterative<T extends Comparable<T>> implements Sequence<T>
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
	
	Node head;
	Node tail;
	int size = 0;
	
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
			size++;
		}
		else if (index < size && !isEmpty())
		{
			Node prev = getNode(index - 1);
			Node newNode = new Node(x, prev.next);
			prev.next = newNode;
			size++;
		}
		else
		{
			add(x);
		}
		return true;
	}
	
	private Node getNode(int index) throws IndexOutOfBoundsException
	{
		Node temp = head;
		for (int i = 0; i < index; i++)
		{
			temp = temp.next;
		}
		return temp;
	}

	public boolean add(T x) throws NullPointerException
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
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}

	public void clear()
	{
		head = null;
		tail = null;
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
		Node temp = head;
		for (int i = 0; i < index; i++)
		{
			temp = temp.next;
		}
		return temp.data;
	}

	public int indexOf(T x) throws NullPointerException
	{
		int location = -1;
		Node temp = head;
		
		for (int i = 0; i < size(); i++)
		{
			if (temp.data.compareTo(x) == 0)
			{
				location = i;
				break;
			}
			temp = temp.next;
		}
		return location;
	}

	public boolean isEmpty()
	{
		return size == 0;
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
			data = head.data;
			head = null;
			tail = null;
		}
		else if (index == 0)
		{
			data = head.data;
			head = head.next;
		}
		else
		{
			Node prev = getNode(index - 1);
			data = prev.next.data;
			prev.next = prev.next.next;
			if (index == size() - 1)
			{
				tail = prev;
			}
		}
		size--;
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
		temp.data = x;
	}

	public int size()
	{
		return size;
	}

	public Object[] toArray()
	{
		return null;
	}

}
