package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.Account;
import model.data.BigQuestion;
import model.data.Choices;
import model.data.EntryExam;
import model.data.ExamCreatePage;
import model.data.Genre;
import model.data.Mypage;
import model.data.Question;
import model.data.Report;

/**
 * Servlet implementation class TestForwardServlet
 */
@WebServlet("/TestForwardServlet")
public class TestForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>test</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action=\"/ExamPlatform/TestForwardServlet\" method=\"post\">");
		out.print("URL<input type=\"text\" name=\"url\">");
		out.print("<input type=\"submit\" value=\"送信\">");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
//	/*Account
		HttpSession session = request.getSession();
		session.setAttribute("LoginUser",new Account("testUsr","プロフィール","./img/kari.png"));
//	*/		
		

//	/*Mypage		
 		List<String> examList = new ArrayList<>();
		for(int i=0;i<3;i++) {
			examList.add("testExam"+Integer.toString(i));
		}
		
		List<String> bmList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			bmList.add("testExam"+Integer.toString(i));
		}
		
		List<Report> rpList = new ArrayList<>();
		rpList.add(new Report(1,"testUsr","testExam",new Date(),new Date(), 95,0.95,"ExamTest",60));
		rpList.add(new Report(2000,"testUsr","testExam2000",new Date(),new Date(), 95,0.95,"ExamTest",60));
		
		request.setAttribute("MypageData", new Mypage(examList,bmList,rpList));
//	 */
		
//	/*ExamOverview
		List<Genre> genreList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			genreList.add(new Genre(i,"ジャンル"+Integer.toString(i)));
		}
		
		List<String> tagList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			tagList.add("Tag"+Integer.toString(i));
		}
		
		List<String> examtagList = new ArrayList<>();
		for(int i=0;i<10;i+=2) {
			examtagList.add("Tag"+Integer.toString(i));
		}
		
		EntryExam entryExam = new EntryExam("test","testUsr",3,"testExam",new Date(),new Date(),60,120,"試験概要です",1,examtagList,"pass");
		
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		
		for(int a=1;a<3;a++) {
			List<Question> questionList = new ArrayList<>();
			for(int b=1;b<4;b++) {
				List<Choices> choicesList = new ArrayList<>();
				for(int c=1;c<9-b;c++) {
					choicesList.add(new Choices("exam",a,b,c,a+"-"+b+"-"+c));
				}
				questionList.add(new Question("exam",a,b,a+"-"+b,2,"",2.5,choicesList));
			}
			bigQuestionList.add(new BigQuestion("exam",a,"exam"+a,questionList));
		}
		
		session.setAttribute("ExamCreatePage", new ExamCreatePage(genreList,tagList,entryExam,0,bigQuestionList));
//	*/
		
		
		
		String URL = request.getParameter("url");
		RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		dispatcher.forward(request,response);
	}

}
