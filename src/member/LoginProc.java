package member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/LoginProcServlet")
public class LoginProc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public LoginProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		String strId = request.getParameter("id");
		if(!strId.equals("")) 
			id = Integer.parseInt(strId);
		String password = request.getParameter("password");
		
		MemberDAO mDao = new MemberDAO();
		int result = mDao.verifyIdPAssword(id, password);
		String errorMessage = null;
		switch(result){
		case MemberDAO.ID_PASSWORD_MATCH:
			break;
		case MemberDAO.ID_DOES_NOT_EXIST:
			errorMessage = "ID 없음"; break;
		case MemberDAO.PASSWORD_IS_WRONG :
			errorMessage = "패스워드 틀림"; break;
		case MemberDAO.DATABASE_ERROR :
			errorMessage = "DB 오류";
		}
		mDao.close();
		
		
		System.out.println(errorMessage);
		if(result == MemberDAO.ID_PASSWORD_MATCH){
			response.sendRedirect("loginmain.jsp");
		} else {
			
			// 방법1 = 상대방이 getParameter("error")로 받을 때
			/*String uri = "login.jsp?error=" + errorMessage;
			RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
			dispatcher.forward(request, response);*/
			
			// 방법2 = 상대방이 getAttribute("error")로 받을 때
			/*request.setAttribute("error", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	        rd.forward(request, response);*/
	        
	        // 방법3
	        String uri = "login.jsp?error=" + URLEncoder.encode(errorMessage, "UTF-8");
	        response.sendRedirect(uri);
			
		}
	}

}
