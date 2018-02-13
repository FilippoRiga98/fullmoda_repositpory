<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>	
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<spring:message code = "reset.password.title" var="title" />
<spring:message code = "reset.password.label.password" var="password"/>
<spring:message code = "reset.password.submit.button" var="submit"/>
<spring:message code = "reset.password.label.confirmPassword" var="confirmPassword"/>

<t:template>
<div class="row">

	<div class="col-sm-6">      
		<form:form action="reset-password" method="POST" modelAttribute="resetPasswordForm" class="form-horizontal">
			<h2 class="form-heading"><c:out value="${title}"/></h2>
			
			 <form:hidden path="token" value="${token}"/>
				
				<label for="password" class="sr-only">${password}</label>
	         <form:password path="password" class="form-control" placeholder="${password}"/>
	         <form:errors path="password" cssClass="error"/>
	         
	         <label for="confirmPassword" class="sr-only">${confirmPassword}</label>
	         <form:password path="confirmPassword" class="form-control" placeholder="${confirmPassword}"/>    			
				<button class="btn btn-lg btn-primary btn-block" type="submit">${submit}</button>
				
				<spring:hasBindErrors name="resetPasswordForm">
		        <c:forEach var="error" items="${errors.globalErrors}">
		        		<span class="error"><spring:message message="${error}" /></span>
		        		<br/>
		        </c:forEach>
	        </spring:hasBindErrors>
		
			
		</form:form>
		
		<c:if test="${not empty error}">
        <div class="error">${error}</div>
      </c:if>
		
		
	</div>
</div>
</t:template>