
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<h2>User Login</h2>

	<%
	String errorMessage = (String) request.getAttribute("errorMessage");

	if (errorMessage != null) {
	%>
	<p style="color: red;">
		<%=errorMessage%>
	</p>
	<%
	}
	%>

	<form action="<%=request.getContextPath()%>/login" method="post">

		<label>Email:</label> <input type="email" name="email" required>
		<br>
		<br> <label>Password:</label> <input type="password"
			name="password" required> <br>
		<br>

		<button type="submit">Login</button>



	</form>

</body>
</html>
