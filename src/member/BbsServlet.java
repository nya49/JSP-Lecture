package member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/member/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(BbsServlet.class);

       
    public BbsServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.trace("");
		int id = 0;
		BbsDAO bDao = null;
		BbsDTO bDto = null;
		BbsMember bMem = null;
		String message = null;
		String title = null;
		String date = null;
		String content = null;
		String url = null;
		int curPage = 1;
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = null;
		int memberId = 0;
		HttpSession session = request.getSession();
		// 세션이 만료되었으면 다시 로그인하게 만들어 줌
			try {
				memberId = (int)session.getAttribute("memberId");
			} catch (NullPointerException e) {
				System.out.println("세션이 만료되었습니다.");
			}
			if (memberId == 0) {
				rd = request.getRequestDispatcher("login.jsp");
		        rd.forward(request, response);
			}
		String action = request.getParameter("action");
		List<String> pageList = new ArrayList<String>();
		
		switch(action) {
		case "list":
			if (!request.getParameter("page").equals("")) {
				curPage = Integer.parseInt(request.getParameter("page"));
			}
			bDao = new BbsDAO();
			int count = bDao.getCount();
			if (count == 0)			// 데이터가 없을 때 대비
				count = 1;
			int pageNo = (int)Math.ceil(count/10.0);
			if (curPage > pageNo)	// 경계선에 걸렸을 때 대비
				curPage--;
			session.setAttribute("currentBbsPage", curPage);
			// 리스트 페이지의 하단 페이지 데이터 만들어 주기
			String page = null;
			page = "<a href=#>&laquo;</a>&nbsp;";
			pageList.add(page);
			for (int i=1; i<=pageNo; i++) {
				page = "&nbsp;<a href=BbsServlet?action=list&page=" + i + ">" + i + "</a>&nbsp;";
				pageList.add(page);
			}
			page = "&nbsp;<a href=#>&raquo;</a>";
			pageList.add(page);
			
			List<BbsMember> bmList = bDao.selectJoinAll(curPage);
			request.setAttribute("bbsMemberList", bmList);
			request.setAttribute("pageList", pageList);
			rd = request.getRequestDispatcher("bbs_list.jsp");
	        rd.forward(request, response);
	        break;
			
		case "write" :
			title = request.getParameter("title");
			content = request.getParameter("content").replaceAll("\r\n","<br>");
			bDto = new BbsDTO(memberId, title, content);
			bDao = new BbsDAO();
			bDao.insertBbs(bDto);
			bDao.close();
			response.sendRedirect("BbsServlet?action=list&page=1");
			break;
			
		case "view" :
			if (!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			bDao = new BbsDAO();
			bDto = bDao.searchById(id);
			bMem = bDao.ViewData(id);
			bDao.close();
			request.setAttribute("bbsMember", bMem);
			request.setAttribute("memberID", bDto);
			rd = request.getRequestDispatcher("bbsView.jsp");
	        rd.forward(request, response);
			break;
			
		case "update" :
			if (!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			bDao = new BbsDAO();
			bDto = bDao.searchById(id);
			if(memberId != bDto.getMemberid()) {
				message = "글번호" + id + "에 대한 수정권한이 없습니다.";
				url = "BbsServlet?action=list&page=1";
				request.setAttribute("message", message);
				request.setAttribute("url", url);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				bDao.close();
				break;
			}
			
			bDto.setContent(bDto.getContent().replaceAll("<br>", "\r\n"));
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
			content = request.getParameter("content").replaceAll("\r\n","<br>");
			
			bDto = new BbsDTO(id, id, title, date, content);
			
			bDao = new BbsDAO();
			bDao.updateBbs(bDto);
			bDao.close();
			
			//message = "다음과 같이 수정하였습니다.\n" + bDto.toString();
			//request.setAttribute("message", message);
			response.sendRedirect("BbsServlet?action=list&page=1");
			//request.setAttribute("url", "bbs_list.jsp");
			//rd = request.getRequestDispatcher("alertMsg.jsp");
	        //rd.forward(request, response);
			break;
			
		case "delete" :			// 삭제버튼 클릭 시
			if(!request.getParameter("id").equals("")) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			bDao = new BbsDAO();
			bDto = bDao.searchById(id);
			bDao.close();
			if(memberId != bDto.getMemberid()) {
				message = "글번호=" + id + "에 대한 삭제권한이 없습니다.";
				url = "BbsServlet?action=list&page=1";
				request.setAttribute("message", message);
				request.setAttribute("url", url);
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				response.sendRedirect("BbsServlet?action=list&page=1");
				break;
			}
			bDao = new BbsDAO();
			bDao.deleteBbs(id);
			bDao.close();
			message = "id=" + id + " 가 삭제되었습니다.";
			url = "BbsServlet?action=list&page=1";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			break;
		default:
		}
		
	}
}
