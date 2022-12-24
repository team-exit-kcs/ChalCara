package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
import model.data.Account;
import model.data.BigQuestion;
import model.data.Choices;
import model.data.Exam;
import model.data.ExamUpdatePage;
import model.data.Question;

/**
 * Servlet implementation class UpdExamQuestion
 */
@WebServlet("/UpdExam/Question")
public class UpdExamQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdExamQuestion() {
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
	        
			if(exam.getQuestionFormat()==0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/BigexamUpdate.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/examUpdate.jsp");
				dispatcher.forward(request, response);
			}
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
			BigQuestionDAO bqd = new BigQuestionDAO();
			
			int[] arrayChoicesNum = Stream.of(request.getParameterValues("choicesNum")).mapToInt(Integer::parseInt).toArray();
			
			String[] arrayQuestion = request.getParameterValues("question");
			String[] arrayQuestionExplanation = request.getParameterValues("questionExplanation");
			double[] arrayScore = Stream.of(request.getParameterValues("Score")).mapToDouble(Double::parseDouble).toArray();
			String[] arrayChoices = request.getParameterValues("Select_text");
			
			int choicesCnt = 0;
			
			List<BigQuestion> bigQuestionList = new ArrayList<>();
			if(exam.getQuestionFormat()==0) {
				//　大問形式
				int bigQuestionNum = Integer.parseInt(request.getParameter("bigQuestionNum"));
				int[] arrayQuestionNum = Stream.of(request.getParameterValues("questionNum")).mapToInt(Integer::parseInt).toArray();
				
				String[] arrayBigQuestion = request.getParameterValues("Bquestion");
				
				int questionCnt = 0;
				for(int x = 0; x<bigQuestionNum; x++) {
					List<Question> questionList = new ArrayList<>();
					
					for(int y = 1; y<=arrayQuestionNum[x]; y++, questionCnt++) {
						List<Choices> choicesList = new ArrayList<>();
						
						for(int z = 1; z<=arrayChoicesNum[questionCnt]; z++, choicesCnt++) {
							choicesList.add(new Choices(examID,x+1,y,z,arrayChoices[choicesCnt]));
						}
						String q = arrayQuestion[questionCnt];
						int ans = Integer.parseInt(request.getParameter("Select_ans[問" + (x+1) + ".][＜設問" + (y) + "＞]"));
						String qe = arrayQuestionExplanation[questionCnt];
						double score = arrayScore[questionCnt];
						
						questionList.add(new Question(examID,x+1,y,q,ans,qe,score,choicesList));
					}
				String bq = arrayBigQuestion[x];
				bigQuestionList.add(new BigQuestion(examID,x+1,bq,questionList));
				}
				
			}else {
				// 小問形式
				int questionNum = Integer.parseInt(request.getParameter("questionNum"));
				
				List<Question> questionList = new ArrayList<>();
				for(int x = 0; x<questionNum; x++) {
					List<Choices> choicesList = new ArrayList<>();
					for(int y = 0; y<arrayChoicesNum[x]; y++,choicesCnt++) {
						choicesList.add(new Choices(examID,1,x+1,y+1,arrayChoices[choicesCnt]));
					}
					String q = arrayQuestion[x];
					int ans = Integer.parseInt(request.getParameter("Select_ans[小問][問" + (x+1) + ".]"));
					String qe = arrayQuestionExplanation[x];
					double score = arrayScore[x];
					
					questionList.add(new Question(examID,1,x+1,q,ans,qe,score,choicesList));
				}
				bigQuestionList.add(new BigQuestion(examID,1,null,questionList));
			}
			
			bqd.deleteQuestions(exam);
			bqd.setBigQuestion(bigQuestionList);
			examDAO.updDate(examID);
			
			request.setAttribute("updExamID", examID);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/updExamSuccess.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
		}
	}

}
