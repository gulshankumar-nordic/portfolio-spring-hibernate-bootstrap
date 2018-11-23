<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>


<div class="container">
    <div class="page-header">
        <h1>Add Product</h1>
    </div>
    <form:form action="${pageContext.request.contextPath}/product/add/process"
                   method="post" modelAttribute="product" >
         <div class="form-group">
            <label >Product name</label>
            <form:input type="text" path="name" class="form-control" id="name" />
         </div>
         <div class="form-group">
             <label>Description</label>
             <form:textarea row="3" type="text" path="description" class="form-control" id="description" />
         </div>
         <div class="form-group">
            <label >Cost</label>
            <form:input type="text" path="price" class="form-control" id="price" />
        </div>
          <div class="form-group">
                    <label for="category">Category</label>
               <form:radiobutton path="category" id="category" value="Socks"/>Socks
                <label class="checkbox-inline"><form:radiobutton path="category" id="category" value="Scarves"/>Scarves</label>
                <label class="checkbox-inline"><form:radiobutton path="category" id="category" value="Mittens"/>Mittens</label>
                <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="inlineFormCustomSelect">
                    <option selected>Choose...</option>
                    <option value="Socks">Socks</option>
                    <option value="Scarves">Scarves</option>
                    <option value="Mittens">Mittens</option>
                  </select>
            </div>
         <div class="form-check" style="padding-left:0px;">
             <label class="form-check-label" style="width:100%;">
               <input type="submit" value="Add" class="btn btn-primary" style="width:100%">

             </label>
          </div>
    </form:form>
</div>

<%@include file="footer.jsp"%>