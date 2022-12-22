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

import dao.AccountDAO;
import dao.ExamDAO;
import model.data.Exam;
import model.data.ExamListPage;

/**
 * Servlet implementation class MyExamListServlet
 */
@WebServlet("/ExamListServlet")
public class ExamListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountDAO aDAO = new AccountDAO();
		
		String userID = request.getParameter("userID");
		String Spage = request.getParameter("page");
		ExamListPage examListPage = (ExamListPage) session.getAttribute("examList");	
		
		if(userID != null && aDAO.isID(userID)) {
			int page = 1;
			if(Spage != null) {
				page = Integer.parseInt(Spage);
			}
			
			List<Exam> examList = null;
			if(examListPage != null && userID == examListPage.getUserID()) {
				examList = examListPage.getExamList();
			}else {
				ExamDAO examDAO = new ExamDAO();
				examList = examDAO.findUserExam(userID);
			}
			
			if(examList.isEmpty()) {
				request.setAttribute("msg", new String("試験はありません"));
			}
			
			ExamListPage newExamListPage = new ExamListPage(userID, page, examList);
			
			session.removeAttribute("examList");
			session.setAttribute("examList", newExamListPage);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamList.jsp");
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
