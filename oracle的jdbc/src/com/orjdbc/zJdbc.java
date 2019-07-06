package com.orjdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class zJdbc {
	public static void main(String[] args){
		
		try{
			Connection connection = getConnection();
			

			Statement createStatement = connection.createStatement();
			String sql = "select classid,className,TEACHERID,COURSEID,CLASSYEAR,CLASSTIMEPLACE from CLASSINFO where classid=1";
			//String sql = "select * from CLASSINFO";
			String sql2 = "select * from CLASSINFO where classid = ?";
			
			PreparedStatement pst = connection.prepareStatement(sql2);
			//pst.setString(1, "className");
			pst.setInt(1, 1);
			ResultSet executeQuery = pst.executeQuery();
			
//			while(executeQuery.next()){
//				System.out.println(executeQuery.getString("className"));
//			}
			
		//	ResultSet executeQuery = createStatement.executeQuery(sql);
			while(executeQuery.next()){
				String s1 = executeQuery.getString(1);
				String s2 = executeQuery.getString(2);
				String s3 = executeQuery.getString(3);
				String s4 = executeQuery.getString(4);
				String s5 = executeQuery.getString(5);
				String s6 = executeQuery.getString(6);
				String s1p = executeQuery.getString("classid");
				String s2p = executeQuery.getString("className");
				String s3p = executeQuery.getString("TEACHERID");
				String s4p = executeQuery.getString("COURSEID");
				String s5p = executeQuery.getString("CLASSYEAR");
				String s6p = executeQuery.getString("CLASSTIMEPLACE");
				System.out.println("s2="+s2+",s2p="+s2p);
				System.out.println("s1="+s1+",s1p="+s1p);

			}
			executeQuery.close();
			createStatement.close();
			connection.close();
		}catch(Exception e){
			System.out.println(e+"111");
		}
	}
	

	
	static Connection ct = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	
	static{
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.获得连接
	public static Connection getConnection() throws IOException{
		Properties properties = new Properties();
		InputStream inputStream = zJdbc.class.getClassLoader().getResourceAsStream("jdbc.properties");	
		properties.load(inputStream);
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("url");
		 
		try{
			ct = (Connection) DriverManager.getConnection(jdbcUrl,user,password);
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
//	public static Connection getConnection() throws IOException,ClassNotFoundException, SQLException{
//		InputStream inputStream = zJdbc.class.getClassLoader().getResourceAsStream("jdbc.properties");
//		
//		properties.load(inputStream);
//		
//
//		
//		Class.forName(driver);
//		Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
//		return connection;
//	}
	

	
	public static void close() throws Exception{
		if(rs != null){
			rs.close();
		}else if(ps != null){
			ps.close();
		}else if(ct != null){
			ct.close();
		}	
	}
	
	public static Map<String,String> executequery(String sql,String info[]) throws Exception{
		ct = getConnection();
		ps = ct.prepareStatement(sql);
		int i = 1;
		for(String infoa:info){
			ps.setString(i, infoa);
		}
		rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		Map<String,String> condition =new HashMap();
		while(rs.next()){
//			condition.put("StudentId", rs.getString(1));
//			condition.put("Address", rs.getString(2));
//			condition.put("DepartMentCode", rs.getString(3));
//			condition.put("Fax",rs.getString(4));
//			condition.put("setSex", rs.getString(5));
//			condition.put("StudentName", rs.getString(6));
//			condition.put("Tel", "");
			
			for(int j=1;j<=rsmd.getColumnCount();j++){
				condition.put(rsmd.getColumnName(j).toString(), rs.getString(j));
			}		
			
		}
		close();
		return condition;
	}
	
	public static List<HashMap<String,String>> executequery(String sql) throws Exception{
		Map<String,String> condition =new HashMap();
		List<HashMap<String,String>> conlist = new ArrayList();
		ct = getConnection();
		ps = ct.prepareStatement(sql);
		rs = ps.executeQuery();

		while(rs.next()){
//			condition.put("StudentId", rs.getString(1));
//			condition.put("Address", rs.getString(2));
//			condition.put("DepartMentCode", rs.getString(3));
//			condition.put("Fax",rs.getString(4));
//			condition.put("setSex", rs.getString(5));
//			condition.put("StudentName", rs.getString(6));
//			condition.put("Tel", "");
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int j=1;j<=rsmd.getColumnCount();j++){
				condition.put(rsmd.getColumnName(j).toString(), rs.getString(j));
			}
			conlist.add((HashMap<String, String>) condition);
		}
		close();
		return conlist;
	}
	
	public static boolean executeupdate(String sql,String info[]) throws Exception{
		ct = getConnection();
		ps = ct.prepareStatement(sql);
		int i=1;
		for(String infoa:info){
			ps.setString(i, infoa);
			i++;
		}
		System.out.println(ps);
		int rs = ps.executeUpdate();
		if(rs == 0){
			close();
			return false;
		}
		close();
		return true;
	}
}


