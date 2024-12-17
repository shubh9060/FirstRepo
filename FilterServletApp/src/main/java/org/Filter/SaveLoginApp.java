package org.Filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saveLogin")
public class SaveLoginApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rdd;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection dConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ss", "root", "Shubh@m");
			System.out.println("Yess");
			if (dConn != null) {

				PreparedStatement pStmt = dConn.prepareStatement("Insert into UserTable values('0',?,?)");
				pStmt.setString(1, request.getParameter("username"));//Dhananjay
				pStmt.setString(2, request.getParameter("password"));//Dhan@123
//				if (pStmt.executeUpdate() > 0) {
//						rdd = request.getRequestDispatcher("login.jsp");
//						rdd.include(request, response);
//				} else {
//					rdd = request.getRequestDispatcher("login.jsp");
//						rdd.include(request, response);
//				}
			} else {
				System.out.println("Connection Not Established.................!");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error Genereated when we Connetion Established in Save Process:" + e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
