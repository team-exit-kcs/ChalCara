package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SearchLogic;
import model.data.SearchResult;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchLogic searchLogic = new SearchLogic();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		int searchFormat = Integer.parseInt(request.getParameter("searchFormat"));
		String searchWord = request.getParameter("searchWord");
		
		SearchResult result = searchLogic.exequte(searchFormat, searchWord);
		
		session.removeAttribute("searchResult");
		session.setAttribute("searchResult", result);
		
		response.sendRedirect("/ExamPlatform/SearchServlet/result?page=1");
	}

}
