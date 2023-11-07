<%-- 
    Document   : add
    Created on : Oct 15, 2023, 8:35:37 PM
    Author     : vuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 style="color : red">${requestScope.error} </h3> 
        <form action="add">
          <br>ID:  <input type="number" name="id"/> </br>
           <br> Name: <input type="text" name="name"/></br>
           <br>Gender: <input type="radio" value="male" name="gender"/> Male
            <input type="radio" value="female" name="gender"/> Female <br/>
         <br> Dob: <input type="date" name="dob" /> <br/>
            <br><input type="submit" value="Send"/><br/>
        </form>
    </body>
</html>
