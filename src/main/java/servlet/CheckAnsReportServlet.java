package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.CheckAnsPage;

/**
 * Servlet implementation class CheckAnsReportServlet
 */
@WebServlet("/Report/CheckAns")
public class CheckAnsReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnsReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		CheckAnsPage checkAnsPage = (CheckAnsPage) session.getAttribute("checkAnsPage");
		
		if(checkAnsPage == null) {
			request.setAttribute("msg", new String("情報が見つかりませんでした"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
			dispatcher.forward(request, response);
		}else {
			if(checkAnsPage.getBQCheckAnsList().get(0).getBigQuestionSentence() == null) {
				//小問形式
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/SSeigohantei.jsp");
				dispatcher.forward(request, response);
			}else {
				//大問形式
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/BSeigohantei.jsp");
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
