package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FoodType;

/**
 * Servlet implementation class AdminAddFoodTypeDo
 */
@WebServlet("/admin_add_foodType_do")
public class AdminAddFoodTypeDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddFoodTypeDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String tName= request.getParameter("ftn");
		FoodType foodtype = new FoodType();
		String msg = "添加菜品分类失败！";
		try {
			int result = foodtype.addFoodTypeAct(tName);
			if(result == 1){
				msg = "添加菜品分类成功!";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String href = request.getContextPath()+"/admin_list_foodType";
		request.setAttribute("msg", msg);
		request.setAttribute("href", href);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
