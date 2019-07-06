package com.orjdbc;

import java.util.Map;

public interface IDao {
	public void insert(Student student) throws Exception;
	public void delete(Student student) throws Exception;
	public void update(Student student) throws Exception;
	public void query(Map<String,String> condition) throws Exception;
}
