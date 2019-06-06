<%@ page import="com.t1708m.entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.t1708m.model.StudentModel" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-05-28
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


    HttpSession session1 = request.getSession();
    Student student = (Student) session1.getAttribute("currentLogin");

%>
<html>
<head>
    <title>List Student</title>
</head>
<body>
    UserName:<%=student.getUsername()%>
    Fullname:<%=student.getFullName()%>
    Address:<%=student.getAddress()%>
    Email:<%=student.getEmail()%>
    Phone:<%=student.getPhone()%>

   


</body>
</html>
