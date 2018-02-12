<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>		
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<c:set var="colorVariants" value="${product.variants}"/>
<spring:message code="product.page.buy" var="addToCart"/>

<t:template>
	
	
	<div class="row">
		<div class="col-sm-6">
			<img src="images/${product.code}.jpg" class="img_product img-responsive img-rounded"/>
		</div>
		<div class="col-sm-4 col_product">
			
			<div class="product-name">
				<h2><c:out value="${product.shortDescription}"/></h2>
			</div>
			<div class="product-price">
				<span><c:out value="${product.price.currency.symbol}"/>&nbsp;<fmt:formatNumber value="${product.price.value}" minFractionDigits="2"/></span>
			</div>
			<form:form action="addToCart" method="POST" modelAttribute="productForm" >	
				<div class="product-info-wrapper">
					<div class="style-number-title">
						<span><spring:message code = "product.page.style-number.label"/><c:out value="${product.code}"/></span>
					</div>
					<div class="product-style-selector">
	                    <div class="style-color-material">
							<div class="form-group">
		                        <form:select path="color" class="form-control color-select">
									<c:forEach var="color_variant" items="${colorVariants}">
											<form:option value="${color_variant.colorData.htmlCode}">${color_variant.colorData.htmlCode}</form:option>
									</c:forEach>
								</form:select>	
	                         </div>
	                    </div>
	                    
	                </div>
					<div class="sizes">
						<c:forEach  var="colorVariant" items="${colorVariants}">
							<div class="form-group">
								<form:select path="size" class="form-control size-select">
										<c:forEach var="sizeVariant" items="${colorVariant.variants}">
												<form:option value="${sizeVariant.size.code}">${sizeVariant.size.code}</form:option>
										</c:forEach>
								</form:select>
							</div>
						</c:forEach>
						
					</div>
						
					<div class="product_desc">
						<span><c:out value="${product.description}"/></span>
					</div>
				</div>
				<br />
				<form:hidden path="baseProductCode" value="${product.code}"/>
				<div class="quantity">
					<div>
		                  <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
		                  <form:input path="quantity" value="1" />
		                  <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
					</div>
				</div>

				<br />
				<input type="submit" class="btn btn-primary btn-lg" value="${addToCart}" /> 
			</form:form>
		</div>
	</div>


</t:template>