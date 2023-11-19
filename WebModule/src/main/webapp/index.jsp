<%@ page import="com.golem.tech.stuff.ResultTable" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%Object o = request.getAttribute("table"); %>
<!DOCTYPE html>
<html>
<head>
  <title>Lab 2</title>
  <script src="js/draw.js"></script>
  <script src="js/main.js"></script>
  <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div>
  <details>
    <summary>
      Lab 2's author:
    </summary>
    Создатель: Кокорев Михаил Дмитриевич <br>
    Группа: З219 <br>
    Вариант: 29784 <br>
  </details>
  <br>
</div>
<div class="forma">
  <form id="forma" action="Control" method="get" onsubmit="check()">
    <div class="x">
      <input type="button" name="xb" required="" value="-4">
      <input type="button" name="xb" required="" value="-3">
      <input type="button" name="xb" required="" value="-2"> <br>
      <input type="button" name="xb" required="" value="-1">
      <input type="button" name="xb" required="" value="0">
      <input type="button" name="xb" required="" value="1"> <br>
      <input type="button" name="xb" required="" value="2">
      <input type="button" name="xb" required="" value="3">
      <input type="button" name="xb" required="" value="4"> <br>
      <label class="linp">x = <input class="inp" type="text" name="x" value="1" readonly ></label> <br>
    </div>
    <div class="y">
      <input  type="text" name="y_in" required="" placeholder="-5 ... 5" value="1" pattern="^(-?[1-5])|(0)|(-?[0-5]\.[1-9]+)|(-?[0-5]\.[0]+\d*[1-9]+)$"> <br>
      <label class="linp">y = <input class="inp" type="text" name="y" value="1" pattern="^(-?[1-5])|(0)|(-?[0-5]\.[1-9]+)|(-?[0-5]\.[0]+\d*[1-9]+)$" readonly ></label> <br>
    </div>
    <div class="r">
      <input type="button" name="rb" required="" value="1">
      <input type="button" name="rb" required="" value="2">
      <input type="button" name="rb" required="" value="3"> <br>
      <input type="button" name="rb" required="" value="4">
      <input type="button" name="rb" required="" value="5"> <br>
      <label class="linp">r = <input class="inp" type="text" name="r" value="1" readonly ></label> <br>
    </div>
    <div class="sub">
      <button type="submit">request</button>
    </div>
  </form>
  <form action="Control" method="get">
    <div class="sub">
      <input name="reset" type="text" value="true" hidden>
      <button type="submit">reset</button>
    </div>
  </form>
</div>

<div class="can">
  <canvas id="canvas" width="600" height="600">
    <script>
      const canvas = document.getElementById("canvas");
      let r = (canvas.width+canvas.height)/25;
      // canv();
      const arr = <% if(o instanceof ResultTable) out.print(ResultTable.jsGraph(((ResultTable)o).getResults())); else out.print("[]"); %>;
      draw(arr, r);
    </script>
  </canvas>
</div>

<div class="res">
  <form>
    <table id="res">
      <tr>
        <td>X</td>
        <td>Y</td>
        <td>R</td>
        <td>Hit</td>
        <td>Time</td>
        <td>Scripted</td>
      </tr>
      <% if(o instanceof ResultTable) out.print( ResultTable.htmlTable(((ResultTable)o).getResults())); %>
    </table>
  </form>
  <script>
    dott (arr);
  </script>
</div>
</body>
</html>