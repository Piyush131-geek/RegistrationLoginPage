package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmpDAO.EmployeeDAO;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeDAO empDAO = new EmployeeDAO();
		int result = empDAO.deleteEmployee(empId);
		
		RequestDispatcher rd = request.getRequestDispatcher("GetEmployees");
		
		if (result > 0) {
			rd.forward(request, response);
		} else {
			rd.include(request, response);
			out.print("<center>");
			out.print("<h1 style='color:red;'> Record Deletion Failed!!! </h1>");
			out.print("</center>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
