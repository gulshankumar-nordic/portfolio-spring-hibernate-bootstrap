<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the information below to add a product!</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/product/edit/${product.id}"
                   method="post" modelAttribute="product" >
        <table>
        <tbody>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Rating:</td>
                <td><form:input path="category" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Edit" /></td>
                <td></td>
            </tr>
        </tbody>
        </table>

    </form:form>

    </div><!-- Row-->
</div><!-- container-->
<%@include file="footer.jsp"%>