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
import model.data.Mypage;
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
		
		HttpSession session = request.getSession();
		session.setAttribute("Account",new Account("testUsr","プロフィール","./img/kari.png"));
		
		List<String> examList = new ArrayList<>();
		
		List<String> bmList = new ArrayList<>();
		bmList.add("testExam1");
		bmList.add("testExam2");
		bmList.add("testExam3");
		bmList.add("testExam4");
		bmList.add("testExam5");
		bmList.add("testExam6");
		
		List<Report> rpList = new ArrayList<>();
		rpList.add(new Report(1,"testUsr","testExam",new Date(),new Date(), 95,0.95,"ExamTest",60));
		
		request.setAttribute("MypageData", new Mypage(examList,bmList,rpList));
		
		String URL = request.getParameter("url");
		RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		dispatcher.forward(request,response);
	}

}
