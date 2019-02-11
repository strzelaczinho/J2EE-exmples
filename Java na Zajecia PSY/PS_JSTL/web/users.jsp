<%-- 
    Document   : users
    Created on : Jun 20, 2018, 11:59:45 PM
    Author     : adam
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <style>
.center {
    margin: auto;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
    background-color: #DC143C;
}
body {
    background-color: #FFE4C4;
}
</style>
</head>


<body>
     <div class="center">
  <p><b>Note: </b>Using margin:auto will not work in IE8, unless a !DOCTYPE is declared.</p>

Dodaj użytkownika<br/>
<form action="Z_JSP">
    Twoje imie:<input type="text" name="imie"/><br>
    Twoja nazwisko:<input type="text" name="nazwisko"/><br>
    Twoj Adres:<input type="text" name="adres"/><br>
    Twoj Telefon:<input type="text" name="telefon"/><br>
    Twoj Email:<input type="text" name="email"/><br>
    <input type="submit" name="send" value="Wyslij"/>
</form>
<c:forEach items="${zmiennaKontekstu}" var="uzytkownik" >
    TWOJE ID: ${uzytkownik.getId()}<br>
    TWOJE Imię: ${uzytkownik.getImie()}<br>
    TWOJE Nazwisko: ${uzytkownik.getNazwisko()}<br>
    TWOJ Adres: ${uzytkownik.getAdres()}<br>
    TWOJ Telefon: ${uzytkownik.getTelefon()}<br>
    TWOJ Email: ${uzytkownik.getEmail()}<br>
</c:forEach>
    </div>
</body>
</html>