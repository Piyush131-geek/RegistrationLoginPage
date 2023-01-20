package com.EmpDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.MyConnection;
import com.model.Employee;

public class EmployeeDAO {

	public Employee getEmployee(String emailId, String password) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		con = MyConnection.getConnection();

		try {
			pst = con.prepareStatement("select * from employee where emailId=? and password=?");
			pst.setString(1, emailId);
			pst.setString(2, password);
			rs = pst.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();

				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
				emp.setEmailId(rs.getString(5));
				emp.setPassword(rs.getString(6));

				return emp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int registerEmployeee(Employee emp) {

		Connection con = null;
		PreparedStatement pst = null;

		con = MyConnection.getConnection();

		String insertQuery = "insert into employee (empName, salary, gender, emailId, password) values (?, ?, ?, ?, ?)";

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, emp.getEmpName());
			pst.setDouble(2, emp.getSalary());
			pst.setString(3, emp.getGender());
			pst.setString(4, emp.getEmailId());
			pst.setString(5, emp.getPassword());

			int result = pst.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Employee> getEmployees() {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Employee> empList = new ArrayList<Employee>();
		
		con = MyConnection.getConnection();

		try {
			pst = con.prepareStatement("select * from employee");
			rs = pst.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Employee emp = new Employee();
					
					emp.setEmpId(rs.getInt(1));
					emp.setEmpName(rs.getString(2));
					emp.setSalary(rs.getDouble("salary"));
					emp.setGender(rs.getString("gender"));
					emp.setEmailId(rs.getString(5));
					emp.setPassword(rs.getString(6));
					
					empList.add(emp);
				}
				
				return empList;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public Employee getEmpById(int empId) {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		con = MyConnection.getConnection();

		try {
			pst = con.prepareStatement("select * from employee where empId=?");
			pst.setInt(1, empId);
			rs = pst.executeQuery();

			if (rs.next()) {
				Employee emp = new Employee();

				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getDouble("salary"));
				emp.setGender(rs.getString("gender"));
				emp.setEmailId(rs.getString(5));
				emp.setPassword(rs.getString(6));

				return emp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				rs.close();
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int updateEmployee(Employee emp) {
		Connection con = null;
		PreparedStatement pst = null;
		con = MyConnection.getConnection();
		String insertQuery = "update employee set empName=?, salary=?, gender=?, password=? where empId=?";

		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, emp.getEmpName());
			pst.setDouble(2, emp.getSalary());
			pst.setString(3, emp.getGender());
			pst.setString(4, emp.getPassword());
			pst.setInt(5, emp.getEmpId());

			int result = pst.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteEmployee(int empId) {

		Connection con = null;
		PreparedStatement pst = null;
		con = MyConnection.getConnection();
		String deleteQuery = "delete from employee where empId=?";

		try {
			pst = con.prepareStatement(deleteQuery);
			pst.setInt(1, empId);

			int result = pst.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
















