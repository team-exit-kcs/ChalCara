package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ExamDAO;
import model.data.Account;
import model.data.Exam;

/**
 * Servlet implementation class ExamDeleteServlet
 */
@WebServlet("/UpdExam/Delete")
public class ExamDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamDeleteServlet() {
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
			request.setAttribute("ExamDelete", exam);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamDeleteForm.jsp");
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		ExamDAO examDAO = new ExamDAO();
		
		Account user = (Account) session.getAttribute("LoginUser");
		String examID = request.getParameter("examID");
		
		Exam exam = null;
		if(examID != null) {
			exam = examDAO.findExamInfo(examID);
		}
		
		if(exam != null && exam.getUserID().equals(user.getUserID())) {
			String examName = request.getParameter("examName");
			String msg=null;
			boolean result = false;
			
			if(examName.equals(exam.getExamName())) {
				result=examDAO.deleteExam(exam);
				if(!result) {
					msg="エラーが発生しました。もう一度やり直してください。";
				}
			}else {
				msg="試験名を正しく入力してください";
			}
			
			if(result) {
				response.setContentType("text/html; charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<html>");
		        out.println("<p>削除が完了しました</p>");
		        out.println("<a href=\"/ExamPlatform/HomeServlet\">ホームに戻る</a>");
		        out.println("<a href=\"/ExamPlatform/MypageServlet\">マイページに戻る</a>");
		        out.println("</html>");
			}else {
				request.setAttribute("ExamDelete", exam);
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamDeleteForm.jsp");
				dispatcher.forward(request, response);
			}
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
		}
	}

}
