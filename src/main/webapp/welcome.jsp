
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Get existing session; do not create a new one
    javax.servlet.http.HttpSession userSession =
        request.getSession(false);

    // Allow access only to a logged-in user
    if (userSession == null ||
        userSession.getAttribute("username") == null) {

        response.sendRedirect(
            request.getContextPath() + "/login.jsp"
        );
        return;
    }

    String username =
        (String) userSession.getAttribute("username");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>

    <h1>Welcome, <%= username %>!</h1>

    <p>You have logged in successfully.</p>

    <form action="<%= request.getContextPath() %>/logout"
          method="post">
        <button type="submit">Logout</button>
    </form>

</body>
</html>
