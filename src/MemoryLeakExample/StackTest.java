package MemoryLeakExample;
public class StackTest
{
	public static void main(String[] args)
	{
		Stack <Integer> s = new Stack<>(10000);
		for(int i=0; i < 10000; i++)
		{
			s.push(i);
		}
		System.out.println(s.isFull());
		while(!s.isEmpty())
		{
			s.pop();
		}
	}
}