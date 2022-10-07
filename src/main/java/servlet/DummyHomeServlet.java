package servlet;

import java.io.IOException;
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

import model.data.Exam;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class DummyHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DummyHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	//  /*Home
			List<Exam> newExamList = new ArrayList<>();
			
			newExamList.add(new Exam("", "dummy", 1, "ITパスポート", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "基本情報技術者試験", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "’ or 'A' = 'A", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "定番クイズ10選", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "１", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "簿記　勘定科目", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			newExamList.add(new Exam("", "dummy", 1, "英単語", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
			
			session.setAttribute("homeData",newExamList);
//		*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
