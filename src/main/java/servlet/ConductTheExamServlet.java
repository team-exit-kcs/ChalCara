package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.ExaminationPage;

/**
 * Servlet implementation class ConductTheExamServlet
 */
@WebServlet("/ConductTheExamServlet")
public class ConductTheExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConductTheExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ExaminationPage examinationPage = (ExaminationPage) session.getAttribute("pageData");
		
		if(examinationPage == null){
			response.sendRedirect("/ExamPlatform/ExaminationServlet");
		}else {
			//UseInfo取得しpageDataを更新　
			String useInfoCheck = request.getParameter("useInfo");
			boolean useInfo = false;
			if(useInfoCheck != null && useInfoCheck.equals("true")) {
				useInfo = true;
			}
			
			ExaminationPage newExaminationPage = new ExaminationPage(examinationPage.getExam(), examinationPage.getBigQuestionList(), examinationPage.isBookmark(), useInfo, examinationPage.isNotRedoExam());
			session.removeAttribute("pageData");
			session.setAttribute("pageData", newExaminationPage);
			
			if(examinationPage.getExam().getQuestionFormat()==0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamMondai.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamSMondai.jsp");
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
