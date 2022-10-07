package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.Search;
import model.data.SearchResult;

/**
 * Servlet implementation class SearchResultServlet
 */
@WebServlet("/SearchServlet/result")
public class SearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		SearchResult result = (SearchResult) session.getAttribute("searchResult");	
		
		if(result==null) {
			response.sendRedirect("/ExamPlatform/SearchServlet");
		}else {
			String p = request.getParameter("page");
			int page = 1;
			if(p!=null) {
				page = Integer.parseInt(p);
			}
			List<Search> resultList = result.getResultList();
			
			if(resultList.isEmpty()) {
				request.setAttribute("msg", new String("検索結果はありませんでした"));
			}
			
			session.removeAttribute("searchResult");
			session.setAttribute("searchResult", new SearchResult(page, resultList));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/searchResult.jsp");
			dispatcher.forward(request, response);
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
