package Tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.unomaha.csci3320.datatypes.LinkedList;

public class LinkedListTest
{	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAdd()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		assertTrue(1 == list.get(0));
		assertTrue(2 == list.get(1));
	}
	
	@Test
	public void testAddIndex()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(0,8);
		list.add(3,7);
		list.add(2,6);
		assertTrue(1 == list.get(1));
		assertTrue(6 == list.get(2));
		assertTrue(7 == list.get(4));
	}
	
	@Test
	public void testClear()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(0,8);
		list.add(3,7);
		list.add(2,6);
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testGet()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		
		assertTrue(1 == list.get(0));
	}
	
	@Test
	public void testIndexOfB()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(4);
		
		assertTrue(3 == list.indexOf(4));
	}
	
	@Test
	public void testContains()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		assertTrue(list.contains(1));
		assertFalse(list.contains(0));
	}
	
	@Test
	public void testIndexOf()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		assertTrue(0 == list.indexOf(1));
	}
	
	@Test
	public void testIsEmpty()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertTrue(list.isEmpty());
		list.add(1);
		list.add(2);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testToArray()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		Object[] arr = list.toArray();
		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
	}
	
	@Test
	public void testtoString()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertTrue(list.isEmpty());
		list.add(1);
		list.add(2);
		assertEquals("[1, 2]", list.toString());
	}
	
	@Test
	public void testRemove()
	{
		LinkedList<Character> list = new LinkedList<Character>();
		list.add('1');
		list.add('2');
		list.add('2'); 
		list.add('4');
		list.remove(0);
		
		assertTrue('2' == list.get(0));
		assertTrue('2' == list.get(1));
		assertTrue('4' == list.get(2));
	}
	
	@Test
	public void testRemoveT()
	{
		LinkedList<Character> list = new LinkedList<Character>();
		list.add('1');
		list.add('2');
		list.add('2'); 
		list.add('4');
		Character c = '2';
		assertTrue(list.remove(c));
		
		assertTrue('1' == list.get(0));
		assertTrue('2' == list.get(1));
		assertTrue('4' == list.get(2));
		
		assertTrue(list.remove(c));
		assertFalse(list.remove(c));
		
		assertTrue('1' == list.get(0));
		assertTrue('4' == list.get(1));
	}
	
	@Test
	public void testtoStringEmpty()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals("[]", list.toString());
	}
	
	@Test
	public void testSet()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(0);
		assertTrue(0 == list.get(0));
		list.set(0, 1);
		assertTrue(1 == list.get(0));
		assertTrue(1 == list.size());
	}
	
	@Test
	public void testaddBadIndex()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		thrown.expect(IndexOutOfBoundsException.class);
		list.add(1,0);
		list.add(-1,0);
		list.add(2,0);
		list.add(-2,0);
	}
}
