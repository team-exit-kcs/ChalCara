package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.Account;
import model.data.ExamCreatePage;

/**
 * Servlet implementation class QuestionCreateServlet
 */
@WebServlet("/ExamCreateServlet/Question")
public class QuestionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ExamCreatePage examData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
		
		if(examData == null) {
			response.sendRedirect("/ExamPlatform/ExamCreateServlet");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/QuestionRegister.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("LoginUser");
		ExamCreatePage examData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
		String userID = account.getUserID();
		String examID = examData.getEntryExam().getExamID();
		
		request.setCharacterEncoding("UTF-8");
		
		
	}

}
