package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserPageLogic;
import model.data.Account;
import model.data.UserPage;

/**
 * Servlet implementation class UserPageServlet
 */
@WebServlet("/UserPageServlet")
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPageLogic userPageLogic = new UserPageLogic();
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		String userID = request.getParameter("userID");
		Account user = (Account) session.getAttribute("LoginUser");
		
		UserPage pageData = userPageLogic.exequte(userID);
		
		if(pageData == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
			dispatcher.forward(request, response);
			
		}if(user != null && userID.equals(user.getUserID())){
			response.sendRedirect("/ExamPlatform/MypageServlet");
			
		}else {
			request.setAttribute("userPage", pageData);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/userPage.jsp");
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
