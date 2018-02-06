<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>	
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<spring:message code = "forgot.password.label.email" var="email"/>
<spring:message code = "forgot.password.submit.button" var="submit"/>
<spring:message code = "forgot.password.title" var="title" />
<spring:message code = "forgot.password.text1" var="text1" />

<t:template>
<div class="row">
	<div class="col-sm-6">
		<form:form action="forgot-password" method="POST" modelAttribute="forgotPasswordForm" class="form-horizontal">
			<h2 class="form-heading"><c:out value="${title}"/></h2>
			<p><c:out value="${forgotPassword_text1}"/></p>
				<label for="email" class="sr-only">${email}</label>
				<form:input path="email" class="form-control" placeholder="${email}" />
				<form:errors path="email" cssClass="error"/>
			
			<button class="btn btn-primary btn-block" type="submit">${submit}</button>
			
			<spring:hasBindErrors name="forgotPasswordForm">
	        <c:forEach var="error" items="${errors.globalErrors}">
	        	<span class="error"><spring:message message="${error}" /></span>
	        <br/>
	        </c:forEach>
			</spring:hasBindErrors>
		</form:form>
	</div>
</div>
</t:template>