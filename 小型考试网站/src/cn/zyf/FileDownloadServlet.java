package cn.zyf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = (String) request.getParameter("filename");
		
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		
		OutputStream os = response.getOutputStream();
		ServletContext context = getServletContext();
		
//		String realPath = this.getServletContext().getRealPath("/member/222.png");
//		System.out.println(realPath);
		InputStream is = context.getResourceAsStream("/member/"+filename);
//		if(is==null){
//			System.out.println(1);
//		}else{
//			System.out.println(2);
//		}
		byte[] bytearray = new byte[1024];
		int bytesread = 0;
		
		while((bytesread = is.read(bytearray))!=-1){
			os.write(bytearray,0,bytesread);
		}
		os.flush();
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
