<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>

<spring:message code="cart.shop.title" var="title"/>
<spring:message code="cart.shop.empty" var="emptyCart"/>
<spring:message code="cart.shop.head.product" var="product"/>
<spring:message code="cart.shop.head.unit.price" var="unitPrice"/>
<spring:message code="cart.shop.head.quantity" var="quantity"/>
<spring:message code="cart.shop.head.total.price" var="totalPrice"/>
<spring:message code="cart.shop.subtotal" var="subTotal"/>
<spring:message code="cart.shop.button.checkout" var="checkoutButton"/>
<spring:message code="cart.shop.button.shopmore" var="shopMoreButton"/>
<spring:message code="cart.shop.button.removeall" var="removeAllButton"/>
<spring:message code="cart.shop.button.update" var="updateButton"/>
<spring:message code="cart.shop.button.remove" var="removeButton"/>
<c:set var="subtotalPrice" value="${0}"/>
<c:set var="index" value="${0}" />

<t:template>
   <div class="container">
    <div class="row">
        <div class="col-md-9 col-sm-12">
	        <h2>${title}</h2>
	        <div class="row">
	            <c:choose>
		            <c:when test="${entries != null and not empty entries}">
			         	<div class="row">
				        	<div class="cart-title">
					        	<div class="col-sm-6 col-xs-12">
					        		<div class="col-xs-4"></div>
					        		<div class="col-xs-8"><h4>${product}</h4></div>
					        	</div>
					        	<div class="col-sm-6 col-xs-12">
					        		<div class="col-xs-4"><h4>${unitPrice}</h4></div>
					                <div class="col-xs-4"><h4>${quantity}'</h4></div>
					                <div class="col-xs-4"><h4>${totalPrice}</h4></div>
					        	</div>
				        	</div>
			        	
	        		  </div>
			          <c:forEach var="entry" items="${entries}">
			        	<c:set var="symbol" value="${entry.product.price.currency.symbol}"/>
						<c:set var="priceValue" value="${entry.product.price.value}"/>
						<c:set var="quantity" value="${entry.entry.quantity}"/>
						<c:set var="total" value="${priceValue * quantity}"/>
						<c:set var="subtotalPrice" value="${subtotalPrice + total}" />
						<c:set var="productCode" value="${entry.entry.product.code}"/>
						<c:set var="index" value="${index + 1}" />
			       		 <div class="row">
			            	<div class="col-sm-6 col-xs-12">
				               
				                <div class="row">   
					                <div class="col-xs-4"><img src="images/${entry.product.code}.jpg" class="img-responsive img-rounded"></div>
	       				            <div class="col-xs-8">
	       				            	<p>${entry.product.shortDescription}</p>
	       				            	<span>${entry.product.description}</span>    				            
	       				            </div>
				                </div>
				            </div>  
				            <div class="col-sm-6 col-xs-12">
				                <div class="row">
					                <div class="col-xs-4"><p>${priceValue} ${symbol}</p></div>
					                <div class="col-xs-4"><input id="setQuantity${index}" type="number" class="form-control text-center" value="${quantity}" min="1">
					                </div>
					                <div class="col-xs-4"><p>${total} ${symbol}</p></div>
				                </div>
				                <div class="row">
					                <div class="col-xs-4">&nbsp;</div>
					                <div class="col-xs-4">
					                	<a href="removeFromCart-${productCode}"><button class="btn btn-default">${removeButton}</button></a>
				                	</div>
					                <div class="col-xs-4">&nbsp;</div>
				                </div>
				                <div class="row">
					                <div class="col-xs-4">&nbsp;</div>
					                <div class="col-xs-4">				            
					                	<button onclick='window.top.location.href="updateQuantity-${productCode}?quantity=" + document.getElementById("setQuantity${index}").value;' 
					                		class="btn btn-default">${updateButton}</button>
					                </div>
					                <div class="col-xs-4">&nbsp;</div>
				                </div>
				            </div>
				        </div> 
				        <br />
			        </c:forEach>
			        <div class="row">   
			            <div class="col-sm-6 col-sm-offset-6">
			                <h4>${subTotal} ${subtotalPrice} ${symbol}</h4>
			            </div>  
			        </div>  
		        	</c:when>
		        	<c:otherwise>
		        		<div class="col-sm-6 col-xs-12"><h4>${emptyCart}</h4></div>
	        		</c:otherwise>
	       		</c:choose>
	        </div>
        </div>
        <div class="col-md-3 col-sm-12">
	        <button class="btn btn-success col-md-12 col-sm-6 col-xs-12">${checkoutButton}</button>
	        <br /><br />
	        <a href="products"><button class="btn btn-primary col-md-12 col-sm-6 col-xs-12">${shopMoreButton}</button></a>
	        <br /><br />
	        <a href="removeAllFromCart"><button class="btn btn-danger col-md-12 col-sm-6 col-xs-12">${removeAllButton}</button></a>
        </div>
     </div>  
    </div>
</t:template>