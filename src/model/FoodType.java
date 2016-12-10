package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodType {

    private int id;
    private String typeName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public ArrayList<FoodType> getAllTypes(String keyword) throws ClassNotFoundException, SQLException{
		ArrayList<FoodType> foodTypes = new ArrayList<FoodType>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql ="";
		if(keyword == null){
			sql = "select * from foodtype";
		}else{
			sql="select * from foodtype where typeName like '%"+keyword+"%'";
		}
    	ResultSet rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		FoodType foodType = new FoodType();
    		foodType.setId(rs.getInt("id"));
    		foodType.setTypeName(rs.getString("typeName"));
    	    foodTypes.add(foodType);
    	}
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return foodTypes;
	}
	
	
	public int deleteFoodType(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mealsystem";
		Connection con=DriverManager.getConnection(url,"root","");
		String sql="delete from foodtype where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
	}
	
	public int editFoodTypeAct(String id,String typeN) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mealsystem";
		Connection con=DriverManager.getConnection(url,"root","");
		String sql="update foodtype set typeName=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, typeN);
		pstmt.setInt(2, Integer.parseInt(id));
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
	}
	
	public int addFoodTypeAct(String typeN) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
		Connection con = DriverManager.getConnection(dbUrl,"root","");
		String sql ="insert into foodtype(typeName)values(?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, typeN);
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
		
	}
}
