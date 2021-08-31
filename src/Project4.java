import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class Project4 {
	public ArrayList<Character> stack = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ArrayList<Character> a = new ArrayList<>();
		// result of infix to postFix is in this string
		String stack1 = "";
		Stack stack2 = new Stack();
		// Stack stack3 = new Stack();
		Scanner in = new Scanner(System.in);

		String inn = in.nextLine();

		String input2 = inn;
		//put chars of input string into arrayList a
		for (int j = 0; j < input2.length(); j++) {

			a.add(input2.charAt(j));
		}
		String input = "";
		//get all chars from a arrayList and make a string from it
		for (int j = 0; j < a.size(); j++) {
			input = input + a.get(j);

		}

		int i = 0;
		while (i < input.length()) {
			// if charAt(i) is equal to letter or digit we put the char in stack1( result )
			if (Character.isLetterOrDigit(input.charAt(i))) {

				stack1 = stack1 + input.charAt(i);
			} else {
				// if char is operator and our stack is empty or char is equal to '(' push the char
				// in stack2
				if (stack2.empty() || input.charAt(i) == '(') {

					stack2.push(input.charAt(i));
					// if charAt(i) is equal to ')' we will pop all the chars in stack2 and put it to
					// stack1(result) until we see (
				} else if (input.charAt(i) == ')') {
					while (!stack2.isEmpty() && (char) stack2.peek() != '(') {
						stack1 = stack1 + stack2.pop();
						// stack2.pop();

					}

					stack2.pop();
				}
				// if our operator is bigger than operator in top of stack2 we push the operator
				// (charAt(i))
				else if (operator(input.charAt(i)) > operator((char) stack2.peek())) {

					stack2.push(input.charAt(i));
					// if our operator is not bigger than operator in top of stack2 we pop from
					// stack2 and put it in operator string
					// we get last 2 char form stack1 string and put them in op1 and op2 and then we
					// remove that 2chars from stack1
					// at the end we put op1 then op2 and operator in stack1
				} else {
					if (isOperator((char) stack2.peek())) {

						char operator = (char) stack2.pop();
						String sss = "";

						char opr2 = stack1.charAt(stack1.length() - 1);
						stack1 = stack1.substring(0, stack1.length() - 1);
						char opr1 = stack1.charAt(stack1.length() - 1);
						stack1 = stack1.substring(0, stack1.length() - 1);
						stack1 = stack1 + opr1;

						stack1 = stack1 + opr2;
						stack1 = stack1 + operator;

						if (input.charAt(i) != '$') {
							i--;

						}

					} else {

						char operator = (char) stack2.pop();
						char opr1 = stack1.charAt(stack1.length() - 1);
						stack1 = stack1.substring(0, stack1.length() - 1);
						stack1 = stack1 + opr1;
						stack1 = stack1 + opr1;
						stack1 = stack1 + operator;

					}
				}

			}
			i++;
		}
	//for print the result of infix to postFix
		while (!stack2.isEmpty()) {
			if ((char) stack2.peek() == '(') {
				System.out.print("");
				stack2.pop();
			}
			if (!stack2.isEmpty()) {
				System.out.print("");
				stack1 = stack1 + stack2.pop();
			}
		}

		System.out.print(stack1);
	}

//method for give value to operators
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

	static boolean isOperand(char ch) {
		if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^' || ch == '$') {
			return false;

		} else
			return true;

	}

//method to find out that our char is operand or operator
	static boolean isOperator(char ch) {
		if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^' || ch == '$') {
			return true;

		} else
			return false;

	}

//methods for making stack
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
