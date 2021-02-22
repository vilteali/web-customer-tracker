package com.ali.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String USER = "springstudent";
		final String PASSWORD = "springstudent";
		final String JDBC_URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to dabatase: "+JDBC_URL);
			Class.forName(DRIVER);
			Connection myConnection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			
			out.println("\nSUCCES!!");
			myConnection.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
