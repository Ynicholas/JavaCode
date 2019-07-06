package cn.zyf;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

public class CustomerDao extends BaseDao{
	public boolean addCustomer(Customer customer){
		String sql = "insert into customers" + "(cust_id,cname,email,balance)values(?,?,?,?)";
		try(
				Connection conn = (Connection) dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setString(1,customer.getCust_id());
			pstmt.setString(2,customer.getCname());
			pstmt.setString(3,customer.getEmail());
			pstmt.setDouble(4,customer.getBalance());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}
	}
	
	public Customer findByName(String cname){
		String sql = "select cust_id,cname,email,balance"+"from customers where cname=?";
		Customer customer = new Customer();
		try(
				Connection conn = (Connection) dataSource.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql)){
			pstmt.setString(1, cname);
			try(ResultSet rst = pstmt.executeQuery()){
				if(rst.next()){
					customer.setCust_id(rst.getString("cust_id"));
					customer.setCname(rst.getString("cname"));
					customer.setEmail(rst.getString("email"));
					customer.setBalance(rst.getDouble("balance"));
				}
			}
		}catch(SQLException se){
			return null;
		}
		return customer;
	}
	
	public ArrayList<Customer> findAllCustomer(){
		Customer customer = new Customer();
		ArrayList<Customer> custList = new ArrayList<Customer>();
		String sql = "select * from customers";
		try(
				Connection conn = (Connection) dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()){
			while(rst.next()){
				customer.setCust_id(rst.getString("cust_id"));
				customer.setCname(rst.getString("cname"));
				customer.setEmail(rst.getString("email"));
				customer.setBalance(rst.getDouble("balance"));
				custList.add(customer);
			}
			return custList;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
