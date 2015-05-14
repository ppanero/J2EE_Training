<%--
  Created by IntelliJ IDEA.
  User: Light
  Date: 14/05/15
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example Java Server Pages</title>
</head>
<body>
<div><p>This is the body of the Java Server Pages Example</p></div>
<%
    int i=0;
    for(; i < 3; ++i){
        out.println("<div><p>Example of java rendered content with i = " + i + "</p></div>");
    }
%>
<div><p>This is static content with Dynamic content, that still has access to i <%=i %></p></div>

<div><p>A JSP is converted to s Servlet automatically (a java class) and then is executed</p></div>
<%!
    public int add(int n, int m){
        return n+m;
    }
%>
<div><p>Now we are using the function defined previously with 3 + 4 =
    <%
        int k=add(3,4);
    %>
    <%=k%>
</p></div>



</body>
</html>
