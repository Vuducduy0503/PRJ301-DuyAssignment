<%-- 
    Document   : timetable
    Created on : Oct 29, 2023, 11:03:24 PM
    Author     : vuduc
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .aclass {
                font-weight: bold;
                font-size: 30px;
                text-decoration: none;
                color: skyblue; /* Màu chữ mặc định */
                transition: color 0.3s ease; /* Thời gian và kiểu chuyển động của hiệu ứng */
            }

            .aclass:hover {
                color: blue; /* Màu chữ khi hover qua */
            }
        </style>
    </head>
    <body>
        <h1>Instructor Time Table</h1>
        <a href="Instructor" >Back To Select Instructor</a>
        <form action="TimeTable" method="GET" style="margin-bottom: 30px; margin-top: 80px;">
            Choose Date Of Week: <input type="date" name="from" value="${requestScope.from}"/>
            <input type="hidden" value="${instructorId}" name="instructorId"/>
            <input type="submit" value="View"/>
        </form>
        <table border="">
            <tr>
                <td></td>

                <!--date title begin-->
                <c:forEach items="${dates}" var="date">
                    <td>
                        <fmt:formatDate value="${date}" pattern="dd-MM-yyyy" var="formattedDate" />
                        <p>${formattedDate}</p>
                    </td>
                </c:forEach>
                <!--date title end-->

            </tr>
            <c:forEach items="${slots}" var="s">
                <tr>

                    <!--slot time start-->
                    <td>${s.description}</td>
                    <!--slot time end-->


                    <c:forEach items="${dates}" var="d">
                        <td>
                            <c:forEach items="${sessions}" var="session">

                                <c:choose>
                                    <c:when test="${session.date eq d}">
                                        <c:if test="${session.timeId eq s.id}">
                                            <div style="background-color: rgba(0,0,0,0.1); width: 150px; height: 150px; text-align: center; padding-top: 20px;">
                                                <a class="aclass" href="Attendance?sessionId=${session.sessionId}" target="_blank">
                                                    ${session.subjectName}
                                                </a>
                                                <div>
                                                    Session: ${session.index}
                                                </div>
                                                <c:forEach var="instructor" items="${instructors}">
                                                    <c:if test="${instructor.id eq session.instructorId}">
                                                        <div>
                                                            Instructor: ${instructor.name}
                                                        </div>
                                                    </c:if>
                                                </c:forEach>

                                                <div>
                                                    Room: ${session.room}
                                                </div>

                                                <div>
                                                    Class: ${session.groupName}
                                                </div>

                                                <c:if test="${session.status eq 0}">
                                                    <div style="color: gray; font-weight: bold;">
                                                        Status: NOT YET
                                                    </div>
                                                </c:if>
                                                <c:if test="${session.status eq 1}">
                                                    <div style="color: green; font-weight: bold;">
                                                        Status: ATTENDED
                                                    </div>
                                                </c:if>
                                            </div>

                                        </c:if>
                                    </c:when>
                                </c:choose>

                            </c:forEach>
                        </td>
                    </c:forEach>

                </tr>  
            </c:forEach>
        </table>
    </body>
</html>
