package cn.zyf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/addCustomer.do")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		String message = null;
		try{
			customer.setCust_id(request.getParameter("cust_id"));
			customer.setCname(new String(request.getParameter("cname").getBytes("iso-8859-1"),"UTF-8"));
			customer.setEmail(new String(request.getParameter("email").getBytes("iso-8859-1"),"UTF-8"));
			customer.setBalance(Double.parseDouble(request.getParameter("balance")));
			boolean success = dao.addCustomer(customer);
			if(success){
				message = "<li>成功植入一条记录！</li>";
			}else{
				message = "<li>插入记录错误</li>";
			}
		}catch(Exception e){
			message = "<li>插入记录错误</li>";
		}
		request.setAttribute("ressult", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/addCustomer.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
