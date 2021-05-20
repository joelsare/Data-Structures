package edu.unomaha.csci3320.interfaces;

public interface Sequence<T> {
	
	boolean add(int index, T x) throws IndexOutOfBoundsException, NullPointerException;
	
	boolean add (T x) throws NullPointerException;
	
	void clear();
	
	boolean contains(T x) throws NullPointerException;
	
	T get(int index) throws IndexOutOfBoundsException;
	
	int indexOf(T x) throws NullPointerException;
	
	boolean isEmpty();
	
	T remove(int index) throws IndexOutOfBoundsException;
	
	boolean remove(T x) throws NullPointerException;
	
	void set(int index, T x) throws IndexOutOfBoundsException, NullPointerException;
	
	int size();
	
	Object[] toArray();
}
