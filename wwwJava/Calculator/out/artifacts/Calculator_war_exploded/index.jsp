<%--
  Created by IntelliJ IDEA.
  User: skrzy
  Date: 28.03.2018
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Kalkulator</title>
  </head>
  <body>
    <h1>Kalkulator</h1>
    <form action="Calculator" method="get">
      <p>Podaj pierwsza liczbe:<input type="number" step="any" name="numberOne"/></p>
      <p>Podaj druga liczbe:<input type="number" step="any" name="numberTwo"/></p>
      <p>Wybierz dzialanie:</p>
      <p>
        <input type="radio" name="operation" value="addition" checked/> dodawanie<br>
        <input type="radio" name="operation" value="subtraction"/> odejmowanie<br>
        <input type="radio" name="operation" value="multiplication"/> mnozenie<br>
        <input type="radio" name="operation" value="division"/> dzielenie
      </p>
      <input type="submit" value="Zatwierdz"/>
    </form>
  </body>
</html>
