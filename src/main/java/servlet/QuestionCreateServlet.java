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

import model.data.BigQuestion;
import model.data.Choices;
import model.data.ExamCreatePage;
import model.data.Question;

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
		
		ExamCreatePage examData = (ExamCreatePage) session.getAttribute("ExamCreatePage");
		String examID = examData.getEntryExam().getExamID();
		
		request.setCharacterEncoding("UTF-8");
		
		int questionNum = Integer.parseInt(request.getParameter("questionNum"));
		int[] arrayChoicesNum = Stream.of(request.getParameterValues("choicesNum")).mapToInt(Integer::parseInt).toArray();
		
		String[] arrayQuestion = request.getParameterValues("question");
		int[] arrayAnswer = Stream.of(request.getParameterValues("Select_ans")).mapToInt(Integer::parseInt).toArray();
		String[] arrayQuestionExplanation = request.getParameterValues("questionExplanation");
		double[] arrayScore = Stream.of(request.getParameterValues("Score")).mapToDouble(Double::parseDouble).toArray();
		String[] arrayChoices = request.getParameterValues("Select_text");
		
		int choicesCnt = 0;
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		List<Question> questionList = new ArrayList<>();
		for(int x = 0; x<questionNum; x++) {
			List<Choices> choicesList = new ArrayList<>();
			for(int y = 0; y<arrayChoicesNum[x]; y++,choicesCnt++) {
				choicesList.add(new Choices(examID,1,x+1,y+1,arrayChoices[choicesCnt]));
			}
			String q = arrayQuestion[x];
//			int ans = arrayAnswer[x];
			String qe = arrayQuestionExplanation[x];
			double score = arrayScore[x];
			
			questionList.add(new Question(examID,1,x+1,q,1,qe,score,choicesList));
		}
		bigQuestionList.add(new BigQuestion(examID,1,null,questionList));
		
		ExamCreatePage newExamData = new ExamCreatePage(examData, bigQuestionList);
		session.removeAttribute("ExamCreatePage");
		session.setAttribute("ExamCreatePage", newExamData);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/QuestionRegister.jsp");
		dispatcher.forward(request, response);
	}

}
