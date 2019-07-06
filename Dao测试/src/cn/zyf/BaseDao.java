package cn.zyf;

import javax.naming.*;
import javax.sql.DataSource;
import java.sql.*;

import com.mysql.jdbc.Connection;

public class BaseDao {
	DataSource dataSource;
	public BaseDao(){
		try{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:conp/env/jdbc/sampleDS");
		}catch(NamingException ne){
			System.out.println("Exception:" + ne);
		}
	}
	public Connection getConnection()throws Exception{
		return (Connection) dataSource.getConnection();
	}
}
