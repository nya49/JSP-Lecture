package jspbook.ch03;

public class CalcBean {
	private int num1, num2;
	private String operator = "";
	private int result;

	public void calculate() {
		switch (operator) {
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

	public void setOperator(String operator) {
		System.err.println("## " + operator);
		this.operator = operator;
	}

	// 사용자가 입력한 것을 받아 올 때는 string이기에 정수 처리해준다.
	public void setNum1(String num1) {
		this.num1 = Integer.parseInt(num1);
	}

	public int getResult() {
		return result;
	}

	public void setNum2(String num2) {
		this.num2 = Integer.parseInt(num2);
	}

}
