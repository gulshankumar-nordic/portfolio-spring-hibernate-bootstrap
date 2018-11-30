<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<div class="row">
    <div class="col-6">
        <h1 class="text-left">Product List</h1>

    </div>
    <div class="col-6" style="text-align:right;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/product/add" role="button"><i class="fa fa-plus"> Add Product </i></a>
        <p id="message">${message}</p>

    </div>
    </div>
    <div class="row">
    <div class="col-12">
         <table class="table">
               <thead class="thead-dark">
                   <tr>
                       <th scope="col">#</th>
                       <th scope="col">Product</th>
                       <th scope="col">Category</th>
                       <th scope="col">Cost</th>
                       <th scope="col" style="text-align:center;">Action</th>
                   </tr>
               </thead>
                <tbody>
         <c:forEach items="${productList}" var="productList">
         <tr>
           <td width="" align="center">${productList.id}</td>
           <td width="" align="center">${productList.name}</td>
           <td width="" align="center">${productList.category}</td>
           <td width="" align="center">${productList.price}</td>
           <td style="text-align:right;">
               <a class="btn btn-primary" href="${pageContext.request.contextPath}/product/edit/${productList.id}"
                   role="button" style="width:25%;">
                   <i class="fa fa-pencil"></i>
               </a>
               <a class="btn btn-danger" href="${pageContext.request.contextPath}/product/deleteById/${productList.id}"
                   role="button" style="width:25%;">
                   <i class="fa fa-trash"></i>
               </a>
           </td>

         </tr>
      </c:forEach>
       </tbody>
    </table>
    </div>
    </div>
<%@include file="footer.jsp"%>