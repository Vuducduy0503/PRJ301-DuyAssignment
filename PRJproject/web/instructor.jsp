<%-- 
    Document   : instructor
    Created on : Nov 7, 2023, 7:33:03 PM
    Author     : duchi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>


    <body>
        <h1>Choose Instructor</h1>

        <form action="Instructor" method="post">
            <label for="items">Select Instructor:</label>
            <select name="selectedItem" id="items">
                <c:forEach items="${instructors}" var="item">
                    <option  value="${item.id}">${item.name}</option>
                </c:forEach>
            </select>
            <br>
            
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
