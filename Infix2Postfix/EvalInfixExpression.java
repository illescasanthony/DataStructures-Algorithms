
public class EvalInfixExpression
{
	public static void main(String [] args)
	{
		String infix = "2+3*4";
		String postfix = infix2Postfix(infix);
		
		int result = evalPostfix(postfix);
		
		System.out.print(infix + " = " + postfix + " = " + result);
	}
	
	
	public static String infix2Postfix(String infix){
		StackCharLL stack = new StackCharLL();
		
		
		String postfix = "";
			for(int i = 0; i < infix.length(); i ++) {
				
			char c = infix.charAt(i);
			
			if(isOperator(c)) 
			{
				while((!stack.isEmpty()) && (precidence(stack.top()) >= precidence(c)))
				{
					postfix += stack.top();   
					stack.pop();
					
				}
				
				
				
				stack.push(c);
				
			}
			
			
			
			else
			if(c == '(')
			{
				stack.push(c);
			}
			else
			if(c == ')')
			{
				while(stack.top() != '(')
				{
					postfix += stack.top();   stack.pop();
				}
				stack.pop();

	

			}
			
			
			else
			{
			postfix += c;
			}	
			
	}
			while(!stack.isEmpty())
			{
				postfix += stack.top();   stack.pop();
			}
			return postfix;
}
	
	
	
	public static  int evalPostfix(String postfix)
	{
	//	StackInt stack = new StackInt(postfix.length()/2+1); // to account that the number of operands(1 more) compared to operators
		StackIntLL stack = new StackIntLL();
		for(int i = 0; i < postfix.length(); i++)
		{
			char c = postfix.charAt(i);
			
			if(isOperator(c))
			{
				int b = stack.top();  stack.pop();
				int a = stack.top();  stack.pop();
				
				if(c == '^')   stack.push(power(a,b));
				if(c == '*')   stack.push(a*b);
				if(c == '/')   stack.push(a/b);
				if(c == '+')   stack.push(a+b);
				if(c == '-')   stack.push(a-b);	
			}
			// if c is an Operand
				else
				{
					stack.push(postfix.charAt(i)- '0');
				}
		}
		return stack.top();
	}
	
	public static  boolean isOperator(char c)
	{
		return (c == '*')||
			   (c == '/')||
			   (c == '+')||
			   (c == '-')||
			   (c == '^')||
			   (c == '+');
	}
	
	public static int power(int base, int exp)
	{
		int product = 1;
		for(int i = 0; i < exp; i++)
			
			product *= base; 
		return product;
	}
	
	public static  int precidence(int op)
	{
		if (op == '^') return 3;
		if (op == '*') return 2;
		if (op == '/') return 2;
		if (op == '+') return 1;
		if (op == '-') return 1;
		
		return 0;
		
	}
}