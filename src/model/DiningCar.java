package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DiningCar {
	
	private int userId;
	private int foodId;
	private int result;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	
	public int addDiningCar(int userId,String foodId) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "INSERT INTO diningcar (userId,foodId) VALUES ("+userId+","+foodId+")";
    	int rs = stmt.executeUpdate(sql);
    	
    	stmt.close();
    	con.close();
		return rs;
	}
	
	//根据用户id获取该用户的菜品订餐信息
	public ArrayList<Food> getDcFoodsByUserId(int userId) throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "SELECT f.*,ft.typeName FROM food AS f,foodtype AS ft,diningcar AS dc WHERE f.type = ft.id AND dc.foodId = f.id AND dc.userId = "+userId;
    	ResultSet rs = stmt.executeQuery(sql);
    	
    	while(rs.next()){
    		Food f = new Food();
    		f.setId(rs.getInt("id"));
    		f.setFoodName(rs.getString("foodName"));
    		f.setFeature(rs.getString("feature"));
    		f.setMaterial(rs.getString("material"));
    		f.setPrice(rs.getInt("price"));
    		f.setTypeName(rs.getString("typeName"));
    		f.setHits(rs.getInt("hits"));
    		f.setComment(rs.getInt("comment"));
    		foods.add(f);
    	}
		
		
		return foods;
	}

}
