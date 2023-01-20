package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EmpDAO.EmployeeDAO;
import com.model.Employee;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("emailId", emailId);
		
		out.print("<html>");
		out.print("<body bgcolor=yellow text=blue>");
		out.print("<center>");

		if(emailId.equals("HR") && password.equals("HR")) {	
			RequestDispatcher rd = request.getRequestDispatcher("HRHomePage.jsp");
			rd.forward(request, response);
		} else {

			EmployeeDAO empDAO = new EmployeeDAO();
			Employee emp = empDAO.getEmployee(emailId, password);

			if (emp != null) {
				
				//Storing employee object in the session for displaying in the profile
				session.setAttribute("emp", emp);
				
				RequestDispatcher rd = request.getRequestDispatcher("EmpHomePage.jsp");
				rd.forward(request, response);
				
			} else {
				out.print("<h1 style='color:red'> Invalid Credentials!! </h1>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}

		out.print("</center>");
		out.print("</body>");
		out.print("</html>");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
