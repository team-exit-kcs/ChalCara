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
 * Servlet implementation class BigQuestionCreateServlet
 */
@WebServlet("/ExamCreateServlet/BigQuestion")
public class BigQuestionCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BigQuestionCreateServlet() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/BigQuestionRegister.jsp");
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
		
		int bigQuestionNum = Integer.parseInt(request.getParameter("bigQuestionNum"));
		int[] arrayQuestionNum = Stream.of(request.getParameterValues("questionNum")).mapToInt(Integer::parseInt).toArray();
		int[] arrayChoicesNum = Stream.of(request.getParameterValues("choicesNum")).mapToInt(Integer::parseInt).toArray();
		
		String[] arrayBigQuestion = request.getParameterValues("Bquestion");
		String[] arrayQuestion = request.getParameterValues("question");
		String[] arrayQuestionExplanation = request.getParameterValues("questionExplanation");
		double[] arrayScore = Stream.of(request.getParameterValues("Score")).mapToDouble(Double::parseDouble).toArray();
		String[] arrayChoices = request.getParameterValues("Select_text");
		
		int choicesCnt = 0;
		int questionCnt = 0;
		List<BigQuestion> bigQuestionList = new ArrayList<>();
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
		
		ExamCreatePage newExamData = new ExamCreatePage(examData, bigQuestionList);
		session.removeAttribute("ExamCreatePage");
		session.setAttribute("ExamCreatePage", newExamData);
		
		response.sendRedirect("/ExamPlatform/ExamCreateServlet/Confirmation");
	}

}
