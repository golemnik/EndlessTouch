<%@ page import="com.golem.tech.stuff.ResultTable" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <script src="js/draw.js"></script>
  <link rel="stylesheet" href="css/main.css">
</head>
<body>
<h1><%= "Hello World!" %></h1>

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
      <script>
        document.querySelectorAll("input[name=xb]").forEach((but) => but.addEventListener("click", function () {
          document.querySelector("input[name=x]").value = but.value
        }));
      </script>
    </div>
    <div class="y">
      <input  type="text" name="y_in" required="" placeholder="-3 ... 3" value="1" pattern="^(-?[1-3])||(0)$"> <br>
      <label class="linp">y = <input class="inp" type="text" name="y" value="1" pattern="^(-?[1-3])||(0)$" readonly ></label> <br>
      <%--        <input type="button" name="yb" required="" value="set">--%>
      <script>
        document.querySelector("input[name=y_in]").addEventListener("input", function () {
          document.querySelector("input[name=y]").value = document.querySelector("input[name=y_in]").value
        });
      </script>
    </div>
    <div class="r">
      <input type="button" name="rb" required="" value="1">
      <input type="button" name="rb" required="" value="2">
      <input type="button" name="rb" required="" value="3"> <br>
      <input type="button" name="rb" required="" value="4">
      <input type="button" name="rb" required="" value="5"> <br>
      <label class="linp">r = <input class="inp" type="text" name="r" value="1" readonly ></label> <br>
      <script>
        document.querySelectorAll("input[name=rb]").forEach((but) => but.addEventListener("click", function () {
          document.querySelector("input[name=r]").value = but.value
        }));
      </script>
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
      const can = document.querySelector("canvas");
      const r = (can.width+can.height)/25; //need nearby 80px for r
      can.addEventListener('click', function (event) {
        let xx = Math.round((event.pageX - can.offsetLeft - can.width/2)/r);
        let yy = -(event.pageY - can.offsetTop - can.height/2)/r;
        if(xx > 4 || xx < -4) {
          alert("x is out of range");
        }
        else {
          if (yy > 5 || yy < -5) {
            alert("y is out of range");
          }
          else {
            document.querySelector("input[name=x]").value = xx;
            document.querySelector("input[name=y]").value = yy;
            document.querySelector("input[name=r]").value = 1;
            document.forms["forma"].submit();
          }
        }
      });
      draw(
              <%
                String dr = "[";
                Object o = request.getAttribute("table");
                if (o instanceof ResultTable) {
                  ResultTable table = (ResultTable) o;
                  if (!table.getResults().isEmpty()) {
                    for(int i = 0; i < table.getResults().size(); i++){
                      dr += "{"
                              + "x:" + table.getResults().get(i).x()
                              + ",y:" + table.getResults().get(i).y()
                              + ",r:" + table.getResults().get(i).r()
                              + "},";
                    }
                  }
                }
                dr += "]";
                out.print(dr);
              %>, r
      );
    </script>
  </canvas>
</div>

<div class="res">
  <table >
    <tr>
      <td>X</td>
      <td>Y</td>
      <td>R</td>
      <td>Hit</td>
      <td>Time</td>
      <td>Scripted</td>
    </tr>
    <%
      o = request.getAttribute("table");
      if (o instanceof ResultTable) {
        ResultTable table = (ResultTable) o;
        if (!table.getResults().isEmpty()) {
          for(int i = 0; i < table.getResults().size(); i++){
            out.println("<tr>");
            out.println("<td>" + table.getResults().get(i).x() + "</td>");
            out.println("<td>" + table.getResults().get(i).y() + "</td>");
            out.println("<td>" + table.getResults().get(i).r() + "</td>");
            out.println("<td>" + table.getResults().get(i).hit() + "</td>");
            out.println("<td>" + "</td>");
            out.println("<td>" + "</td>");
            out.println("</tr>");
          }
        }
      }
    %>
  </table>
</div>

</body>
</html>