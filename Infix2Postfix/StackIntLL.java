
public class StackIntLL 
{
	private NodeInt top = null;
	
	public void push(int x) 
	{
		top = new NodeInt(x,top);
		
		
	}
	
	public void pop()
	{
		top = top.next;
	}
	
	public int top()
	{
		return top.x;
	}
	

	
	public boolean isEmpty() {
		return top == null;
	}

}
