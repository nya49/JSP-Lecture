package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BbsServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		BbsDAO bDao = null;
		BbsDTO bDto = null;
		String message = null;
		String title = null;
		String date = null;
		String content = null;
		String url = null;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int memberId = (Integer)session.getAttribute("memberId");
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		
		switch(action) {
		case "write" :
			title = request.getParameter("title");
			content = request.getParameter("content");
			bDto = new BbsDTO(memberId, title, content);
			bDao = new BbsDAO();
			bDao.insertBbs(bDto);
			bDao.close();
			response.sendRedirect("bbs_list.jsp");
			break;
			
		case "update" :
			if (!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			if(memberId != (Integer)session.getAttribute("memberId")) {
				message = "id=" + memberId + "에 대한 수정권한이 없습니다.";
				url = "bbs_list.jsp";
				request.setAttribute("message", message);
				request.setAttribute("url", url);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			}
			bDao = new BbsDAO();
			bDto = bDao.searchById(id);
			bDao.close();
			request.setAttribute("memberID", bDto);
			rd = request.getRequestDispatcher("bbsUpdate.jsp");
	        rd.forward(request, response);
			break;
			
		case "execute":
			if (!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			title = request.getParameter("title");
			date = request.getParameter("date");
			content = request.getParameter("content");
			
			bDto = new BbsDTO(id, id, title, date, content);
			
			bDao = new BbsDAO();
			bDao.updateBbs(bDto);
			bDao.close();
			
			message = "다음과 같이 수정하였습니다.\n" + bDto.toString();
			request.setAttribute("message", message);
			request.setAttribute("url", "bbs_list.jsp");
			rd = request.getRequestDispatcher("alertMsg.jsp");
	        rd.forward(request, response);
			break;
			
		case "delete" :			// 삭제버튼 클릭 시
			if(!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			if(memberId != (Integer)session.getAttribute("memberId")) {
				message = "memberId=" + memberId + "에 대한 삭제권한이 없습니다.";
				url = "bbs_list.jsp";
				request.setAttribute("message", message);
				request.setAttribute("url", url);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				response.sendRedirect("bbs_list.jsp");
				break;
			}
			bDao = new BbsDAO();
			bDao.deleteBbs(id);
			bDao.close();
			message = "id=" + id + " 가 삭제되었습니다.";
			url = "bbs_list.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			break;
		default:
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
