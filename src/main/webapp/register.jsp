
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>

    <h2>Create Your Account</h2>

    <form action="${pageContext.request.contextPath}/register"
          method="post">

        <div>
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>
        </div>

        <br>

        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <br>

        <div>
            <label for="password">Password:</label>
            <input type="password" id="password"
                   name="password" required minlength="8">
        </div>

        <br>

        <button type="submit">Register</button>

    </form>

</body>
</html>
