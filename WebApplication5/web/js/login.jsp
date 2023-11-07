<%-- 
    Document   : login
    Created on : Oct 16, 2023, 7:57:34 AM
    Author     : vuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <%
            if(request.getAttribute("error")!=null){
            String er=(String)request.getAttribute("error");
            
        %>
        <h3 style="color :red"><%= er %></h3>
        <%
            }
            
        %>
        <form action="login" method="POST">
            Username:<input type="text" name="user"/><br/>
            pass:<input type="password" name="pass"/><br/>
            <input type="submit" value="login"/><br/>
                    </form>

    </body>
</html>
