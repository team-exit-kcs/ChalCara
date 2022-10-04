package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.data.Account;
import model.data.Login;

/**
 * Servlet implementation class AccountCreateServlet
 */
@WebServlet("/AccountEntryServlet")
public class AccountEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountEntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO accountDAO = new AccountDAO();
		request.setCharacterEncoding("UTF-8");
		
		String userID = request.getParameter("id");
		if(accountDAO.isID(userID)) {
			request.setAttribute("msg", new String("エラー：そのIDはすでに使われています"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/regist.jsp");
			dispatcher.forward(request, response);
		}else {
		
			String PASS = request.getParameter("pass");
			try {
				Login EntryUser = new Login(userID,PASS);
				accountDAO.setAccount(EntryUser);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("LoginUser",new Account(userID,"","./img/kari.png"));
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<p>アカウントの登録が完了しました</p>");
			out.println("<a href=\"/ExamPlatform/MypageServlet\">マイページへ</a>");
			out.println("</html>");
		}
	}

}
