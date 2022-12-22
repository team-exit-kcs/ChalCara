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

import dao.GenreDAO;
import dao.TagDAO;
import model.DisclosureRangeLogic;
import model.data.Account;
import model.data.EntryExam;
import model.data.ExamCreatePage;

/**
 * Servlet implementation class ExamCreateServlet
 */
@WebServlet("/ExamCreateServlet")
public class ExamCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenreDAO genreDAO = new GenreDAO();
		TagDAO tagDAO = new TagDAO();
		
		HttpSession session = request.getSession();
		
		ExamCreatePage examData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
		if(examData == null) {
			session.setAttribute("ExamCreatePage", new ExamCreatePage(genreDAO.findAll(), tagDAO.findAll() ));
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamOverview.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		Account account = (Account) session.getAttribute("LoginUser");
		ExamCreatePage examData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
		
		request.setCharacterEncoding("UTF-8");
		
		String userID = account.getUserID();
		int genreID = Integer.parseInt(request.getParameter("genre"));
		String examName = request.getParameter("examName");
		Date createDate = new Date();
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
		
		EntryExam entry=null;
		try {
			entry = new EntryExam(userID, genreID, examName, createDate, updateDate, passingScore, examTime,
					examExplanation, disclosureRange, examTagList, useGame, questionFormat, limitedPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		ExamCreatePage newExamData = new ExamCreatePage(examData, entry);
		session.removeAttribute("ExamCreatePage");
		session.setAttribute("ExamCreatePage", newExamData);
		
		if(questionFormat == 0) {
			response.sendRedirect("/ExamPlatform/ExamCreateServlet/BigQuestion");
		}else {
			response.sendRedirect("/ExamPlatform/ExamCreateServlet/Question");
		}
	}

}
