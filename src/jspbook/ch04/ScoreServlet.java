package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "score 서블릿", urlPatterns = { "/ScoreServlet" })
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ScoreServlet() {
        super(); 
    }
    
 // GET 요청을 처리하기 위한 메서드
 	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// doPost()로 포워딩.
 		doPost(request, response);
 	}
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수 선언
		int kor,eng,math;
		int sum;
		double avg;

		// 클라이언트 응답시 전달될 컨텐트에 대한 타잎 설정과 캐릿터셋 지정
		response.setContentType("text/html; charset=UTF-8");

		//클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		
		kor = Integer.parseInt(request.getParameter("kor"));
		eng = Integer.parseInt(request.getParameter("eng"));
		math = Integer.parseInt(request.getParameter("math"));
		sum = sum(kor, eng, math);
		avg = (double) sum / 3;

		// 출력 스트림을 통해 화면을 구성 한다.
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Score</TITLE></HEAD>");
		out.println("<BODY><center>");
		out.println("<H2>결과</H2>");
		out.println("<HR>");
		out.println("<p>국어 : " + kor + "</p>");
		out.println("<p>영어 : " + eng + "</p>");
		out.println("<p>수학 : " + math + "</p>");
		out.println("<HR>");
		out.println("<h4>합계 : " + sum + "</h4>");
		out.println("<h4>평균 : " + avg + "</h4>");
		out.println("</BODY></HTML>");
	}

	//실제 계산 기능을 수행하는 메서드
	public int sum(int kor, int eng, int math) {
		return kor + eng + math;		
	}

}
