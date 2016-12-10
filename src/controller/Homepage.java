package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Food;

/**
 * Servlet implementation class Homepage
 */
@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Food food = new Food();
		ArrayList<Food> foods = new ArrayList();
		try {
			foods = food.getHotFoods();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Food commentFood = new Food();
		ArrayList<Food> commentFoods = new ArrayList();
		try {
			commentFoods = commentFood.getCommentFoods();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Food lowPriceFood = new Food();
		ArrayList<Food> lowPriceFoods = new ArrayList();
		try {
			lowPriceFoods = lowPriceFood.getCommentFoods();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("hotFoods", foods);
		request.setAttribute("commentFoods", commentFoods);
		request.setAttribute("lowPriceFoods", lowPriceFoods);
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}
	   
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
