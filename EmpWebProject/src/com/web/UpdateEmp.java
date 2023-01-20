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

@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setGender(gender);
		emp.setEmailId(emailId);
		emp.setPassword(password);
		
		EmployeeDAO empDAO = new EmployeeDAO();
		int result = empDAO.updateEmployee(emp);
		
		if (result > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("GetEmployees");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("GetEmployees");
			rd.include(request, response);
			
			out.print("<center>");
			out.print("<h1 style='color:red;' script='alert(Record Updation Failed!!!);'> Record Updation Failed!!! </h1>");
			out.print("</center>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
