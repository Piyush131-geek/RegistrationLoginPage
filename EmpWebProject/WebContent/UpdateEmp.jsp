<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateEmployee</title>
</head>
<body>
<jsp:include page="HRHomePage.jsp" />

<form action="UpdateEmp" method="post" align="center">
<center>
	<h3> Update Employee </h3>

	<table>
		<tr>
			<td align="right"> EmpId </td>
			<td align="left"> <input type="text" name="empId" value="${emp.empId}" readonly/> </td>
		</tr>
		
		<tr>
			<td align="right"> Name </td>
			<td align="left"> <input type="text" name="empName" value="${emp.empName}" /> </td>
		</tr>
		
		<tr>
			<td align="right"> Salary </td>
			<td align="left"> <input type="text" name="salary" value="${emp.salary}" /> </td>
		</tr>
		
		<tr>
			<td align="right"> Gender </td>
			<td align="left"> <input type="text" name="gender" value="${emp.gender}" /> </td>
		</tr>
		
		<tr>
			<td align="right"> Email-Id </td>
			<td align="left"> <input type="text" name="emailId" value="${emp.emailId}" readonly/> </td>
		</tr>
		
		<tr>
			<td align="right"> Password </td>
			<td align="left"> <input type="password" name="password" value="${emp.password}"/> </td>
		</tr>
		
		<tr>
			<td> </td>
			<td align="left"> <input type="submit" value="UpdateEmployee" /> </td>
		</tr>
		
	</table>
</center>	
</form>
</body>
</html>