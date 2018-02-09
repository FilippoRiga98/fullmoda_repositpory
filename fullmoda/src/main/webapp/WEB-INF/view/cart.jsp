<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<t:template>
	<div class="row">
		<div class="col-sm-6">
		<c:forEach var="entry" items="${cart.entries}">
			<p>Prodotto: ${entry.product.code}        Quantità: ${entry.quantity}</p>
		</c:forEach>
		</div>
		<div class="col-sm-6">
		
		</div>
	</div>
</t:template>