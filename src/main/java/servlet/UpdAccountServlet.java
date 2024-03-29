package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.data.Account;

/**
 * Servlet implementation class UpdAccountServlet
 */
@WebServlet("/UpdAccountServlet")
public class UpdAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/accountSettings.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO accountDAO = new AccountDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("LoginUser");
		String profile = request.getParameter("profile");
		
		String useInfoCheck = request.getParameter("useInfo");
		boolean useInfo = false;
		if(useInfoCheck != null && useInfoCheck.equals("true")) {
			useInfo = true;
		}
		
		String userID = account.getUserID();
		accountDAO.updAccount(userID, profile, useInfo);
		
		session.removeAttribute("LoginUser");
		session.setAttribute("LoginUser", new Account(userID,profile,account.getIcon(),useInfo));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/accountSettings.jsp");
		dispatcher.forward(request, response);
	}

}
