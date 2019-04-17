package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet2")
public class CalcServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get 요청을 처리하기 위한 메서드
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// depost()로 포워딩
			doPost(request, response);
		}

		// post요청을 처리하기 위한 메서드
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int num1, num2;
			int result;
			String op;
			
			//클라이언트 응답시 전달될 컨텐트에 대한 캐릿터셋 지정
			response.setContentType("text/html; charset=UTF-8");
			
			// 클라이언트 응답 위한 출력 스트림 확보
			PrintWriter out = response.getWriter();
			
			//getparameter은 문자열을 받음
			num1 = Integer.parseInt(request.getParameter("num1"));
			num2 = Integer.parseInt(request.getParameter("num2"));
			op = request.getParameter("operator");
			
			Calc calc = new Calc(num1, num2, op);
			result = calc.getResult();

			out.println("<html>");
			out.println("<head><title>계산기</title></head>");
			out.println("<body><center>");
			out.println("<h2>계산 결과</h2><hr>");
			out.println(num1 + " " + op + " " + num2 + " = " + result);
			out.println("</body></html>");
		}

}
