<html>
<head><title>JVM Hang Counter Lab</title></head>
<body>
<form action="./counterServlet">
<%
Object count = session.getAttribute("count");
if(count != null) out.println("Count = " + count);
%>
<input type="submit" value="count"> 
</form>
</body>
</html>