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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String empName = request.getParameter("empName");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		//Employee emp = new Employee(0, empName, salary, gender, emailId, password);
		Employee emp = new Employee();
		emp.setEmpName(empName);
		emp.setSalary(salary);
		emp.setGender(gender);
		emp.setEmailId(emailId);
		emp.setPassword(password);
		
		EmployeeDAO empDAO = new EmployeeDAO();
		int result = empDAO.registerEmployeee(emp);
		
		out.print("<html>");
		out.print("<body bgcolor=yellow text=blue>");
		out.print("<center>");
		
		if (result > 0) {
			out.print("<h1> Employee Registered Successfully!!! </h1>");
		} else {
			out.print("<h1 style='color:red'> Employee Registration Failed... </h1>");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
				
		out.print("</center>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
