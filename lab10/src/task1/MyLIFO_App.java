package task1;

import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		// TODO
		Stack<E> st = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			st.add(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = st.pop();
		}
	}

	// This method checks the correctness of the
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		// TODO
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			// stack.push(input.charAt(i));
			switch (input.charAt(i)) {
			case ')': {
				if (stack.size() == 0)
					return false;
				if (stack.peek() != '(')
					return false;
				else {
					stack.pop();
					break;
				}
			}
			case ']': {
				if (stack.size() == 0)
					return false;
				if (stack.peek() != '[')
					return false;
				else {
					stack.pop();
					break;
				}
			}
			case '}': {
				if (stack.size() == 0)
					return false;
				if (stack.peek() != '{')
					return false;
				else {
					stack.pop();
					break;
				}
			}
			default: {
				stack.add(input.charAt(i));
			}
			}

		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (Character.isDigit(c)) {
				StringBuilder num = new StringBuilder();
				num.append(c);
				while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
					num.append(expression.charAt(++i));
				}
				operandStack.push(Integer.parseInt(num.toString()));
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (operatorStack.peek() != '(') {
					processOperation(operandStack, operatorStack);
				}
				operatorStack.pop(); // remove '('
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					processOperation(operandStack, operatorStack);
				}
				operatorStack.push(c);
			}
		}

		while (!operatorStack.isEmpty()) {
			processOperation(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	public static void processOperation(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int num2 = operandStack.pop();
		int num1 = operandStack.pop();
		switch (operator) {
		case '+':
			operandStack.push(num1 + num2);
			break;
		case '-':
			operandStack.push(num1 - num2);
			break;
		case '*':
			operandStack.push(num1 * num2);
			break;
		case '/':
			operandStack.push(num1 / num2);
			break;
		}
	}

	public static int precedence(char operator) {
		if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(isCorrect("{}[]"));
		System.out.println(isCorrect("){[]}()"));
		System.out.println(evaluateExpression("1+(6*7)"));
	}
}