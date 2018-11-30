<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>


<div class="container">
    <div class="page-header">
        <div class="row">
            <div class="col-6">
                <h1>Add Product</h1>
            </div>
            <div class="col-6" style="text-align:right;">
                <span class=""> Back to <a href="<c:url value='/products' />">Product List</a>  </span>
            </div>
         </div>
    </div>
    <form:form action="${pageContext.request.contextPath}/product/add/process"
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

                               <div class="form-group">
                                  <label>Category</label>
                                  <form:select path="category" id="category">
                                        <form:option value="Socks"/>
                                        <form:option value="Scarves"/>
                                        <form:option value="Mittens"/>
                                    </form:select>
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
                             <button type="submit" class="btn btn-primary">Save</button>
    </form:form>
</div>

<%@include file="footer.jsp"%>