package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.unomaha.csci3320.datatypes.BasicStack;

public class BasicStackTest
{
	@Test
	public void testConstructor()
	{
		BasicStack stack = new BasicStack();
	}
	
	@Test
	public void testPushPeek()
	{
		BasicStack<Integer> stack = new BasicStack<Integer>();
		stack.push(1);
		assertTrue(1 == stack.peek());
	}
	
	@Test
	public void testAddPeek()
	{
		BasicStack<Integer> stack = new BasicStack<Integer>();
		stack.add(1);
		assertTrue(1 == stack.peek());
	}
	
	@Test
	public void testPop()
	{
		BasicStack<Integer> stack = new BasicStack<Integer>();
		stack.push(1);
		assertTrue(1 == stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testSize()
	{
		BasicStack<Integer> stack = new BasicStack<Integer>();
		stack.push(1);
		assertTrue(1 == stack.size());
		stack.pop();
		assertTrue(0 == stack.size());
	}
	
	@Test
	public void testToArray()
	{
		BasicStack<Integer> stack = new BasicStack<Integer>();
		stack.push(1);
		stack.push(2);
		Object[] arr = stack.toArray();
		System.out.println(arr[0] + " = " + stack.pop());
		System.out.println(arr[1] + " = " + stack.pop());
	}

}
