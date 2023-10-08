<%-- 
    Document   : newjsp
    Created on : Oct 7, 2023, 9:04:13 PM
    Author     : vuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thời Khóa Biểu</title>
</head>
<body>
    <h1>Thời Khóa Biểu</h1>
    
    <!-- Form để chọn năm và tuần -->
    <form method="post" action="processSchedule.jsp">
        <label for="year">Năm:</label>
        <select name="year" id="year">
            <!-- Thêm các option cho năm (ví dụ: 2023, 2024, ...) -->
            <option value="2023">2023</option>
            <option value="2024">2024</option>
            <!-- Thêm các năm khác nếu cần -->
        </select>
        <label for="week">Tuần:</label>
        <select name="week" id="week">
            <!-- Thêm các option cho tuần (ví dụ: Tuần 1, Tuần 2, ...) -->
            <option value="1">Tuần 1</option>
            <option value="2">Tuần 2</option>
            <!-- Thêm các tuần khác nếu cần -->
        </select>
        <input type="submit" value="Xem Thời Khóa Biểu">
    </form>
    
    <!-- Bảng thời khóa biểu -->
    <table border="1">
        <tr>
            <th>Year</th>
            <th>Week</th>
            <th>Thứ Hai</th>
            <th>Thứ Ba</th>
            <th>Thứ Tư</th>
            <th>Thứ Năm</th>
            <th>Thứ Sáu</th>
            <th>Thứ Bảy</th>
            <th>Chủ Nhật</th>
        </tr>
        <!-- Dòng cho các slot từ 1 đến 7 -->
        <tr>
            <td rowspan="7"><%= request.getParameter("year") %></td>
            <td rowspan="7"><%= request.getParameter("week") %></td>
            <td>Slot 1</td>
            <td>Slot 1</td>
            <td>Slot 1</td>
            <td>Slot 1</td>
            <td>Slot 1</td>
            <td>Slot 1</td>
            <td>Slot 1</td>
        </tr>
        <!-- Thêm các dòng cho các slot khác -->
        <!-- Ví dụ: Slot 2, Slot 3, ... -->
    </table>
</body>
</html>
