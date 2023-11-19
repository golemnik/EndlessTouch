<%@ page import="com.golem.math.webmathmodule.calculations.Calculations" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Calculations calc = new Calculations(); %>
<!DOCTYPE html>
<html>
<head>
  <title>Math stat</title>
</head>
<body>
  <h1>Var 9, Kokorev</h1>
  <br/>
  <p>Данные: <%out.print(calc.getSeries()); %> </p>
  <p>Вариационный ряд: <%out.print(calc.variationSeries()); %> </p>
  <p>Частоты: <%out.print(calc.frequencies()); %> </p>
  <p>Минимум: <%out.print(calc.extremeMin()); %> </p>
  <p>Максимум: <%out.print(calc.extremeMax()); %> </p>
  <p>Математическое ожидание: <%out.print(calc.mathExpectation()); %> </p>
  <p>Квадратичное отклонение: <%out.print(calc.standardDeviation()); %> </p>
  <img src="graph?type=1" alt="нет графика">
  <img src="graph?type=2" alt="нет графика">
  <br>
  <img src="graph?type=3" alt="нет графика">
  <img src="graph?type=4" alt="нет графика">
</body>
</html>

<% %>