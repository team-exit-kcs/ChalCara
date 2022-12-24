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

import model.StartGameLogic;
import model.data.Game;
import model.data.SearchPage;

/**
 * Servlet implementation class GameStartServlet
 */
@WebServlet("/Game/Start")
public class GameStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("searchGame", new SearchPage());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/gameStart.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StartGameLogic gsl = new StartGameLogic();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		List<Integer> genreIDFilterList = new ArrayList<>();
		List<String> tagFilterList = new ArrayList<>();
		
		if(request.getParameterValues("GenreFilter") != null) {
			List<String> tmpGenreIDFilterList = new ArrayList<>(Arrays.asList(request.getParameterValues("GenreFilter")));
			genreIDFilterList = tmpGenreIDFilterList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		}
		if(!(request.getParameterValues("tagFilter").length == 1 && request.getParameterValues("tagFilter")[0].isEmpty())) {
			tagFilterList = new ArrayList<>(Arrays.asList(request.getParameterValues("tagFilter")));
			tagFilterList.removeAll(Arrays.asList("",null));
		}
		
		Game game = gsl.execute(genreIDFilterList, tagFilterList);
		if(game.getQuestionList().isEmpty()) {
			String msg = "一致する問題がありません。問題を選択し直してください。";
			request.setAttribute("msg", msg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/gameStart.jsp");
			dispatcher.forward(request, response);
		}else {
			session.removeAttribute("game");
			session.setAttribute("game", game);
			
			response.sendRedirect("/ExamPlatform/Game/play");
		}
	}

}
