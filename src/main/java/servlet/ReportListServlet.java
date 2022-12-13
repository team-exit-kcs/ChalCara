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

import dao.ReportDAO;
import model.data.Account;
import model.data.Report;
import model.data.ReportListPage;

/**
 * Servlet implementation class MyExamListServlet
 */
@WebServlet("/Mypage/ReportListServlet")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Account user = (Account) session.getAttribute("LoginUser");
		String Spage = request.getParameter("page");
		ReportListPage reportListPage = (ReportListPage) session.getAttribute("reportList");	
		
		if(user != null) {
			int page = 1;
			if(Spage != null) {
				page = Integer.parseInt(Spage);
			}
			
			List<Report> reportList = null;
			if(reportListPage != null) {
				reportList = reportListPage.getReportList();
			}else {
				ReportDAO rd = new ReportDAO();
				reportList = rd.findUserReport(user.getUserID());
			}
			
			if(reportList.isEmpty()) {
				request.setAttribute("msg", new String("レポートはありません"));
			}
			
			ReportListPage newReportListPage = new ReportListPage(page, reportList);
			
			session.removeAttribute("reportList");
			session.setAttribute("reportList", newReportListPage);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/reportList.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/NotFound.jsp");
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
