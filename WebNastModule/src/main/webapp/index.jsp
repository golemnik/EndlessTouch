<%@ page import="com.anast.exp.webnastmodule.beans.ResultsBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Object o = request.getAttribute("res"); %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="interactive.js"></script>
<%--    <script src="validator.js"></script>--%>
    <script src="graph.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css">



</head>
<body>

<div class="epic">
    <table class="paragraph">
        <tr>
            <td>
                <h1><%= "ФИО: Петрова Анастасия Александровна" %></h1>
                <h2><%= "Вариант: 29788" %></h2>
                <h3><%= "Группа: P3219" %></h3>
                <br/>
            </td>
        </tr>
    </table>
</div>

<form action="area-check" method="post" name="form" >

    <table >
        <tr>
            <td>Введите X-координаты:</td>
            <td>
                <input type="button" style="background-color: #f8f8f8;" name="xb" required value="-4">
                <input type="button" style="background-color: #fcfcfc;" name="xb" required value="-3">
                <input type="button" style="background-color: #f8f8f8;" name="xb" required value="-2">
                <input type="button" style="background-color: #fcfcfc;" name="xb" required value="-1">
                <input type="button" style="background-color: #ffffff;" name="xb" required value="0">
                <input type="button" style="background-color: #ffffff;" name="xb" required value="1">
                <input type="button" style="background-color: #f8f8f8;" name="xb" required value="2">
                <input type="button" style="background-color: #fcfcfc;" name="xb" required value="3">
                <input type="button" style="background-color: #ffffff;" name="xb" required value="4">
                <label>x = <input type="text" name="x" value="1" required></label> <br>
            </td>
        </tr>
        <tr>
            <td>Введите Y-координату (-3...3):</td>
            <td>
                <%--@declare id="y"--%><label for="y">y =</label>
                <input type="text" name="y" value="1" pattern="^(-?[1-3])|(0)|(-?[0-3]\.[1-9]+)|(-?[0-3]\.[0]+\d*[1-9]+)$">
            </td>
        </tr>

        <tr>
            <td>Введите значение R: </td>
            <td>
                <label for="rValue"></label><select id="rValue" name="r" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" style="background-color: lightblue; color: #3d0479 ; border-radius: 10px;"> Отправить </button>
            </td>
        </tr>

    </table>

    <canvas id="canvas" width="600" height="600">

        <script>
            const canvas = document.getElementById("canvas");
            let r = (canvas.width+canvas.height)/25;
            const arr = <%
            if(o instanceof  ResultsBean)
                out.print(ResultsBean.jsArray(((ResultsBean)o)));
            else
                out.print("[]"); %>;

            draw(arr,r);
        </script>
    </canvas>
</form>
<%--    <p> x: <%= request.getAttribute("x")%> </p>--%>
<%--    <p> y: <%= request.getAttribute("y")%> </p>--%>
<%--    <p> r: <%= request.getAttribute("r")%> </p>--%>
<%--    <p> area: <%= request.getAttribute("area")%> </p>--%>
<table border="1px">

    <tr>
        <td>X</td>
        <td>Y</td>
        <td>R</td>
        <td>Hit</td>
        <%--        <td>Time</td>--%>
        <%--        <td>Scripted</td>--%>
    </tr>
    <%
        if (request.getAttribute("res") instanceof ResultsBean) {
            ResultsBean res = (ResultsBean) request.getAttribute("res");
            if (!res.getResults().isEmpty()) {
                for(int i = 0; i < res.getResults().size(); i++){
                    out.println("<tr>");
                    out.println("<td>" + res.getResults().get(i).getX() + "</td>");
                    out.println("<td>" + res.getResults().get(i).getY() + "</td>");
                    out.println("<td>" + res.getResults().get(i).getR() + "</td>");
                    out.println("<td>" + res.getResults().get(i).isInArea() + "</td>");
                    out.println("</tr>");
                }
            }
        }

    %>


</table>

<form action="area-check" method="post" >
    <input type="hidden" name="clear" value="true">
    <button type="submit" style="background-color: lightblue; color: #3d0479;  border-radius: 10px;">Очистить</button>



</form>



<div class="petal1"></div>
<div class="petal2"></div>
<div class="petal3"></div>


<script src="validator.js"></script>
</body>
</html>