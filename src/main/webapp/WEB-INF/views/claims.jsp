<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />" ></script>
	<title>Testing of master details working:</title>
</head>
<body>
<form:form id="form" action="claim" method="POST" commandName="claim_create">

	<form:input path="admissionId"/> <br/>
	<form:input path="memberName"/> <br/>
	
	<label></label>
	
	<table id="childTable" border="1px">
	<tr>
		<th> Name </th>
		<th> Father Name </th>
		<th> Age </th>
		<th> Remarks </th>
	</tr>
	 <%-- <c:set var="myRequestModel" value="${ claim_create.personalInfoList }" scope="request" /> --%>
	<%--<jsp:include page="partial/personal_info.jsp">
		<jsp:param value="myRequestModel" name="model" />
	</jsp:include> --%>

	<c:forEach items=" ${personalInfo}" varStatus= "current" >
		<tr>
			<td> ${current.name } </td>
			<td> ${current.fatherName} </td>
			<td> ${current.age} </td>
			<td> ${current.remarks} </td>
	    </tr>
	</c:forEach>
	<tr>
		
		<td colspan="4"> 
		<input type="submit" id="addRow" value="Add Row" /> 
		<%-- <form:hidden id="childIndex" path="myRequestModel" /> --%>
		<input type="hidden" id="childIndex" value="${ fn:length ( claim_create.personalInfoList ) }" />
		
		
		</td>
	</tr>
	</table>
	<br />
</form:form>
<script type="text/javascript">

$("#addRow").on('click', function (e) {
    var childTable = $("table#childTable");
    var tableIndex = $("#childIndex").val();
    var childTableIndex = parseInt(tableIndex);
    alert( childTableIndex );
    e.preventDefault();

    $.get("/claim/getChildRow", { index: childTableIndex }, function (data) {

        childTable.append(data);
        $("#childIndex").val(childTableIndex + 1);
    });
});
</script>
</body>
</html>