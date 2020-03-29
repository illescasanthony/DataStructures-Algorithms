
public class StackCharLL {

private NodeChar top = null;
	
	public void push(char x) 
	{
		top = new NodeChar(x,top);
		
		
	}
	
	public void pop()
	{
		top = top.next;
	}
	
	public char top()
	{
		return top.x;
	}
	
	public boolean isEmpty() {
		return top == null;
	}

}

