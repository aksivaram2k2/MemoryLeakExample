//http://coderevisited.com/memory-leaks-in-java/
package MemoryLeakExample;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

public class Stack<E> implements Iterable<E>
{
	private int N;
	private E[] array;
	
	public Stack(int capacity)
	{
		array = (E[])new Object[capacity];
	}
	
	public Iterator<E> iterator()
	{
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<E>
	{
		private int i = N-1;
		
		public boolean hasNext()
		{
			return i>=0;
		}
		
		public E next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			return array[i--];
		}
		
		public void remove()
		{
			throw new UnsupportedAddressTypeException();
		}
	}
	
	public void push(E item)
	{
		if(isFull())
		{
			throw new RuntimeException("Stack Overflow");
		}
		array[N++] = item;
	}
	
	public E pop()
	{
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		E item = array[--N];
		System.out.println(item);
		return item;
	}
	
	public boolean isEmpty()
	{
		return N==0;
	}
	
	public boolean isFull()
	{
		return N == array.length;
	}
	
	public E peek()
	{
		if(isEmpty())
			throw new RuntimeException("Stack Underflow");
		return array[N-1];
	}
}