package servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.LoginLogic;
import model.data.Account;
import model.data.Login;

/**
 * Servlet implementation class UpdAccountPassServlet
 */
@WebServlet("/UpdAccountServlet/UpdPass")
public class UpdAccountPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdAccountPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/updUserPass.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginLogic loginLogic = new LoginLogic();
		AccountDAO accountDAO = new AccountDAO();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("LoginUser");
		String userID = account.getUserID();
		String pass = request.getParameter("pass");
		String newPass = request.getParameter("newPass");
		
		Login login = null;
		Account result = null;
		try {
			login = new Login(userID,pass);
			result = loginLogic.exequte(login);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(result != null) {
			Login newLogin;
			try {
				newLogin = new Login(userID,newPass);
				accountDAO.updPass(newLogin);
				
				request.setAttribute("msg", new String("パスワードの更新が完了しました"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/updUserPass.jsp");
				dispatcher.forward(request, response);
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}else {
			request.setAttribute("msg", new String("エラー：パスワードが正しくありません"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/updUserPass.jsp");
			dispatcher.forward(request, response);
		}
	}

}
