<%-- 
    Document   : diemdanh
    Created on : Oct 17, 2023, 7:32:46 PM
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
    <h1>Điểm Danh Sinh Viên</h1>
    <form action="NewServlet1" method="post">
        Tên sinh viên: <input type="text" name="studentName" required>
        <input type="submit" value="Điểm danh">
    </form>
    <p>${message}</p>
</body>
</html>
