package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MypageLogic;
import model.data.Account;
import model.data.Mypage;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("LoginUser");
		MypageLogic ml = new MypageLogic();
		Mypage m = ml.exequte(account.getUserID());
		session.setAttribute("MypageData", m);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Mypage.jsp");
		dispatcher.forward(request, response);
	}
	
}
