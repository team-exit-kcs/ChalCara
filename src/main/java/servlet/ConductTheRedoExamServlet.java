package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RedoExamLogic;
import model.data.CheckAnsPage;
import model.data.ExaminationPage;

/**
 * Servlet implementation class ConductTheExamServlet
 */
@WebServlet("/ConductTheExamServlet/redo")
public class ConductTheRedoExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConductTheRedoExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RedoExamLogic rel =new RedoExamLogic();
		
		HttpSession session = request.getSession();
		CheckAnsPage CheckAnsP = (CheckAnsPage) session.getAttribute("checkAnsPage");
		ExaminationPage examinationPage = (ExaminationPage) session.getAttribute("pageData");
		
		ExaminationPage pageData = rel.exequte(examinationPage, CheckAnsP);
		
		if(pageData == null){
			response.sendRedirect("/ExamPlatform/ExaminationServlet");
		}else {
			session.removeAttribute("pageData");
			session.setAttribute("pageData", pageData);
			
			if(pageData.getQuestionFormat()==0) {
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
