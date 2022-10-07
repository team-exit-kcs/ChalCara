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

import model.WithdrawLogic;
import model.data.Account;
import model.data.Login;

/**
 * Servlet implementation class withdrawConfirmServlet
 */
@WebServlet("/UpdAccountServlet/Withdraw/confirm")
public class withdrawConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdrawConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/withdrawConfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WithdrawLogic withdrawLogic = new WithdrawLogic();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Account account = (Account) session.getAttribute("LoginUser");
		String userID = request.getParameter("id");
		String pass = request.getParameter("pass");
		boolean result = false;
		
		if(userID.equals(account.getUserID())) {
			try {
				result=withdrawLogic.exequte(new Login(userID,pass));
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		
		if(result) {
			session.removeAttribute("LoginUser");
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<p>退会が完了しました</p>");
	        out.println("<a href=\"#\">ホームに戻る</a>");
	        out.println("</html>");
		}else {
			request.setAttribute("msg", new String("エラー：ユーザIDまたはパスワードが正しくありません"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/withdrawConfirm.jsp");
			dispatcher.forward(request, response);
		}
	}

}
