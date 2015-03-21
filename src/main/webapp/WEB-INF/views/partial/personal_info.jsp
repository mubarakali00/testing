<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

		
		<tr>
			<td>
				<%-- <spring:bind path="personalInfoList[${ index }].name"> --%>
					<form:input path="claim_create.personalInfoList[${ index }].name" />
				<%-- </spring:bind> --%>
			</td>
			<td>
				<%-- <spring:bind path="personalInfoList[${ index }].fatherName">
					<form:input path="${ status.expression }" />
				</spring:bind> --%>
				<form:input path="claim_create.personalInfoList[${ index }].fatherName" />
			</td>
			<td>
				<%-- <spring:bind path="personalInfoList[${ index }].age">
					<form:input path="${ status.expression }" />
				</spring:bind> --%>
				<form:input path="claim_create.personalInfoList[${ index }].age" />
			</td>
			<td>
				<%-- <spring:bind path="personalInfoList[${ index }].remarks">
					<form:input path="${ status.expression }" />
				</spring:bind> --%>
				<form:input path="claim_create.personalInfoList[${ index }].remarks" />
			</td>
		</tr>
