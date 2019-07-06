package com.orjdbc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestFY {
//
//	@Test
//	public void test(){
//		try{
//			Student student = new Student();
//			student.setStudentId("4332100230221");
//			student.setAddress("he is a good student");
//			student.setDepartMentCode("101");
//			student.setFax("020-45113912");
//			student.setSex("m");
//			student.setStudentName("zyf");
//			student.setTel("020-45449321");
//			IDao iDao = new DaoImpl();
//			iDao.insert(student);
//			
//		}catch(Exception e){
//			System.out.println(e);
//		}
//	}
	
//	@Test
//	public void testd(){
//		try{
//			
//			Student student = new Student();
//			student.setStudentId("4332100230221");
//			IDao iDao = new DaoImpl();
//			iDao.delete(student);
//		}catch(Exception e){
//			System.out.println(e);
//		}
//	}
//	
//	@Test
//	public void testu(){
//		try{
//			
//			Student student = new Student();
//			student.setStudentId("4332100230221");
//			student.setAddress("youaaaaaaaaaaaa");
//			IDao iDao = new DaoImpl();
//			iDao.update(student);
//		}catch(Exception e){
//			System.out.println(e);
//		}
//	}
	
	@Test
	public void tests(){
		try{
			Map<String,String> condition = new HashMap();
			Student student = new Student();
			student.setStudentId("4332100230221");
			condition.put("StudentId", "4332100230221");
			IDao iDao = new DaoImpl();
			iDao.query(condition);
			System.out.println("通过Map.keySet遍历key和value：");  
			for (String key : condition.keySet()) {  
				System.out.println("key= "+ key + " and value= " + condition.get(key));  
			} 
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
