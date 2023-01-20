package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmpDAO.EmployeeDAO;
import com.model.Employee;

@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee emp = empDAO.getEmpById(empId);
		
		request.setAttribute("emp", emp);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateEmp.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
