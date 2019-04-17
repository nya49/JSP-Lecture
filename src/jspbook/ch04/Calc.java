package jspbook.ch04;

public class Calc {
	int result = 0;

	public Calc(int num1, int num2, String op) {	
		
		switch (op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}		
	}

	public int getResult() {
		return result;
	}
}
