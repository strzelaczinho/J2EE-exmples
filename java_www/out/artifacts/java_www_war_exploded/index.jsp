<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 24.05.18
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Programowanie WWW w Java</title>
  </head>
  <body>
    <ul>
      <li><a href="session">Sesje</a>
        <ul>
          <li>
            <form method="POST" action="session">
              <input type="text" name="name" placeholder="Wpisz swój login" />
              <input type="submit" value="Zaloguj" />
            </form>
          </li>
          <li><a href="session">Wyświetl zalogowanych użytkowników</a></li>
        </ul>
      </li>
      <li>Ciasteczka
        <ul>
          <li><a href="cookies1">Servlet1</a> - Ustawienie ciasteczek i przekierowanie do servlet2.</li>
          <li><a href="cookies2">Servlet2</a> - Wyświetlenie wszystkich ciasteczek.</li>
          <li><a href="cookies-zadanie">Zadanie</a></li>
        </ul>
      </li>
      <li>Atrybuty aplikacji
        <ul>
          <li>
            <form action="atrybuty" method="POST">
              <input type="text" name="imie" placeholder="Imię" />
              <input type="text" name="nazwisko" placeholder="Nazwisko" />
              <input type="submit" value="Dodaj do listy" />
            </form>
          </li>
          <li><a href="atrybuty2">Servlet2</a> - Wyświetlenie całej listy.</li>
        </ul>
      </li>
      <li><a href="parametry">Parametry inicjalizujące</a> - tylko dla zalogowanych</li>
      <li><a href="lista">Klasy nasłuchujące</a></li>
      <li><a href="jstl">JSTL</a></li>
    </ul>
  </body>
</html>
