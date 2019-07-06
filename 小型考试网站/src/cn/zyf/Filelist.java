package cn.zyf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filelist
 */
@WebServlet("/Filelist")
public class Filelist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String imgDirectory=getServletContext().getRealPath("/")+"member";
		
	    File parentDirectory = new File(imgDirectory);

	    ArrayList file = new ArrayList();//��ŵ�ǰĿ¼�����е��ļ� 
	    ArrayList directory = new ArrayList();//��ŵ�ǰĿ¼�����е�Ŀ¼ 
	    String [] filename = null;//��ʱ���� ��ŵ�ǰĿ¼�����е��ļ���Ŀ¼�ľ���·�����������ֵ��ַ��� 

	    filename=parentDirectory.list();//��ȡԴĿ¼���ļ�����
	    File[] files=parentDirectory.listFiles();//��ȡԴĿ¼�µ��ļ�����
	    for(int i = 0 ; i<files.length ; i++ ){ 
	        //�����ж� ��Ŀ¼�ķ���directory������ �ļ��ķ���file������ 
	        if(files[i].isDirectory()) {
	            directory.add(filename[i]); 
	        }else {
	            file.add(filename[i]);
	            System.out.println(filename[i]);
	        }
	    }
	    request.setAttribute("filename", filename);
	    RequestDispatcher rd = request.getRequestDispatcher("/FileDownload.jsp");
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
