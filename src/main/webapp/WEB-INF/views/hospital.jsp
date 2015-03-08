<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form id="form" action="hospital" method="POST" commandName="hospital_create">

	<label>Input the required information and click register</label>
	<table>
		<tr>
			<td><spring:message code="hospital.label.name"/></td>
			<td><form:input type="text" path="hospitalName" /> </td>
		</tr>
	</table>
			<input type="submit" value="Register" />
	</form:form>
	
</body>
</html>