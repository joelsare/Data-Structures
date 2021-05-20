package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.unomaha.csci3320.datatypes.BasicQueue;

public class BasicQueueTest
{
	@Test
	public void testConstructor()
	{
		BasicQueue queue = new BasicQueue();
	}
	
	@Test
	public void testEnqueuePeek()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.enqueue(1);
		assertTrue(1 == stack.peek());
	}
	
	@Test
	public void testAddPeek()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.add(1);
		assertTrue(1 == stack.peek());
	}
	
	@Test
	public void testDequeue()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.enqueue(1);
		assertTrue(1 == stack.dequeue());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testRemove()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.enqueue(1);
		assertTrue(1 == stack.remove());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testSize()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.enqueue(1);
		assertTrue(1 == stack.size());
		stack.dequeue();
		assertTrue(0 == stack.size());
	}
	
	@Test
	public void testToArray()
	{
		BasicQueue<Integer> stack = new BasicQueue<Integer>();
		stack.enqueue(1);
		stack.enqueue(2);
		Object[] arr = stack.toArray();
		System.out.println(arr[0] + " = " + stack.dequeue());
		System.out.println(arr[1] + " = " + stack.dequeue());
	}

}
