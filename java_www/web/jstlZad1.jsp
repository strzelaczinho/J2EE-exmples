<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Zadanie1 - JSTL</title>
</head>
<body>
Lista osób:<br>
<c:forEach items="${users}" var="user" >
    ID: ${user.getId()}<br>
    Imię: ${user.getName()}<br>
    Nazwisko: ${user.getSurname()}<br>
    Adres: ${user.getAddress()}<br>
    Telefon: ${user.getPhone()}<br>
    Email: ${user.getEmail()}<br><br>
</c:forEach>
</body>
</html>
