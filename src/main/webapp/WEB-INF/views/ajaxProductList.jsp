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
            </table>
        </div>
    </div>

    <div style="color:black;" class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title" id="modalHeading">Add Product </h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <form action=""
                           method="post" modelAttribute="product" >
                 <div class="form-group">
                    <label >Product name</label>
                    <input type="text" path="name" class="form-control" id="name" />
                 </div>
                 <div class="form-group">
                      <label>Description</label>
                      <textarea row="3" type="text" path="description" class="form-control" id="description" ></textarea>
                  </div>
                  <div class="form-group">
                      <label >Cost</label>
                      <input type="text" path="price" class="form-control" id="cost" />
                  </div>
                   <div class="form-group">
                      <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="category">
                          <option value="Socks">Socks</option>
                          <option value="Scarves">Scarves</option>
                          <option value="Mittens">Mittens</option>
                        </select>
                      </div>

                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <input class="btn btn-primary" id="btnSave" type="button" onclick="productAdd()" value="Submit" />
              </div>
            </div>
          </div>
        </div>



    <div style="color:black;" class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">Edit Product </h4>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form action=""  method="post" modelAttribute="product" >
             <div class="form-group">
                <label >Product name</label>
                <input type="hidden" id="productid" value="0" />
                <input type="text" path="name" class="form-control" id="editName" />
             </div>
             <div class="form-group">
                  <label>Description</label>
                  <textarea row="3" type="text" path="description" class="form-control" id="editDescription" ></textarea>
              </div>
              <div class="form-group">
                  <label >Cost</label>
                  <input type="text" path="price" class="form-control" id="editCost" />
              </div>
               <div class="form-group">
                  <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="editCategory">
                      <option value="Socks">Socks</option>
                      <option value="Scarves">Scarves</option>
                      <option value="Mittens">Mittens</option>
                    </select>
                  </div>

            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
            <input class="btn btn-primary" id="" type="button" onclick="productUpdate()" value="Submit" />
          </div>
        </div>
      </div>
    </div>


</div>

<%@include file="footer.jsp"%>

 <script type="text/javascript">
     function productToFields(product) {
       $("#name").val(product.name);
       $("#description").val(product.description);
       $("#category").val(product.category);
       $("#price").val(product.price);
     }

    function productList() {
      // Call Web API to get a list of Product
      $.ajax({
        url : "${pageContext.request.contextPath}/products/list",
        type: 'GET',
        dataType: 'json',
        success: function (products) {
          productListSuccess(products);
        },
        error: function (request, message, error) {
          handleException(request, message, error);
        }
      });
    }

    function productListSuccess(products) {
      $.each(products, function (index, product) {
        productAddRow(product);
      });
    }

    function productAddRow(product) {
      if ($("#productTable tbody").length == 0) {
       $("#productTable").append("<tbody></tbody>");
      }
      // Append row to <table>
      $("#productTable tbody").append(
        productBuildTableRow(product));
    }

    function productBuildTableRow(product) {
      var ret =
        "<tr>" +
        "<td>" + product.id + "</td>" +
         "<td>" + product.name + "</td>" +
         "<td>" + product.category + "</td>" +
         "<td>" + product.price + "</td>" +
         "<td>" +
         " <a class='btn btn-primary' id='"+product.id+"' href='#editModal' data-toggle='modal' role='button' "+
         "data-target=''#editModal' onclick='productGet("+product.id+")' style='width:35%;'><i class='fa fa-pencil'></i></a>"+
         " <a class='btn btn-danger' onclick='productDelete("+product.id+")' "+
         " href='#' role='button' "+
              "style='width:35%;'><i class='fa fa-trash'></i></a>"+
         "</td >" +
        "</tr>";
      return ret;
    }

    function handleException(request, message,
                             error) {
      var msg = "";
      msg += "Code: " + request.status + "\n";
      msg += "Text: " + request.statusText + "\n";
      if (request.responseJSON != null) {
        msg += "Message" +
            request.responseJSON.Message + "\n";
      }
      alert(msg);
    }

    function productAddSuccess(product) {
      productAddRow(product);
    }

    function productAdd() {
        let productName = $('#name').val();
        let productCategory = $('#category').val();
        let productDescription = $('#description').val();
        let productCost = $('#cost').val();
      $.ajax({
        url : "${pageContext.request.contextPath}/product/create",
        type: 'POST',
        contentType:
           "application/json;charset=utf-8",
        data: JSON.stringify({
            'name': productName,
            'category': productCategory,
            'description': productDescription,
            'price': productCost,
        }),
        success: function (product) {
         $('#addModal').modal('hide');
         let productName = $('#name').val("");
         let productCategory = $('#category').val("");
         let productDescription = $('#description').val("");
         let productCost = $('#cost').val("");
          console.log(product);
          swal("Great!", "Product added successfully!", "success");
          $('#productTable tbody').empty();
          productList();
        },
        error: function (request, message, error) {
          handleException(request, message, error);
        }
      });
    }

    function productGet(ctl) {
      var id = $(ctl).data("id");
      $("#productid").val(id);

      $.ajax({
        url: "${pageContext.request.contextPath}/product/findById/" + ctl,
        type: 'GET',
        dataType: 'json',
        success: function (product) {
        console.log(product);
          $('#editName').val(product.name);
          $('#editDescription').val(product.description);
           $('#editCategory').val(product.category);
          $('#editCost').val(product.price);
          //$("#updateButton").text("Update");
        },
        error: function (request, message, error) {
          handleException(request, message, error);
        }
      });
      uId = ctl;

    }

    function productUpdate() {
        let productId = $('#productid').val();
        let productName = $('#editName').val();
        let productCategory = $('#editCategory').val();
        let productDescription = $('#editDescription').val();
        let productCost = $('#editCost').val();
        $.ajax({
            url: "${pageContext.request.contextPath}/product/update",
            method: "PUT",
            data: JSON.stringify({
            'id': productId,
                'name': productName,
                'category': productCategory,
                'description': productDescription,
                'price': productCost,
            }),
            headers: {
                "accept": "application/json;odata=verbose",
                "content-type": "application/json;odata=verbose",
                "X-RequestDigest": $("#__REQUESTDIGEST").val(),
                "IF-MATCH": "*",
                "X-HTTP-Method": "MERGE"
            },
            success: function(data) {
            console.log(data);
            $('#editModal').modal('hide');
                swal("Item Updated successfully", "success");
                 $('#productTable tbody').empty();
                  productList();
            },
            error: function(error) {
                console.log(JSON.stringify(error));
            }
        })
    }

    function productDelete(ctl) {
      var id = $(ctl).data("id");
      $.ajax({
         url : "${pageContext.request.contextPath}/product/delete/"+ctl,
        type: 'DELETE',
        success: function (product) {
            $(ctl).parents("tr").remove();
            swal("Good job!", "You clicked the button!", "success");
            $('#productTable tbody').empty();
            productList();
        },
        error: function (request, message, error) {
          handleException(request, message, error);
        }
      });
    }


    $(document).ready(function () {
      productList();
    });


    </script>

