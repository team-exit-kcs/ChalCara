package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.data.BigQuestion;
import model.data.Choices;
import model.data.EntryExam;
import model.data.ExamCreatePage;
import model.data.Genre;
import model.data.Question;


/**
 * Servlet implementation class TestForwardServlet
 */
@WebServlet("/TestForwardServlet")
public class TestForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>test</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form action=\"/ExamPlatform/TestForwardServlet\" method=\"post\">");
		out.print("URL<input type=\"text\" name=\"url\">");
		out.print("<input type=\"submit\" value=\"送信\">");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
  /*Home
		List<Exam> newExamList = new ArrayList<>();
		
		newExamList.add(new Exam("", "sato", 1, "ITパスポート", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "hoge", 1, "基本情報技術者試験", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "root", 1, "’ or 'A' = 'A", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "sudo", 1, "定番クイズ10選", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "aaaa", 1, "１", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "test", 1, "簿記　勘定科目", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		newExamList.add(new Exam("", "cafe", 1, "英単語", new Date(), new Date(),60, 60, "", 1, null,"", 1000, 50));
		
		session.setAttribute("homeData",newExamList);
//	*/
		
	/*Account
		session.setAttribute("LoginUser",new Account("testUsr","プロフィール","./img/kari.png"));
//	*/		
		

    /*Mypage		
 		List<Exam> examList = new ArrayList<>();
		for(int i=0;i<3;i++) {
			examList.add("testExam"+Integer.toString(i));
		}
		
		List<Exam> bmList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			bmList.add("testExam"+Integer.toString(i));
		}
		
		List<Report> rpList = new ArrayList<>();
		rpList.add(new Report(1,"testUsr","testExam",new Date(),95,1,"ExamTest",60,10,false,false));
		rpList.add(new Report(2000,"testUsr","testExam2000",new Date(),95,0.95,"ExamTest",60,10,false,false));
		
		request.setAttribute("MypageData", new Mypage(examList,bmList,rpList));
//	 */
		
//	/*ExamOverview
		List<Genre> genreList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			genreList.add(new Genre(i,"ジャンル"+Integer.toString(i)));
		}
		
		List<String> tagList = new ArrayList<>();
		for(int i=0;i<10;i++) {
			tagList.add("Tag"+Integer.toString(i));
		}
		
		List<String> examtagList = new ArrayList<>();
		for(int i=0;i<10;i+=2) {
			examtagList.add("Tag"+Integer.toString(i));
		}
		
		EntryExam entryExam=null;
		try {
			entryExam = new EntryExam("testUsr",3,"testExam",new Date(),new Date(),60,120,null,1,null,false,0,"pass");
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		for(int a=1;a<3;a++) {
			List<Question> questionList = new ArrayList<>();
			for(int b=1;b<4;b++) {
				List<Choices> choicesList = new ArrayList<>();
				for(int c=1;c<9-b;c++) {
					choicesList.add(new Choices("exam",a,b,c,a+"-"+b+"-"+c));
				}
				questionList.add(new Question("exam",a,b,a+"-"+b,2,"",2.5,choicesList));
			}
			bigQuestionList.add(new BigQuestion("exam",a,"exam"+a,questionList));
		}
		
		session.setAttribute("ExamCreatePage", new ExamCreatePage(genreList,tagList,entryExam,bigQuestionList));
//	*/
		
		/*試験実行 小問
		List<String> tagList = new ArrayList<>();
		tagList.add("IT");
		tagList.add("情報処理技術者試験");
		tagList.add("国家試験");
		
		Exam exam = new Exam("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578","user",1,"ITパスポート",new Date(),new Date(),600,120,"｢ｉパス｣はITに関する基礎知識を問う国家試験です。IT化された社会で働くすべての方に必要な基礎的知識を証明できます。",
				2,tagList,"IT",1248,256);
		
		List<Choices> choicesList = new ArrayList<>();
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,1,1,"下請法"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,1,2,"著作権法"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,1,3,"不正競争防止法"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,1,4,"民法"));
		
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,1,"ソフトウェアの開発を外部ベンダに委託する。委託契約において特段の取決めがない場合，このソフトウェアの知的財産としての権利の帰属を規定している法律はどれか。",2,"",300,choicesList));
		
		choicesList = new ArrayList<>();
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,2,1,"ASCII"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,2,2,"EUC"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,2,3,"JAN"));
		choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,2,4,"JIS"));
		
		questionList.add(new Question("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,2,"流通システムや販売情報システムなどで用いられている商品コードはどれか。",3,"",300,choicesList));
		
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		bigQuestionList.add(new BigQuestion("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",1,null,questionList));
		
		session.setAttribute("pageData", new ExaminationPage(exam,1,bigQuestionList,false));
//	*/
		
		/*試験実行 大問
		List<String> tagList = new ArrayList<>();
		for(int i=0;i<10;i+=2) {
			tagList.add("Tag"+Integer.toString(i));
		}
		
		Exam exam = new Exam("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578","user",3,"大問仮試験",new Date(),new Date(),10,5,"大問の仮試験です",
				2,tagList,"テスト用データ",30,2);
		
		List<BigQuestion> bigQuestionList = new ArrayList<>();
		for(int a=1;a<3;a++) {
			List<Question> questionList = new ArrayList<>();
			for(int b=1;b<4;b++) {
				List<Choices> choicesList = new ArrayList<>();
				for(int c=1;c<9-b;c++) {
					choicesList.add(new Choices("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",a,b,c,a+"-"+b+"-"+c));
				}
				questionList.add(new Question("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",a,b,a+"-"+b,2,"",2.5,choicesList));
			}
			bigQuestionList.add(new BigQuestion("37268335dd6931045bdcdf92623ff819a64244b53d0e746d438797349d4da578",a,"exam"+a,questionList));
		}
		
		session.setAttribute("pageData", new ExaminationPage(exam,0,bigQuestionList,false));
//	*/		
		
		String URL = request.getParameter("url");
		RequestDispatcher dispatcher = request.getRequestDispatcher(URL);
		dispatcher.forward(request,response);
	}

}
