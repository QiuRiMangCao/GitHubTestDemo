package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Food {

	private int id;
	private int price;
	private String picture;
	private String foodName;
	private String material;
	private String feature;
	private String typeName;
	private int type;
	private int hits;
	private int comment;
	
	
	
	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getFeature() {
		return feature;
	}



	public void setFeature(String feature) {
		this.feature = feature;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public int getHits() {
		return hits;
	}



	public void setHits(int hits) {
		this.hits = hits;
	}



	public int getComment() {
		return comment;
	}



	public void setComment(int comment) {
		this.comment = comment;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getFoodName() {
		return foodName;
	}



	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}



	public ArrayList<Food> getHotFoods() throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList<Food>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "select * from food order by hits desc limit 1,3";
    	ResultSet rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		Food f = new Food();
    		f.setId(rs.getInt("id"));
    		f.setPicture(rs.getString("picture"));
    		f.setPrice(rs.getInt("price"));
    		f.setFoodName(rs.getString("foodName"));
    	    foods.add(f);
    	}
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return foods;
	}
	
	public ArrayList<Food> getCommentFoods() throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList<Food>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "select * from food where comment=0";
    	ResultSet rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		Food commentFood = new Food();
    		commentFood.setId(rs.getInt("id"));
    		commentFood.setPicture(rs.getString("picture"));
    		commentFood.setPrice(rs.getInt("price"));
    		commentFood.setFoodName(rs.getString("foodName"));
    	    foods.add(commentFood);
    	}
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return foods;
	}
	
	public ArrayList<Food> getLowPriceFoods() throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList<Food>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "select * from food order by price desc limit 1,3";
    	ResultSet rs = stmt.executeQuery(sql);
    	while(rs.next()){
    		Food f = new Food();
    		f.setId(rs.getInt("id"));
    		f.setPicture(rs.getString("picture"));
    		f.setPrice(rs.getInt("price"));
    		f.setFoodName(rs.getString("foodName"));
    	    foods.add(f);
    	}
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return foods;
	}
	
	//根据菜品的id，到数据库中查询菜品的详情
	public Food getFoodDetailById(String id) throws ClassNotFoundException, SQLException{  //返回string类型
		Food f = new Food();
		//连接数据库，通过商品id到数据中查询商品详情，并通过f进行存储
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
		String sql = "SELECT f.*,ft.typeName FROM food as f,foodtype as ft WHERE f.type=ft.id AND f.id ="+id;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			f.setId(rs.getInt("id"));
    		f.setFoodName(rs.getString("foodName"));
    		f.setFeature(rs.getString("feature"));
    		f.setMaterial(rs.getString("material"));
    		f.setPrice(rs.getInt("price"));
    		f.setTypeName(rs.getString("typeName"));
    		f.setHits(rs.getInt("hits"));
    		f.setComment(rs.getInt("comment"));
 
    	}
		
		return f;
	}
	
	public ArrayList<Food> getAllFoodList() throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList<Food>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
    	Connection con = DriverManager.getConnection(dbUrl,"root","");
    	Statement stmt = con.createStatement();
    	String sql = "SELECT f.*,ft.typeName FROM food as f,foodtype as ft WHERE f.type=ft.id";
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
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
		return foods;
	}
	
	
	public ArrayList<Food> getAdminListFood(String keyword,String s_type) throws ClassNotFoundException, SQLException{
		ArrayList<Food> foods = new ArrayList<Food>();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
		Connection con = DriverManager.getConnection(dbUrl,"root","");
		Statement stmt = con.createStatement();
		String sql ="";
		if((keyword == null)&&(s_type==null)){
			sql ="SELECT f.*,ft.typeName FROM food as f,foodtype as ft WHERE f.type=ft.id";
		}else if((keyword != null)&&(s_type.equals("0"))){
			sql ="SELECT f.*,ft.typeName FROM food as f,foodtype as ft WHERE f.type=ft.id AND foodName like '%"+keyword+"%'";
		}else{
			sql ="SELECT f.*,ft.typeName FROM food as f,foodtype as ft WHERE f.type=ft.id AND foodName like '%"+keyword+"%' AND type='"+s_type+"'";
		}
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
    	
    	rs.close();
    	stmt.close();
    	con.close();
    	
    	
    	return foods;
	}
		
	public int deleteFood(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mealsystem";
		Connection con=DriverManager.getConnection(url,"root","");
		String sql="delete from food where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
	}
		
	public Food adminEditFood(String id) throws ClassNotFoundException, SQLException {
		Food f = new Food();
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl="jdbc:mysql://localhost:3306/mealsystem";
		Connection con = DriverManager.getConnection(dbUrl,"root","");
		String sql ="select * from food where id =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs=null;
		rs=pstmt.executeQuery();
		while(rs.next()){
			f.setId(rs.getInt("id"));
    		f.setFoodName(rs.getString("foodName"));
    		f.setFeature(rs.getString("feature"));
    		f.setMaterial(rs.getString("material"));
    		f.setPrice(rs.getInt("price"));
    		f.setType(rs.getInt("type"));
    		f.setHits(rs.getInt("hits"));
    		f.setComment(rs.getInt("comment"));
 
    	}
		
		return f;
	}
	
	
	public int adminEditFoodAct(String id,String foodName,String fea,String mat,String price,String type,String com) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbUrl="jdbc:mysql://localhost:3306/mealsystem";
		Connection con = DriverManager.getConnection(dbUrl,"root","");
		String sql ="update food set foodName =?,feature=?,material=?,price=?,comment=?,type=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, foodName);
		pstmt.setString(2, fea);
		pstmt.setString(3, mat);
		pstmt.setString(4, price);
		pstmt.setString(5, com);
		pstmt.setString(6, type);
		pstmt.setInt(7, Integer.parseInt(id));
		int r = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return r;
	}
	
}
