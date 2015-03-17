<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test=" ${ param.myRequestModel.newRow } " >
<tr>
	<td> <form:input path="${ param.myRequestModel.name }"/>  </td>
	<td> <form:input path="${ param.myRequestModel.fatherName }"/> </td>
	<td> <form:input path="${ param.myRequestModel.age }"/> </td>
	<td> <form:input path="${ param.myRequestModel.remarks }"/> </td>
</tr>
</c:if>