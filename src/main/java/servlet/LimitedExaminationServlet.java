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

import dao.ExamDAO;
import model.DisclosureRangeLogic;
import model.Hash;
import model.data.ExaminationPage;

/**
 * Servlet implementation class LimitedExaminationServlet
 */
@WebServlet("/ExaminationServlet/Limited")
public class LimitedExaminationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LimitedExaminationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ExamDAO examDAO = new ExamDAO();
		DisclosureRangeLogic DR = new DisclosureRangeLogic();
		HttpSession session = request.getSession();
		
		ExaminationPage pageData = (ExaminationPage) session.getAttribute("pageData");
		
		if(pageData != null && DR.isLimited(pageData.getExam().getDisclosureRange())) {
			Hash hash = new Hash();
			request.setCharacterEncoding("UTF-8");
			String PASS = null;
			try {
				PASS = hash.createHash(request.getParameter("pass"));
			} catch (NoSuchAlgorithmException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			if(examDAO.isLimitedPass(pageData.getExam().getExamID(), PASS)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/ExamGaiyou.jsp");
				dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("msg", new String("エラー：パスワードが正しくありません"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/limitedExamForm.jsp");
				dispatcher.forward(request, response);
			}
			
		}else {
			response.sendRedirect("/ExamPlatform/ExaminationServlet");
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
