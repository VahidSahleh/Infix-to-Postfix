
// Java code for stack implementation
  
import java.io.*;
import java.util.*;

public class Stack1 {
	public ArrayList<Character> stack = new ArrayList<>();

    static String infixToPostfix(String input)
    {
        // initializing empty String for result
        String stack1 = new String("");
        // initializing empty stack
        Stack stack = new Stack();
        int i=0; 
        while (i<input.length())
        {
    
            if (Character.isLetterOrDigit(input.charAt(i)))
                stack1 =stack1+ input.charAt(i);
              
          
            else if (input.charAt(i) == '(')
                stack.push(input.charAt(i));
             
           
            else if (input.charAt(i) == ')')
            {
                for (int i1=0; i1<stack.size(); i1++) {
                	if(!stack.isEmpty() && (char)  stack.peek() != '(') {
                		 stack1 =stack1+ stack.pop();
                         
                         stack.pop();
                	}
                   
            }
                }
            else{
                while (!stack.isEmpty() && operator(input.charAt(i)) <= operator( (char)  stack.peek())){
                   
                    stack1 =stack1+ stack.pop();
             }
                stack.push(input.charAt(i));
            }
      i++;
        }
      
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if( (char)  stack.peek() == '(')
                return "Invalid Expression";
            stack1 =stack1+ stack.pop();
         }
        return stack1;
    }
   
    // Driver method
    public static void main(String[] args)
    {
    	Scanner in= new Scanner(System.in); 
		
		String exp= in.nextLine();
		exp = exp.replaceAll("\\s", "");
       // String exp = "(a+b)*(c+d)";
        System.out.println(infixToPostfix(exp));
    }
	static int operator(char ch) {
		if (ch == '+' || ch == '-') {
			return 1;
		} else if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '^') {
			return 3;
		} else if (ch == '$') {
			return 0;
		} else
			return -1;
	}
    public void push(char ch) {
		stack.add(ch);
	}

	public char pop() {
		return stack.remove(stack.size() - 1);
	}

	public char peek() {
		return stack.get(stack.size() - 1);
	}
}
