<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Claims Page">
    <jsp:attribute name="header">
      <h1>Welcome to the generic header...</h1>
    </jsp:attribute>
    
    <jsp:body>
        <form:form id="claimForm" action="claim" method="POST" modelAttribute="claim_create">

	<form:input path="admissionId"/> <br/>
	<form:input path="memberName"/> <br/>
	
	<table id="childTable" border="1px">
	<tr>
		<th> Name </th>
		<th> Father Name </th>
		<th> Age </th>
		<th> Remarks </th>
	</tr>
	<c:forEach items="${ claim_create.personalInfoList }" varStatus="i" begin="0" >
		<tr>
			<td>
				<spring:bind path="personalInfoList[${ i.index }].name">
					<form:input path="${ status.expression }" />
				</spring:bind>
			</td>
			<td>
				<spring:bind path="personalInfoList[${ i.index }].fatherName">
					<form:input path="${ status.expression }" />
				</spring:bind>
			</td>
			<td>
				<spring:bind path="personalInfoList[${ i.index }].age">
					<form:input path="${ status.expression }" />
				</spring:bind>
			</td>
			<td>
				<spring:bind path="personalInfoList[${ i.index }].remarks">
					<form:input path="${ status.expression }" />
				</spring:bind>
			</td>
		</tr>
		</c:forEach>
	</table>
	<input type="button" value="Add Row" id = "addRow" />
	<input type="hidden" value="${ fn:length(claim_create.personalInfoList) }" id="childIndex" />
	
	<br />
	<br />
	<br />
	<input type="submit" value="Save" />
</form:form>
<script type="text/javascript">

$( function() {
	$("#addRow").on('click', function (e) {
	    var childTable = $("table#childTable");
	    var tableIndex = $("#childIndex").val();
	    var childTableIndex = parseInt(tableIndex);
	    e.preventDefault();
	
	     $.get("claim/getChildRow", { index: childTableIndex }, function (data) { 
	
	    	 //alert(data);
	        childTable.append(data);
	        $("#childIndex").val(childTableIndex + 1);
	    });
	});
});
</script>
    </jsp:body>
</t:genericpage>