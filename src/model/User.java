package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {

	private int id;
	private String userName;
	private String password;
	private String ident;
	private String telephone;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdent() {
		return ident;
	}
	public void setIdent(String ident) {
		this.ident = ident;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<User> getAllUsers(String search) throws ClassNotFoundException, SQLException{
		ArrayList<User> users = new ArrayList<User>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "";
    	if(search != null){
			sql ="select * from user where userName like '%"+search+"%'";
		}else{
			sql ="select * from user";
		}		
    	ResultSet rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		User user = new User();
    		user.setId(rs.getInt("id"));
    		user.setUserName(rs.getString("userName"));
    		user.setIdent(rs.getString("ident"));
    		user.setTelephone(rs.getString("telephone"));
    		user.setAddress(rs.getString("address"));
    	    users.add(user);
    	}
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return users;
	}

	
	public int deleteUser(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mealsystem";
		Connection con=DriverManager.getConnection(url,"root","");
		String sql="delete from user where id=?";
		//得到预编译语句对象
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
		
	}
	
}
