<%-- 
    Document   : StudentAT
    Created on : Oct 9, 2023, 6:41:11 AM
    Author     : vuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bảng dữ liệu</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #e0f2f1; /* Màu nền xanh nhạt */
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #009688; /* Màu đường viền xanh đậm */
        }
        th {
            background-color: #009688; /* Màu nền đầu bảng xanh đậm */
            color: white;
        }
        .submit-button {
            background-color: #009688; /* Màu nền nút xanh đậm */
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            float: right; /* Đặt nút bên phải */
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>No</th>
                <th>Group</th>
                <th>Code</th>
                <th>Name</th>
                <th>Image</th>
                <th>Status</th>
                <th>Comment</th>
                <th>Taker</th>
                <th>Recording Time</th>
            </tr>
        </thead>
        <tbody>
            <% for (int i = 1; i <= 30; i++) { %>
                <tr>
                    <td><%= i %></td>
                    <td>IOT1702</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><img width="100" height="100" src="img/OIP1.jfif" alt=""/></td>
                    <td>sonnt5</td>
                    <td></td>
                </tr>
            <% } %>
        </tbody>
    </table>
           <input type="submit" class="submit-button" value="Submit" href="https://www.example.com">
</body>
</html>

