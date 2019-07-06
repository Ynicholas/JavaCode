package com.orjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.Result;

public class DaoImpl implements IDao{

	@Override
	public void insert(Student student) throws Exception {
		// TODO Auto-generated method stub
		
//		Connection ct = zJdbc.getConnection();
		String insetSql = "insert into STUDENTINFO (STUDENTID,STUDENTNAME,SEX,DEPARTMENTCODE,ADDRESS,TEL) values(?,?,?,?,?,?)";
		String info[] = new String[6];
		info[0] = student.getStudentId();
		info[1] = student.getStudentName();
		info[2] = student.getSex();
		info[3] = student.getDepartMentCode();
		info[4] = student.getAddress();
		info[5] = student.getTel();
//		PreparedStatement ps = ct.prepareStatement(insetSql);
//		ps.setString(1, student.getStudentId());
//		ps.setString(2, student.getStudentName());
//		ps.setString(3, student.getSex());
//		ps.setString(4, student.getDepartMentCode());
//		ps.setString(5, student.getAddress());
//		ps.setString(6, student.getTel());
		
		boolean fg = zJdbc.executeupdate(insetSql, info);
		if(fg){
			System.out.println("插入语句成功");
		}else{
			System.out.println("插入语句失败");
		}
		
//		ResultSet rs = ps.executeQuery();
//		System.out.println(rs.wasNull());
//		zJdbc.close(ct, ps, rs);
		
	}

	@Override
	public void delete(Student student) throws Exception {
		// TODO Auto-generated method stub
//		Connection ct = zJdbc.getConnection();
		String deleteSql = "delete from STUDENTINFO where StudentId = ?";
		String studentId = student.getStudentId();
		String info[] = new String[1];
		info[0] = studentId;
		boolean fg = zJdbc.executeupdate(deleteSql, info);
		if(fg){
			System.out.println("删除语句成功");
		}else{
			System.out.println("删除语句失败");
		}
//		PreparedStatement ps = ct.prepareStatement(deleteSql);
//		ps.setString(1, student.getStudentId());
//		ResultSet rs = ps.executeQuery();
//		System.out.println(rs.wasNull());
//		zJdbc.close(ct, ps, rs);

	}

	@Override
	public void update(Student student) throws Exception {
		// TODO Auto-generated method stub
//		Connection ct = zJdbc.getConnection();
//		String studentId = student.getStudentId();
		String info[] = new String[2];
		info[0] = student.getAddress();
		info[1] = student.getStudentId();
		String updateSql = "update STUDENTINFO set ADDRESS = ? where StudentId = ?";
		boolean fg = zJdbc.executeupdate(updateSql, info);
		if(fg){
			System.out.println("更新语句成功");
		}else{
			System.out.println("更新语句失败");
		}
//		PreparedStatement ps = ct.prepareStatement(updateSql);
//		ps.setString(1, student.getAddress());
//		ps.setString(2, student.getStudentId());
//		ResultSet rs = ps.executeQuery();
//		System.out.println(rs.wasNull());
//		zJdbc.close(ct, ps, rs);
	}


	@Override
	public void query(Map<String, String> condition) throws Exception {
		// TODO Auto-generated method stub
//		Connection ct = zJdbc.getConnection();
		String selectSql = "select * from STUDENTINFO where StudentId = ?";
//		PreparedStatement ps = ct.prepareStatement(selectSql);
//		ps.setString(1, (String) condition.get("StudentId"));
		String info[] = new String[1];
		info[0] = condition.get("StudentId");
//		condition = zJdbc.executequery(selectSql, info);
		
		condition.putAll(zJdbc.executequery(selectSql, info));
		
//		System.out.println("通过Map.keySet遍历key和value：");  
//		for (String key : condition.keySet()) {  
//			System.out.println("key= "+ key + " and value= " + condition.get(key));  
//		} 
		
//		ResultSet rs = zJdbc.executequery(selectSql, info);
//		ResultSetMetaData rsmd = rs.getMetaData();
//		while(rs.next()){
////			condition.put("StudentId", rs.getString(1));
////			condition.put("Address", rs.getString(2));
////			condition.put("DepartMentCode", rs.getString(3));
////			condition.put("Fax",rs.getString(4));
////			condition.put("setSex", rs.getString(5));
////			condition.put("StudentName", rs.getString(6));
////			condition.put("Tel", "");
//			
//			for(int j=1;j<=rsmd.getColumnCount();j++){
//				condition.put(rsmd.getColumnName(j).toString(), rs.getString(j));
//			}		
//			
//		}
////		zJdbc.close(ct, ps, rs);
//		rs.close();
//		zJdbc.close();
		
		List<HashMap<String,String>> conlist = null;
		HashMap<String,String> con = new HashMap();
		
		String sqls = "select * from STUDENTINFO";
		conlist = zJdbc.executequery(sqls);
		for(int k = 0;k < conlist.size();k++){
			con = conlist.get(k);
			for(String key : con.keySet()){
				System.out.println(key+" + "+con.get(key));
			}
		}
	}

}
