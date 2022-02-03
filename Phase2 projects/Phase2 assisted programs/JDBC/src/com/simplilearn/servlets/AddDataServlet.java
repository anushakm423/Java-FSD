package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.util.DBConnection;

/**
 * Servlet implementation class ListDataServlet
 */
@WebServlet("/addProduct")
public class AddDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/ecommerce123";
		String userName = "root";
		String password = "Anusha4@";

		PrintWriter out = response.getWriter();
		out.println("<html> <body>");
		try {
			DBConnection dbConnection = new DBConnection(url, userName, password);

			Connection connection = dbConnection.getConnection();

			PreparedStatement stmt = connection.prepareStatement("insert into eproduct_25012022 (name,price) values (? , ?)");

			stmt.setString(1, "Test_Anup");
			stmt.setBigDecimal(2, new BigDecimal(15000));
			
			stmt.executeUpdate();
			
			out.println("Data inserted successfully");
			stmt.close();
			out.println("</body></html>");
			dbConnection.closeConnection();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}