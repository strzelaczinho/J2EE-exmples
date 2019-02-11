<%--
  Created by IntelliJ IDEA.
  User: skrzy
  Date: 17.06.2018
  Time: 07:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<%
    String message = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("message")) message = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
%>
<h3>Login Success</h3>
<h4><%=message%></h4>
<h4>Session ID = <%=sessionID %></h4>
<br><br>
<form action="Logout" method="post">
    <input type="submit" value="Logout" >
</form>
</body>
</html>
