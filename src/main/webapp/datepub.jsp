<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.DateTimeException" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: obarbagiannidou
  Date: 9/7/2024
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Current Date</title>
</head>
<body>
    <%

        //Instance of datetime now
        LocalDateTime now = LocalDateTime.now();
        //Defining the pattern of datetime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //Convert date to string
        String formattedNow = now.format(formatter);

        //"vehicle" of data from java to jsp
        //like Hashmap: key = "now", value = formattedNow
        pageContext.setAttribute("now", formattedNow);
    %>

    <h1>
        <%= pageContext.getAttribute("now")%>
    </h1>

    <h1>
        ${pageScope.now}
    </h1>
</body>
</html>
