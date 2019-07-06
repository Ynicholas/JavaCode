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

	    ArrayList file = new ArrayList();//存放当前目录中所有的文件 
	    ArrayList directory = new ArrayList();//存放当前目录中所有的目录 
	    String [] filename = null;//临时数组 存放当前目录中所有的文件和目录的绝对路径加完整名字的字符串 

	    filename=parentDirectory.list();//获取源目录下文件名称
	    File[] files=parentDirectory.listFiles();//获取源目录下的文件个数
	    for(int i = 0 ; i<files.length ; i++ ){ 
	        //进行判断 是目录的放入directory集合中 文件的放入file集合中 
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
