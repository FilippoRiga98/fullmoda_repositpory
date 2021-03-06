<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>	
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize var="loggedIn" access="isAuthenticated()" />
<c:if test="${loggedIn}">
	<sec:authentication var="user" property="principal" />
	<spring:message code="login.welcome.message" var="welcome" arguments="${user.name}"/>
</c:if>

<nav class="navbar navbar-inverse navbar-fixed-top">
  
	<div class="navbar-header">
		<a class="navbar-brand" href="home"><spring:message code = "app.name"/></a>
		<div class="navbar-welcome">
			<c:if test="${user != null and user.username != '' }">
				<c:out value="${welcome}" />
			</c:if>
		</div>
	</div>
	<div class="navbar-subheader">
		<div class="subheader-left">
			<ul class="nav navbar-nav">
				<li><a href="store"><spring:message code = "navigation.header.menu.store"/></a></li>
			</ul>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="cart">
				<c:choose>
					<c:when test="${sessionScope.cart != null and not empty sessionScope.cart}">
						<c:choose>
							<c:when test="${not empty sessionScope.cart.entries and sessionScope.cart.entries != null}">
								<c:set var="cartSize" value="${sessionScope.cart.totalQuantity()}" />
							</c:when>
							<c:otherwise>
								<c:set var="cartSize" value="${0}" />
							</c:otherwise>
						</c:choose>
					<spring:message code="navigation.header.menu.cart" arguments="${cartSize}"/>
					</c:when>
					<c:otherwise>
						<spring:message code="navigation.header.menu.cart" arguments="${0}"/>
					</c:otherwise>
				</c:choose>
			</a></li>
			<li><a href="products"><spring:message code = "navigation.header.menu.products"/></a></li>
				<c:choose>
				<c:when test="${user == null}">
					<li><a href="login"><spring:message code = "navigation.header.menu.login"/></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="my-account"><spring:message code = "navigation.header.menu.my-account"/></a></li>
					<li>
						<a href="logout"  id="logoutInp"><spring:message code = "navigation.header.menu.logout"/></a>
						<form action="logout" class="form-logout" method="POST" id="logout">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form> 
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
    
</nav>