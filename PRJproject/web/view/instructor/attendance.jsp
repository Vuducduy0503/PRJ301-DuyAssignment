<%-- 
    Document   : attendance
    Created on : Oct 29, 2023, 11:04:09 PM
    Author     : vuduc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Attendance Check </h1>

        <p style="margin: 0; font-size: 20px;">Group Name: ${session.groupName} </p> 
        <p style="margin: 0; font-size: 20px;">Subject Name: ${session.subjectName} </p> 
        <p style="margin: 0; font-size: 20px;">Room: ${session.room} </p> 
        <p style="margin: 0; font-size: 20px;">Slot: ${session.timeId} </p>

        <br/>
        <form action="Attendance" method="POST">
            <table border="1px"> 
                <tr>
                    <td>Student</td>
                    <td>Status</td>
                    <td>Description</td>
                    <td>Time</td>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.name}
                            <input type="hidden" name="stuid" value="${a.student.id}"/>
                        </td>
                        <td>
                            <input type="radio"
                                   <c:if test="${!a.status}">
                                       checked="checked"
                                   </c:if>
                                   name="status${a.student.id}" value="absent"/>absent
                            <input type="radio"
                                   <c:if test="${a.status}">
                                       checked="checked"
                                   </c:if>
                                   name="status${a.student.id}" value="present"/>present
                        </td>
                        <td>
                            <input type="text" value="${a.description}"
                                   name="description${a.student.id}"/>
                        </td>
                        <td>${a.datetime}</td>
                    </tr>   

                </c:forEach>
            </table>
            <input type="hidden" value="${session.sessionId}" name="sesid"/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
