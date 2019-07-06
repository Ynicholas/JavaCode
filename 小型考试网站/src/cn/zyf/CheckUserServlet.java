package cn.zyf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
	String message = null;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=utf-8");
		String value1="";
		String value2="";
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0;i < cookies.length;i++){
				cookie = cookies[i];
				if(cookie.getName().equals("username"))
					value1 = cookie.getValue();
				if(cookie.getName().equals("password"))
					value2 = cookie.getValue();
			}
			HttpSession session = request.getSession(true);
			String username2 = (String)session.getAttribute("username");
			String password2 = (String)session.getAttribute("password");
			if(value1.equals(username2)&&value2.equals(password2)){
				message = "欢迎您！" + value1 + "再次登录该界面！";
				request.getSession().setAttribute("message", message);
				response.sendRedirect("test.jsp");
			}else{
				response.sendRedirect("denglu.jsp");
			}
		}else{
			response.sendRedirect("denglu.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		HttpSession session = request.getSession(true);
		String username2 = (String)session.getAttribute("username");
		String password2 = (String)session.getAttribute("password");
		if(!username.equals(username2)||!password.equals(password2)){
			message = "用户名或口令不正确，请重试！";
			request.getSession().setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/denglu.jsp");
			rd.forward(request, response);
		}else{
			if((request.getParameter("check")!=null)&&(request.getParameter("check").equals("check"))){
				Cookie nameCookie = new Cookie("username",username);
				Cookie pswdCookie = new Cookie("password",password);
				nameCookie.setMaxAge(60*60);
				pswdCookie.setMaxAge(60*60);
				response.addCookie(nameCookie);
				response.addCookie(pswdCookie);
			}
			message = "您已成功登录！";
			request.getSession().setAttribute("message",message);
//			RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
//			rd.forward(request, response);
			response.sendRedirect("test.jsp");
		}
	}

}
