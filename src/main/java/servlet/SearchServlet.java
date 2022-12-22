package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SearchLogic;
import model.data.SearchFilterData;
import model.data.SearchPage;
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
		HttpSession session = request.getSession();
		session.removeAttribute("searchForm");
		session.setAttribute("searchForm", new SearchPage());
		
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
		String searchWord = null;
		if(searchFormat == 4) {
			searchWord = request.getParameter("searchTag");
		}else if(searchFormat == 5) {
			searchWord = request.getParameter("searchGenre");
		}else {
			searchWord = request.getParameter("searchWord");
		}
		
		List<Integer> genreIDFilterList = new ArrayList<>();
		List<String> tagFilterList = new ArrayList<>();
		List<String> userIDFilterList = new ArrayList<>();
		int examFormatFilter = -1;
		
		if(request.getParameterValues("GenreFilter") != null) {
			List<String> tmpGenreIDFilterList = new ArrayList<>(Arrays.asList(request.getParameterValues("GenreFilter")));
			genreIDFilterList = tmpGenreIDFilterList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		}
		if(!(request.getParameterValues("tagFilter").length == 1 && request.getParameterValues("tagFilter")[0].isEmpty())) {
			tagFilterList = new ArrayList<>(Arrays.asList(request.getParameterValues("tagFilter")));
			tagFilterList.removeAll(Arrays.asList("",null));
		}
		if(!(request.getParameterValues("userIDFilter").length == 1 && request.getParameterValues("userIDFilter")[0].isEmpty())) {
			userIDFilterList = new ArrayList<>(Arrays.asList(request.getParameterValues("userIDFilter")));
			userIDFilterList.removeAll(Arrays.asList("",null));
		}
		if(request.getParameter("examFormatFilter") != null) {
			examFormatFilter = Integer.parseInt(request.getParameter("examFormatFilter"));
		}
		SearchFilterData searchFilter = new SearchFilterData(genreIDFilterList, tagFilterList, userIDFilterList, examFormatFilter);
		
		SearchResult result = searchLogic.exequte(searchFormat, searchWord, searchFilter);
		
		session.removeAttribute("searchFilter");
		session.setAttribute("searchFilter", searchFilter);
		session.removeAttribute("searchResult");
		session.setAttribute("searchResult", result);
		
		response.sendRedirect("/ExamPlatform/SearchServlet/result?page=1");
	}

}
