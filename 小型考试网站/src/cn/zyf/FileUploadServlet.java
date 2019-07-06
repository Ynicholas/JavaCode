package cn.zyf;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(location="D:\\",fileSizeThreshold = 1024)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);
//		String mnumber = request.getParameter("mnumber");
//		System.out.println(mnumber);
		Part p = request.getPart("fileName");
		
		String message1 = "";
		if(p.getSize() > 1024*1024){
			p.delete();
			message1 = "文件太大，不能上传！";
			
		}else{
			path = path+"member";
			System.out.println(path);
			File f = new File(path);
			System.out.println(f.exists());
			if(!f.exists()){
				f.mkdirs();
				System.out.println("1111");
			}
			String h = p.getHeader("content-disposition");
			System.out.println(h);
			String fname = h.substring(h.lastIndexOf("=")+2,h.length()-1);
			System.out.println(fname);
			System.out.println(path+ "\\" + fname);
			p.write(path + "\\" +fname);
			message1 = "文件上传成功";
		}
		request.setAttribute("message1", message1);
		RequestDispatcher rd = request.getRequestDispatcher("/FileUpload.jsp");
		rd.forward(request,response);
	}

}
