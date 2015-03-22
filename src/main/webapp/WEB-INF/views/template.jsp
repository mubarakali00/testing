<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<header>
        <jsp:include page="header.jsp"/>
    </header>
    <jsp:include page="${partial}"/>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</body>
</html>