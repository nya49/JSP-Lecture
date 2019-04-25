package member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TweetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String msg = request.getParameter("msg");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("memberName");
		ServletContext application = request.getServletContext();
		
		ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");
		
		if(msgs == null) {
			msgs = new ArrayList<String>();
			// application 에 ArrayList 저장
			application.setAttribute("msgs",msgs);
		}
		
		// 사용자 이름, 메시지, 날짜 정보를 포함하여 ArrayList에 추가
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM월 dd일(E) HH:mm", Locale.KOREA);
		msgs.add(username+" :: "+msg+" , "+ f.format(date));
		
		// 톰캣 콘솔을 통한 로깅
		application.log(msg + ", " + username);
		
		// 목록 화면으로 리다이렉팅
		response.sendRedirect("twitter_list.jsp");
	}

}
