package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExamDAO;
import model.StsLogic;
import model.data.Account;
import model.data.Exam;
import model.data.ExamStats;

/**
 * Servlet implementation class ExamStatsServlet
 */
@WebServlet("/ExamStatsServlet")
public class ExamStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamStatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ExamDAO examDAO = new ExamDAO();
		
		Account user = (Account) session.getAttribute("LoginUser");
		String examID = request.getParameter("examID");
		
		Exam exam = null;
		if(examID != null) {
			exam = examDAO.findExamInfo(examID);
		}
		
		if(exam != null && exam.getUserID().equals(user.getUserID())) {
			StsLogic sl = new StsLogic();
			ExamStats sts = sl.execute(exam);
			
			session.removeAttribute("ExamSts");
			session.setAttribute("ExamSts", sts);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamSts.jsp");
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
