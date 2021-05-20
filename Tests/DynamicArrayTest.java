package Tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.unomaha.csci3320.datatypes.DynamicArray;
import edu.unomaha.csci3320.interfaces.Sequence;


public class DynamicArrayTest
{	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAdd()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
	}
	
	@Test
	public void testGet()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		assertTrue(1 == list.get(0));
	}
	
	@Test
	public void testExpand()
	{
		DynamicArray<Integer> list = new DynamicArray<Integer>();
		for (int i = 0; i < 9; i++)
		{
			list.add(i);
		}
		assertTrue(0 == list.get(0));
		assertTrue(8 == list.get(8));
	}
	
	@Test
	public void testBadGet()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		
		thrown.expect(IndexOutOfBoundsException.class);
		list.get(1);
	}

	@Test
	public void testSet()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		assertTrue(1 == list.get(0));
		list.set(0, 10);
		assertTrue(10 == list.get(0));
		assertTrue(1 == list.size());
	}
	
	@Test
	public void testClear()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		assertTrue(1 == list.size());
		list.clear();
		assertTrue(0 == list.size());
		assertTrue(list.isEmpty());
		thrown.expect(IndexOutOfBoundsException.class);
		list.get(0);
	}
	
	@Test
	public void testAddIndex()
	{
		Sequence<Character> list = new DynamicArray<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add(1, 'd');
		assertTrue('a' == list.get(0));
		assertTrue('d' == list.get(1));
		assertTrue('b' == list.get(2));
		assertTrue('c' == list.get(3));
	}
	
	@Test
	public void testIndexOf()
	{
		Sequence<Character> list = new DynamicArray<Character>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add(1, 'd');
		assertTrue(2 == list.indexOf('b'));
		assertTrue(0 == list.indexOf('a'));
		assertTrue(1 == list.indexOf('d'));
		assertTrue(3 == list.indexOf('c'));
		assertTrue(-1 == list.indexOf('z'));
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testContains()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		assertTrue(list.contains(1));
		assertFalse(list.contains(10));
	}
	
	@Test
	public void testtoArray()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		Object[] a = list.toArray();
		assertTrue(1 == (Integer) a[0]);
		assertTrue(1 ==  a.length);
		assertTrue(1 == list.get(0));
		a[0] = 10;
		assertTrue(1 == list.get(0));
		assertTrue(10 == (Integer) a[0]);
	}
	
	@Test
	public void testtoString()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		assertEquals("[1]", list.toString());
		list.add(2);
		assertEquals("[1, 2]", list.toString());
	}
	
	@Test
	public void testRemoveIndex()
	{
		Sequence<Integer> list = new DynamicArray<Integer>();
		list.add(1);
		list.add(2);
		assertTrue(1 == list.remove(0));
		assertTrue(1 == list.size());
		assertTrue(2 == list.get(0));
	}
	
	@Test
	public void testRemoveObject()
	{
		Sequence<String> list = new DynamicArray<String>();
		list.add("H");
		list.add("t");
		list.add("i");
		list.add("k");
		list.add("e");
		assertTrue(list.remove("H"));
		assertTrue("t".equals(list.get(0)));
		assertTrue(4 == list.size());
		assertFalse(list.remove("Z"));
	}
	
	@Test
	public void testReverse()
	{
		DynamicArray<String> list = new DynamicArray<String>();
		list.add("H");
		list.add("t");
		list.add("i");
		list.add("k");
		list.add("e");
		Sequence<String> reverse = list.reverse(list);
		assertTrue("e".equals(reverse.get(0)));
		assertTrue("k".equals(reverse.get(1)));
		assertTrue("i".equals(reverse.get(2)));
		assertTrue("t".equals(reverse.get(3)));
		assertTrue("H".equals(reverse.get(4))); 
	}
}
