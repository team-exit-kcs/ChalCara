package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BookmarkLogic;
import model.data.Account;

/**
 * Servlet implementation class BookmarkServlet
 */
@WebServlet("/BookmarkServlet")
public class BookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookmarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookmarkLogic bookmarkLogic = new BookmarkLogic();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		String examID = request.getParameter("examID");
		Account user = (Account) session.getAttribute("LoginUser");
		boolean result = bookmarkLogic.exequte(examID,user.getUserID());
		
		if(result) {
			response.sendRedirect("/ExamPlatform/ExaminationServlet?examID=" + examID);
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
