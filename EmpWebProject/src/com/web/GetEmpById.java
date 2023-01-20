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
import com.model.Employee;

@WebServlet("/GetEmpById")
public class GetEmpById extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int empId = Integer.parseInt(request.getParameter("empId"));

		EmployeeDAO empDAO = new EmployeeDAO();
		Employee emp = empDAO.getEmpById(empId);

		if (emp != null) {
			request.setAttribute("emp", emp);
			RequestDispatcher rd = request.getRequestDispatcher("GetEmployee.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("HRHomePage.jsp");
			rd.include(request, response);
			
			out.print("<center>");
			out.print("<h1 style='color:red;'> Employee Record Not Found!!! </h1>");
			out.print("</center>");
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
