<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <h2>Product List</h2>
        </div>
        <div class="col-sm-6" style="text-align:right;">
            <a class='btn btn-primary' href='#addModal' data-toggle='modal' role='button'
                     data-target='#addModal' style='width:35%;'><i class='fa fa-pencil'> Add</i></a>

        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">
            <table id="productTable"
                class="table table-bordered
                table-condensed table-striped">
                <tr>
                    <th>#</th>
                    <th>Product Name</th>
                    <th>Introduction Date</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
                <c:forEach var ="listProduct" items="${products}">
                <tr>
                    <td></td>
                    <td>${listProduct.name}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>





</div>

<%@include file="footer.jsp"%>