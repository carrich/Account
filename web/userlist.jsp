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

    StudentModel studentModel = new StudentModel();
    List<Student> list = new ArrayList<Student>();
    list = studentModel.getListByUser();

%>
<html>
<head>
    <title>List Student</title>
</head>
<body>
    <h1>List Student</h1>
    <%
       Student student = list.get(0);
       student.getUsername();
    %>
   

    <ul>
        <% for(int i = 0; i < list.size(); i++){%>
            <li><%= list.get(i).getFullName()%> - <%= list.get(i).getUsername()%></li>
        <%}%>
    </ul>
</body>
</html>
