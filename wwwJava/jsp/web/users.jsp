<%--
  Created by IntelliJ IDEA.
  User: skrzy
  Date: 17.06.2018
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>


<body>
Dodaj użytkownika<br/>
<form action="FromJSP">
    Imie:<input type="text" name="name"/><br>
    Nazwisko:<input type="text" name="surname"/><br>
    Adres:<input type="text" name="address"/><br>
    Telefon:<input type="text" name="telephone"/><br>
    Email:<input type="text" name="email"/><br>
    <input type="submit" name="send" value="Wyslij"/>
</form>
<c:forEach items="${users}" var="user" >
    ID: ${user.getId()}<br>
    Imię: ${user.getName()}<br>
    Nazwisko: ${user.getSurname()}<br>
    Adres: ${user.getAddress()}<br>
    Telefon: ${user.getTelephone()}<br>
    Email: ${user.getEmail()}<br>
</c:forEach>
</body>
</html>
