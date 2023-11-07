<%-- 
    Document   : list
    Created on : Oct 15, 2023, 12:27:17 PM
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
       
        <form >
            <h3><a href="js/add.jsp">add employee</a></h3> 
       <table border="2px">
           <tr>
               <th>ID</th>  
               <th>name</th>    
               <th>gender</th>    
              <th>dob</th>    
              <th>created-by</th>  
              
            </tr>
            <c:forEach items="${requestScope.data}" var="c">
                <c:set var="id" value="$(c.id)"/>
                  <tr>
               <td>${c.id}</td>  
               <td>${c.name}</td>    
               <td>${c.email}</td>    
            </tr>
               </c:forEach>     
            </table>
                    </form>

         
    </body>
</html>
