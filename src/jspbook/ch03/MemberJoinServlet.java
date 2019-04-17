package jspbook.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "member 서블릿", urlPatterns = { "/MemberJoinServlet" })
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //입력받은거 한글 꼭 처리!
		String name, email, tel;
		int id;
		// 클라이언트 응답시 전달될 컨텐트에 대한 타잎 설정과 캐릿터셋 지정
		response.setContentType("text/html; charset=UTF-8");

		//클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		name = request.getParameter("name");
		email = request.getParameter("email");
		tel = request.getParameter("tel");
		
		Member member = new Member(name, email, tel);
		id = member.getId();
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>회원가입 결과</TITLE></HEAD>");
		out.println("<BODY><center>");
		out.println("<H2>회원가입 결과</H2>");
		out.println("<HR>");
		out.println("<p>이름 : " + name + "</p>");
		out.println("<p>이메일 : " + email + "</p>");
		out.println("<p>전화번호 : " + tel + "</p>");
		out.println("<HR>");
		out.println("<h4>회원가입을 축하드립니다!</h4>");		
		out.println("<h4>회원 아이디 : " + id + "</h4>");		
		out.println("</BODY></HTML>");
		
		
	}

}
