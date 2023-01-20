<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.model.Employee, java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> GetEmployees </title>

<style> 
	table, th, td {
		border: 1px solid black;  
		border-collapse: collapse; 
	} 
</style>

</head>


<body bgcolor="yellow" text="blue">
<jsp:include page="HRHomePage.jsp" />
		<center>		
			<table>
		
			<tr align=center>
			<th> EmpId    </th>
			<th> Name     </th>
			<th> Salary   </th>
			<th> Gender   </th>
			<th> Email-Id </th>
			<th colspan="2" align="center"> Actions </th>
			</tr>
			
			<c:forEach var="emp" items="${empList}">
				<tr>
				<td> ${ emp.empId    } </td>
				<td> ${ emp.empName  } </td>
				<td> ${ emp.salary   } </td>
				<td> ${ emp.gender   } </td>
				<td> ${ emp.emailId  } </td>
				<td> <a href="EditEmployee?empId=${emp.empId}"> Edit </a> </td>
				<td> <a href="DeleteEmployee?empId=${emp.empId}"> Delete </a> </td>
				</tr>
				
			</c:forEach>		
			</table>
		</center>
</body>
</html>






