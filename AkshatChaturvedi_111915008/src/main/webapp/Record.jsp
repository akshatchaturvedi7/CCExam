<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/ccexam?autoReconnect=true&useSSL=false";
String username="root";
String password = "Akshat0211%";
String sql ="select * from AkshatChaturvedi_111915008_detail1";

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Records</title>
</head>
<body>

<h1>Data present in Database</h1>
<table border="1">
<tr>
<td>Employee ID</td>
<td>First name</td>
<td>Last name</td>
<td>DOB</td>
<td>Contact</td>

</tr>
<%
try{
connection = DriverManager.getConnection(url, username, password);
statement=connection.createStatement();
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("Employee_ID_Number") %></td>
<td><%=resultSet.getString("First_Name") %></td>
<td><%=resultSet.getString("Last_Name") %></td>
<td><%=resultSet.getString("Date_of_Birth") %></td>
<td><%=resultSet.getString("Contact_Number") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 

	<form action="Disp.jsp" method="post">
		 Enter Employee ID : <input type="text" name="employee_id"><br>
		 <input type="submit" value="Find Details">
	</form>
</body>
</html>