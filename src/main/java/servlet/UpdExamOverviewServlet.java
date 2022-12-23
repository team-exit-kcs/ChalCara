package servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BigQuestionDAO;
import dao.ExamDAO;
import dao.GenreDAO;
import dao.TagDAO;
import model.DisclosureRangeLogic;
import model.data.Account;
import model.data.EntryExam;
import model.data.Exam;
import model.data.ExamUpdatePage;

/**
 * Servlet implementation class UpdExamOverviewServlet
 */
@WebServlet("/UpdExam/Overview")
public class UpdExamOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdExamOverviewServlet() {
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
			GenreDAO gd = new GenreDAO();
			TagDAO td = new TagDAO();
			BigQuestionDAO bqd = new BigQuestionDAO();
			
			ExamUpdatePage updExam = new ExamUpdatePage(gd.findAll(),td.findAll(),exam,bqd.findBigQuestion(exam.getExamID()));
			
			session.removeAttribute("ExamUpdatePage");
			session.setAttribute("ExamUpdatePage", updExam);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamUpdateOverview.jsp");
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
		
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		Account user = (Account) session.getAttribute("LoginUser");
		String examID = request.getParameter("examID");
		
		Exam exam = null;
		if(examID != null) {
			exam = examDAO.findExamInfo(examID);
		}
		
		if(exam != null && exam.getUserID().equals(user.getUserID())) {
			int genreID = Integer.parseInt(request.getParameter("genre"));
			String examName = request.getParameter("examName");
			Date updateDate = new Date();
			int passingScore = Integer.parseInt(request.getParameter("passingScore"));
			int examTime = Integer.parseInt(request.getParameter("examTime"));;
			String examExplanation = request.getParameter("Explanation");
			int disclosureRange = Integer.parseInt(request.getParameter("OpenRange"));
			int questionFormat = Integer.parseInt(request.getParameter("QuestionFormat"));
			
			String[] arrayTag = request.getParameterValues("tag");
			List<String> examTagList = new ArrayList<>(Arrays.asList(arrayTag));
			
			String limitedPassword = null;
			if(DR.isLimited(disclosureRange)) {
				limitedPassword = request.getParameter("limitedPASS");
			}
			
			String useGameCheck = request.getParameter("useGame");
			boolean useGame = false;
			if(DR.isOpen(disclosureRange) && questionFormat == 1 && useGameCheck != null && useGameCheck.equals("true")) {
				useGame = true;
			}
			
			EntryExam updExam=null;
			try {
				updExam = new EntryExam(exam.getExamID(), exam.getUserID(), genreID, examName, exam.getCreateDate(), updateDate, passingScore, examTime,
						examExplanation, disclosureRange, examTagList, useGame, questionFormat, limitedPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			examDAO.updExam(updExam);
			
			request.setAttribute("msg", new String("更新が完了しました"));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamUpdateOverview.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
		}
	}

}
