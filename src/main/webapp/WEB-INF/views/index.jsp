<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Home Page">

    <jsp:attribute name="header">
      	<h1>Welcome to the generic header...</h1>
    </jsp:attribute>
    
    <jsp:body>
		<a href="<c:url value='/claim'/>"> Claims page </a><br/>
		<a href="<c:url value='/hospital'/>"> Hospital page </a>
	</jsp:body>
	
</t:genericpage>