<%--
  Created by IntelliJ IDEA.
  User: lishunpu
  Date: 2017/6/23
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
    <title>WebSocket</title>
    <script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function() {
            connect();
            $("#btn").click(function() {
                var value = $("#message").val();
                $.ajax({
                    url : "longpolling?method=onMessage&msg=" + value,
                    cache : false,
                    dataType : "text",
                    success : function(data) {
//                        alert(data);
                    }
                });
            });
        });
        function connect() {
            $.ajax({
                url : "longpolling?method=onOpen",
                cache : false,
                dataType : "text",
                success : function(data) {
                    connect();
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
<h1>LongPolling</h1>
<input type="text" id="message" />
<input type="button" id="btn" value="发送" />
</body>
</html>