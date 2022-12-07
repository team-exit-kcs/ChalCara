package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReportDAO;
import model.CheckAnsPageLogic;
import model.data.Account;
import model.data.CheckAnsPage;
import model.data.Report;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/Report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Report report = (Report) session.getAttribute("report");
		Account user = (Account) session.getAttribute("LoginUser");
		String reportID = request.getParameter("reportID");
		
		if(user != null && reportID != null) {
			ReportDAO reportDAO = new ReportDAO();
			CheckAnsPageLogic capl = new CheckAnsPageLogic();
			
			report = reportDAO.findReportInfo(user.getUserID(), Integer.parseInt(reportID));
			
			session.removeAttribute("report");
			session.setAttribute("report", report);
			
			session.removeAttribute("checkAnsPage");
			if(report != null) {
				CheckAnsPage checkAnsPage = capl.execute(user.getUserID(), report);
				if(checkAnsPage != null) {
					session.setAttribute("checkAnsPage", checkAnsPage);
				}
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ResultReport.jsp");
			dispatcher.forward(request, response);
		}else if(report != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ResultReport.jsp");
			dispatcher.forward(request, response);
			
		}else {
			request.setAttribute("msg", new String("レポート情報が見つかりませんでした"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/error.jsp");
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
