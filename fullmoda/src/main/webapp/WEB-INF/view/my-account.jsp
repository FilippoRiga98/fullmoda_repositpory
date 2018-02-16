<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<spring:message code="my-account.contact.title" var="contactTitle" />
<spring:message code="my-account.contact.label.name" var="contactName" />
<spring:message code="my-account.contact.label.surname" var="contactSurname" />
<spring:message code="my-account.contact.label.fiscalCode" var="contactFiscalCode" />
<spring:message code="my-account.contact.label.phoneNumber" var="contactPhoneNumber" />
<spring:message code="my-account.contact.label.birthDate" var="contactBirthDate" />
<spring:message code="my-account.contact.label.birthPlace" var="contactBirthPlace" />
<spring:message code="my-account.contact.label.address" var="contactAddress" />
<spring:message code="my-account.contact.label.city" var="contactCity" />
<spring:message code="my-account.contact.label.country" var="contactCountry" />
<spring:message code="my-account.contact.label.zipcode" var="contactZipcode" />
<spring:message code="my-account.contact.submit.button" var="contactUpdate" />

<spring:message code="my-account.login.title" var="loginTitle" />
<spring:message code="my-account.login.label.email" var="loginEmail" />
<spring:message code="my-account.login.label.password" var="loginPassword" />
<spring:message code="my-account.login.label.confirmPassword" var="loginConfirmPassword" />
<spring:message code="my-account.login.submit.button" var="loginUpdate" />

<t:template>
	<div class="row">
      	<div class="col-sm-8 col-md-8 col-lg-8 col-lg-offset-2">
            <section>
              <h3>${contactTitle}</h3>
              <form:form action="updateContactInfo" method="POST" modelAttribute="contactForm">
                <div class="row">
                   <div class="col-sm-6">
                    <label for="name" >${contactName}</label>
                      <form:input path="name" class="form-control" value="${user.name}"/>
                      <form:errors path="name" cssClass="error"/>
                  </div>   
                  <div class="col-sm-6">
                    <label for="surname" >${contactSurname}</label>
                      <form:input path="surname" class="form-control" value="${user.surname}"/>
                      <form:errors path="surname" cssClass="error"/>
                  </div>               
                </div>
                <div class="row">
                  <div class="col-sm-6">
                    <label for="fiscalCode" >${contactFiscalCode}</label>
                      <form:input path="fiscalCode" class="form-control" value="${user.fiscalCode}"/>
                      <form:errors path="fiscalCode" cssClass="error"/>
                  </div>
                  <div class="col-sm-6">
                    <label for="phoneNumber" >${contactPhoneNumber}</label>
                      <form:input path="phoneNumber" class="form-control" value="${user.phoneNumber}"/>
                      <form:errors path="phoneNumber" cssClass="error"/>
                  </div>  
                </div>
                
                <div class="row">
	          		<div class="col-sm-4">
	          		  <fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthDate}" var="userBirthDate"/>
	          		  <label for="birthDate" >${contactBirthDate}</label>
                      <form:input path="birthDate" type="date" class="form-control" value="${userBirthDate}" />
                      <form:errors path="birthDate" cssClass="error"/>
	          		</div>
	          		<div class="col-sm-8">
	          			<label for="birthPlace" >${contactBirthPlace}</label>
                      <form:input path="birthPlace" class="form-control" value="${user.birthPlace}"/>
                      <form:errors path="birthPlace" cssClass="error"/>
	          		</div>
          		</div>

                <div class="row">
                  <div class="col-sm-4">
                    <label for="line1" >${contactAddress}</label>
                      <form:input path="line1" class="form-control" value="${user.address.line1}"/>
                      <form:errors path="line1" cssClass="error"/>
                  </div>
                  <div class="col-sm-4">
                    <label for="city" >${contactCity}</label>
                     <form:input path="city" class="form-control" value="${user.address.town}"/>
                     <form:errors path="city" cssClass="error"/>
                  </div> 
                  
                  <div class="col-sm-2">
                    <label for="zipcode" >${contactZipcode}</label>
                      <form:input path="zipcode" class="form-control" value="${user.address.zipCode}"/>
                      <form:errors path="zipcode" cssClass="error"/>
                  </div> 

                  <div class="col-sm-2">
                    <label for="country" >${contactCountry}</label>
                      <form:select path="country.code" class="form-control" >
                      	<c:forEach var="countryItem" items="${countries}">
                      		<c:choose>
                      			<c:when test="${(countryItem.code) == (user.address.country.code)}">
                      				<form:option value="${countryItem.code}" selected="true">${countryItem.name}</form:option>
                      			</c:when>
                      			<c:otherwise>
                      				<form:option value="${countryItem.code}">${countryItem.name}</form:option>
                      			</c:otherwise>
                      		</c:choose>
                      	</c:forEach>
                      </form:select>
                  </div> 
                 </div>
                <br />  
				<div class="row">
	                <div class="col-sm-12">
	                  <div class="btn-div">
	                    <input type="submit" class="btn btn-primary btn-md pull-right" value="${contactUpdate}" />
	                  </div>
	                </div>
                </div>
                
                 <spring:hasBindErrors name="contactForm">
			        <c:forEach var="error" items="${errors.globalErrors}">
			        		<span class="error"><spring:message message="${error}" /></span>
			        		<br/>
			        </c:forEach>
		        </spring:hasBindErrors>
		        
                </form:form>      
            </section>

           
          
          <section>
			<h3>${loginTitle}</h3>
			<form:form action="updateLoginInfo" method="POST" modelAttribute="passwordForm">
				<div class="row">
					<div class="col-sm-12">
						<label for="email" >${loginEmail}</label>                
						<form:input path="email" class="form-control" value="${user.email}" readonly="true" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label for="password" >${loginPassword}</label>                
						<form:password path="password" class="form-control" />
						<form:errors path="password" cssClass="error"/>
					</div>
					<div class="col-sm-6">
						<label for="confirmPassword" >${loginConfirmPassword}</label>    
						<form:input path="confirmPassword" class="form-control" />
						<form:errors path="confirmPassword" cssClass="error"/>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-sm-12">
						<div class="btn-div">
						<input type="submit" class="btn btn-primary btn-md pull-right" value="${loginUpdate}" />
						</div>
					</div> 
				</div>          
				
				<spring:hasBindErrors name="passwordForm">
					<c:forEach var="error" items="${errors.globalErrors}">
						<span class="error"><spring:message message="${error}" /></span>
						<br/>
					</c:forEach>
				</spring:hasBindErrors>
			
			</form:form> 
          </section>
       </div>
	</div>
</t:template>