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
    </div>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Product</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${product}" var="product">
            <tr>
                <td><img src="${pageContext.request.contextPath}/resources/images/avatar.jpeg" alt="image" style="width:100px, height:100px;"/></td>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.price} €</td>

            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="footer.jsp"%>

