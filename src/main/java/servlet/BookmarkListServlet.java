package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookmarkDAO;
import model.data.Account;
import model.data.BookmarkListPage;
import model.data.Exam;

/**
 * Servlet implementation class MyExamListServlet
 */
@WebServlet("/Mypage/BookmarkListServlet")
public class BookmarkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookmarkListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account user = (Account) session.getAttribute("LoginUser");
		String Spage = request.getParameter("page");
		BookmarkListPage bookmarkListPage = (BookmarkListPage) session.getAttribute("bookmarkList");	
		
		if(user != null) {
			int page = 1;
			if(Spage != null) {
				page = Integer.parseInt(Spage);
			}
			
			List<Exam> bookmarkList = null;
			if(bookmarkListPage != null) {
				bookmarkList = bookmarkListPage.getBookmarkList();
			}else {
				BookmarkDAO bd = new BookmarkDAO();
				bookmarkList = bd.findBookmark(user.getUserID()).getExamList();
			}
			
			if(bookmarkList.isEmpty()) {
				request.setAttribute("msg", new String("ブックマークした試験はありません"));
			}
			
			BookmarkListPage newBookmarkListPage = new BookmarkListPage(page, bookmarkList);
			
			session.removeAttribute("bookmarkList");
			session.setAttribute("bookmarkList", newBookmarkListPage);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/bookmarkList.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
