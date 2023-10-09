<%-- 
    Document   : newjsp
    Created on : Oct 8, 2023, 11:02:44 AM
    Author     : vuduc
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Điểm danh sinh viên</title>
</head>
<body>
    <h1>Danh sách sinh viên</h1>
    <table border="1">
        <tr>
            <th>No</th>
            <th>Group</th>
            <th>Code</th>
            <th>Name</th>
            <th>Image</th>
            <th>Status</th>
            <th>Comment</th>
            <th>Taker</th>
            <th>Record Time</th>
        </tr>
        <% 
            List<Student> students = ${list}
            int no = 1;
            for (Student student : students) {
        %>
        <tr>
            <td><%= no++ %></td>
            <td><%= student.getGroupName() %></td>
            <td><%= student.getStudentCode() %></td>
            <td><%= student.getStudentName() %></td>
            <td><img src="<%= student.getImageUrl() %>" alt="<%= student.getStudentName() %>"></td>
            <td><%= student.getStatus() %></td>
            <td><%= student.getComment() %></td>
            <td><%= student.getTaker() %></td>
            <td><%= student.getRecordTime() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
