<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="row">
            <div class="col-6">
                <h1>Edit Product</h1>
            </div>
            <div class="col-6" style="text-align:right;">
                <span class=""> Back to <a href="<c:url value='/products' />">Product List</a>  </span>
            </div>
         </div>
            <div class="row">

            <div class="col-md-12">
                 <form:form action="${pageContext.request.contextPath}/product/edit/${product.id}"
                       method="post" modelAttribute="product" >
                   <div class="form-group">
                       <label >Product name</label>
                       <form:input type="text" class="form-control" id="name" path="name" />
                     </div>

                     <div class="form-group">
                       <label >Description</label>
                       <form:textarea class="form-control" id="description" rows="3" path="description"/>
                     </div>
                      <div class="form-group">
                        <label>Cost</label>
                        <form:input type="text" class="form-control" id="cost" path="price" />
                      </div>

                     <fieldset class="form-group">
                       <legend>Category</legend>
                       <div class="form-check">
                        <label class="form-check-label">
                           <form:radiobutton path="category" id="category" value="Socks"/>
                                Socks
                         </label>
                       </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <form:radiobutton path="category" id="category" value="Scarves"/>
                                Scarves
                            </label>
                        </div>
                        <div class="form-check">
                            <label class="form-check-label">
                                <form:radiobutton path="category" id="category" value="Mittens"/>
                                Mittens
                            </label>
                        </div>

                     </fieldset>
                      <div class="form-group">
                        <label>File input</label>
                        <input type="file" class="form-control-file" id="image"">
                      </div>
                     <button type="submit" class="btn btn-primary">Edit</button>
                </form:form>
                </div>
            </div>
    </div>
</div>
<%@include file="footer.jsp"%>