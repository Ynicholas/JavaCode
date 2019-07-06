package cn.zyf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String quest1 = request.getParameter("quest1");
		String quest2 = request.getParameter("quest2");
		String quest3 = request.getParameter("quest3");
		String quest4 = request.getParameter("quest4");
		String quest5 = request.getParameter("quest5");
		HttpSession session = request.getSession(true);
		String username3 = (String)session.getAttribute("username");
		String password3 = (String)session.getAttribute("password");
		int score = 0;
		if(quest1 != null && quest1.equals("3")){
			score = score + 20;
		}
		if(quest2 != null && quest2.equals("1")){
			score = score + 20;
		}
		if(quest3 != null && quest3.equals("2")){
			score = score + 20;
		}
		if(quest4 != null && quest4.equals("3")){
			score = score + 20;
		}
		if(quest5 != null && quest5.equals("2")){
			score = score + 20;
		}
		System.out.println("考试完成 昵称："+ username3 + "密码：" + password3 + "分数：" + score);
		out.println("<html><head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		out.println("<title>测试结果</title>");
		out.println("</head><body>");
		out.println("昵称：" + username3);
		out.println("密码：" + password3);
		out.println("你的成绩是：" + score + "分");
		out.println("<br><a href='function.jsp'>回到首页</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
