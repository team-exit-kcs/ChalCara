package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DisclosureRangeLogic;
import model.ExaminationLogic;
import model.data.Account;
import model.data.ExaminationPage;

/**
 * Servlet implementation class ExaminationServlet
 */
@WebServlet("/ExaminationServlet")
public class ExaminationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExaminationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		ExaminationLogic examLogic = new ExaminationLogic();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		String examID = request.getParameter("examID");
		Account user = (Account) session.getAttribute("LoginUser");
		ExaminationPage pageData = examLogic.exequte(examID,user);
		
		if(pageData == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
			
		}else {
			session.removeAttribute("pageData");
			session.setAttribute("pageData", pageData);
			
			if(DR.isLimited(pageData.getExam().getDisclosureRange()) && (user == null || !(pageData.getExam().getUserID().equals(user.getUserID())))) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/limitedExamForm.jsp");
				dispatcher.forward(request, response);
				
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamGaiyou.jsp");
				dispatcher.forward(request, response);
			}
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
