package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/MemberProcServlet")
public class MemberProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = null;
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		String strId = request.getParameter("id");
		System.out.println(action + ", " + strId);
		
		switch(action) {
		case "update" :			// 수정버튼 클릭 시
			mDao = new MemberDAO();
			MemberDTO member = mDao.selectMod(Integer.parseInt(strId));
			mDao.close();
			request.setAttribute("member", member);
			rd = request.getRequestDispatcher("update.jsp");
	        rd.forward(request, response);
	        mDao.close();
	        break;
		case "delete" :			// 삭제버튼 클릭 시
			mDao = new MemberDAO();
			mDao.deleteMember(Integer.parseInt(strId));
			mDao.close();
			String message = "id=" + strId + " 가 삭제되었습니다.";
			String url = "loginmain.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			//response.sendRedirect("loginmain.jsp");		// 경고창이 안뜸
			break;
		default:
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
