package servlet;

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

import model.CreateReportLogic;
import model.data.Account;
import model.data.BigQuestion;
import model.data.CheckAns;
import model.data.CheckAnsPage;
import model.data.ExaminationPage;
import model.data.Question;
import model.data.Report;

/**
 * Servlet implementation class CheckAnsServlet
 */
@WebServlet("/CheckAnsServlet")
public class CheckAnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreateReportLogic crl = new CreateReportLogic();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		ExaminationPage pageData = (ExaminationPage) session.getAttribute("pageData");
		Account user = (Account) session.getAttribute("LoginUser");
		
		if(pageData == null) {
			request.setAttribute("msg", new String("受験情報が見つかりませんでした"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}else {
			List<BigQuestion> bigQuestionList = pageData.getBigQuestionList();
			List<CheckAns> checkAnsList = new ArrayList<>();;
			double score = 0;
			
			for(BigQuestion bq : bigQuestionList) {
				for(Question q : bq.getQuestionList()) {
					boolean tf = false;
					
					String strAns = request.getParameter(q.getBigQuestionID() + "-" + q.getQuestionID());
					int userAns = 0;
					if(strAns != null) {
						userAns = Integer.parseInt(strAns);
						if(userAns == q.getAnswer()) {
							tf = true;
							score += q.getAllocationOfPoint();
						}
					}
					
					checkAnsList.add(new CheckAns(q.getBigQuestionID(), q.getQuestionID(), q.getQuestionSentence(), q.getAnswer(), userAns, tf, q.getQuestionExplanation(), q.getAllocationOfPoint(), q.getChoicesList()));
				}
			}
			CheckAnsPage checkAnsPage = new CheckAnsPage(pageData.getExam().getExamID(), (int)score, checkAnsList);
			
			Report report = crl.execute(checkAnsPage, pageData.getExam() , user);
			
			session.removeAttribute("checkAnsPage");
			session.setAttribute("checkAnsPage", checkAnsPage);
			
			session.removeAttribute("report");
			session.setAttribute("report", report);
			
			response.sendRedirect("/ExamPlatform/ReportServlet");
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
