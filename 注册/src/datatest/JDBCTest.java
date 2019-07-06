package datatest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/project";
		String user = "visit2";
		String password = "123456";
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			Statement statement = con.createStatement();
			String sql = "select * from yonghuixinxi";
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println("--------------");
			System.out.println("ִ�н��������ʾ:");
			System.out.println("--------------");
			System.out.println("�ֻ���"+"\t"+"����");
			System.out.println("--------------");
			
			String name = null;
			while(rs.next()){
				name = rs.getString("name");
				name = new String(name.getBytes("ISO-8859-1"),"GB2312");
				System.out.println(rs.getString("phone")+"\t"+name);
			}
			rs.close();
			con.close();
		}catch(ClassNotFoundException e){
			System.out.println("Sorry,can't find the Driver");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
