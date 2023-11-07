<%-- 
    Document   : date
    Created on : Nov 6, 2023, 7:42:58 AM
    Author     : vuduc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/custom-tags/date-tag.tld" prefix="may" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Current Date</title>
</head>
<body>
    <may:VNDate value="${now}"/>
</body>
</html>
