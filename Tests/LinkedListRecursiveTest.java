package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.unomaha.csci3320.datatypes.LinkedListRecursive;

public class LinkedListRecursiveTest
{

	@Test
	public void testConstructor()
	{
		LinkedListRecursive list = new LinkedListRecursive();
	}
	
	@Test
	public void testAdd()
	{
		LinkedListRecursive<Integer> list = new LinkedListRecursive<Integer>();
		list.add(1);
		assertTrue(1 == list.get(0));
	}
	
	@Test
	public void testAddIndex()
	{
		LinkedListRecursive<Integer> list = new LinkedListRecursive<Integer>();
		list.add(1);
		list.add(9);
		list.add(1, 5);
		assertTrue(5 == list.get(1));
	}
	
	@Test
	public void testSet()
	{
		LinkedListRecursive<Integer> list = new LinkedListRecursive<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.set(3, 2);
		assertTrue(2 == list.get(3));
		assertTrue(3 == list.indexOf(2));
		assertTrue(list.contains(2));
	}
	
	@Test
	public void testRemove()
	{
		LinkedListRecursive<Integer> list = new LinkedListRecursive<Integer>();
		list.add(1);
		list.add(9);
		list.add(9);
		list.add(9);
		list.add(9);
		list.remove(0);
		assertTrue(9 == list.get(0));
	}

}
