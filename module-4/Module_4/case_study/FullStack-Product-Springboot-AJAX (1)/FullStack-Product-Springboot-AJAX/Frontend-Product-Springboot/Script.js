    $(document).ready(function () {
        // Gọi hàm showList() để hiển thị danh sách ban đầu
        showList();

        // Sự kiện khi submit form tìm kiếm
        $("#search-form").submit(function (event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của form
            // Lấy từ khóa tìm kiếm từ input
            let keyword = $("#search-input").val();
            // Gọi hàm loadPage() với từ khóa tìm kiếm và trang đầu tiên
            if(keyword === "") {
                keyword = null; // Gán giá trị null nếu từ khóa là chuỗi rỗng
            }
            loadPage(0, keyword);
        });
        // Sự kiện khi submit form Xóa
        $("#deleteProductForm").submit(function(event) {
            event.preventDefault();
            let id = $("#idDel").val();
            deleteById(id);
            showAlert("success","Xóa thành công")
            $('#deleteProductModal').modal('hide');
        })
        $("#addProductForm").submit(function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của form
        
            // Kiểm tra dữ liệu nhập vào trước khi gửi AJAX request
            if (!validateAddProductData()) {
                return; // Dừng hàm nếu dữ liệu không hợp lệ
            }
        
            // Thực hiện AJAX request để thêm sản phẩm
            add(); // Gọi hàm add() để thêm sản phẩm
            showAlert("success","Thêm mới thành công")
            // Đóng modal sau khi thêm sản phẩm thành công
            $('#addProductModal').modal('hide');
        });
        $("#updateProductForm").submit(function(event) {
            event.preventDefault(); // Ngăn chặn hành vi mặc định của form
        
            // Kiểm tra dữ liệu nhập vào trước khi gửi AJAX request
            if (!validateUpdateProductData()) {
                return; // Dừng hàm nếu dữ liệu không hợp lệ
            }
        
            // Thực hiện AJAX request để thêm sản phẩm
            updateProduct(event); // Gọi hàm add() để thêm sản phẩm
            showAlert("success","Chỉnh sửa thành công")
            // Đóng modal sau khi thêm sản phẩm thành công
            $('#editProductModal').modal('hide');
        });
        // $("#updateProductForm").submit(updateProduct);
    });
    
    // Hàm hiển thị danh sách sản phẩm
    function showList() {
        $("#list").empty(); // Xóa danh sách hiện tại trước khi tải danh sách mới

        // Gửi yêu cầu AJAX để lấy danh sách sản phẩm từ máy chủ
        $.ajax({
            url: "http://localhost:8080/api",
            method: "GET",
            dataType: "JSON",
            success: function (data) {
                // Hiển thị danh sách sản phẩm trên trang web
                displayProducts(data.content);
                // Hiển thị thông tin phân trang
                displayPaginationInfo(data.number, data.totalPages);
                // Tạo nút phân trang
                renderPagination(data.number, data.totalPages, $("#search-input").val());
            },
            error: function (xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    // Hàm tải dữ liệu trang mới khi chuyển trang hoặc tìm kiếm
    function loadPage(page, keyword) {
        var url = `http://localhost:8080/api?page=${page}&keyword=${keyword}`;

        $.ajax({
            url: url,
            method: "GET",
            dataType: "JSON",
            success: function (data) {
                // Hiển thị danh sách sản phẩm trên trang web
                displayProducts(data.content);
                // Hiển thị thông tin phân trang
                displayPaginationInfo(data.number, data.totalPages);
                // Tạo nút phân trang
                renderPagination(data.number, data.totalPages, keyword);
            },
            error: function (xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    // Hàm hiển thị danh sách sản phẩm trên trang web
    function displayProducts(products) {
        $("#list").empty(); // Xóa danh sách hiện tại trước khi hiển thị danh sách mới
        // Lặp qua mỗi sản phẩm và thêm vào danh sách hiện tại
        if(products.length === 0) {
            // Nếu danh sách sản phẩm rỗng, hiển thị thông báo
            $("#list").append(`<tr>
                                    <td colspan="7" style = "text-align: center;font-size: 30px; color: red" >Không có sản phẩm nào.</td>
                                </tr>`);
        } else {
        products.forEach(function (product, index) {
            $("#list").append(`<tr>
                                <td>${index + 1}</td>
                                <td>${product.name}</td>
                                <td>${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>${product.color}</td>
                                <td>${product.category.nameCategory}</td>
                                <td>
                                
                                    <a href="#editProductModal" onclick="openEditModal(${product.id})" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="#deleteProductModal" onclick="sendInf('${product.id}','${product.name}')" class="delete" data-toggle="modal" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>`);
        });
        }
    }
    // Hàm hiển thị thông tin phân trang
    function displayPaginationInfo(currentPage, totalPages) {
        $("#currentPage").text(currentPage + 1);
        $("#totalPages").text(totalPages);
    }

    // Hàm tạo nút phân trang
    function renderPagination(currentPage, totalPages, keyword) {
        var pagination = $("#pagination");
        pagination.empty(); // Xóa nút phân trang cũ

        // Thêm nút Previous
        pagination.append(`<li class="page-item ${currentPage === 0 ? 'disabled' : ''}">
                                <a class="page-link" onclick="loadPage(${currentPage - 1}, '${keyword}')">Previous</a>
                            </li>`);

        // Thêm các nút phân trang
        for (var i = 0; i < totalPages; i++) {
            pagination.append(`<li class="page-item ${currentPage === i ? 'active' : ''}">
                                    <a class="page-link" onclick="loadPage(${i}, '${keyword}')">${i + 1}</a>
                                </li>`);
        }

         // Thêm nút Next
        if (currentPage < totalPages - 1) { // Kiểm tra xem đang ở trang cuối cùng hay không
            pagination.append(`<li class="page-item">
                                    <a class="page-link" onclick="loadPage(${currentPage + 1}, '${keyword}')">Next</a>
                                </li>`);
        } else {
            pagination.append(`<li class="page-item disabled">
                                    <a class="page-link">Next</a>
                                </li>`);
        }
    }

    //Thêm sản phẩm
    function add() { 
        let data = { 
                    name: $("#productName").val(),
                    price: $("#productPrice").val(),
                    quantity: $("#productQuantity").val(),
                    color: $("#productColor").val(),
                    category: {
                        idCategory: $("#categoryId").val(),
                        nameCategory: $("#categoryId option:selected").text()
                    }
        };
        $.ajax({
            url: `http://localhost:8080/api/create`,
            method: "POST",
            data: JSON.stringify(data),
            contentType: "application/JSON",
            success: () => {    
                showList();
            }
        })
    }

    //Hàm lấy thông tin sản phẩm
    function openEditModal(id) {
        $.ajax({
            url: `http://localhost:8080/api/${id}`, 
            method: "GET",
            dataType: "JSON",
            success: function (data) {
                // Điền thông tin sản phẩm vào form chỉnh sửa
                $("#editProductId").val(data.id);
                $("#editProductName").val(data.name);
                $("#editProductPrice").val(data.price);
                $("#editProductQuantity").val(data.quantity);
                $("#editProductColor").val(data.color);
                $("#editProductCategoryId").val(data.category.idCategory);
                // Mở modal chỉnh sửa
                $("#editProductModal").modal("show");
            },
            error: function (xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }

    //Hàm cập nhật sản phẩm
    function updateProduct(event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của form

        // Lấy dữ liệu từ form
        let formData = {
            name: $("#editProductName").val(),
            price: $("#editProductPrice").val(),
            quantity: $("#editProductQuantity").val(),
            color: $("#editProductColor").val(),
            category: {
                idCategory: $("#editProductCategoryId").val(),
                nameCategory: $("#editProductCategoryId option:selected").text()
            }
        };
        // Lấy ID của sản phẩm cần cập nhật
        let id = $("#editProductId").val();
        
        $.ajax({
            url: `http://localhost:8080/api/update/${id}`, // Thay đổi đường dẫn tương ứng với endpoint cập nhật sản phẩm
            method: "PUT", // Sử dụng phương thức PUT
            contentType: "application/json", // Xác định kiểu dữ liệu của dữ liệu gửi đi là JSON
            data: JSON.stringify(formData), // Chuyển đổi đối tượng formData thành chuỗi JSON trước khi gửi đi
            success: function () {
                showList(); // Hiển thị danh sách sản phẩm sau khi cập nhật
            },
            error: function (xhr, status, error) {
                console.error(xhr.responseText);
            }
        });
    }
    
    //Xóa 
    function deleteById(id) {
        $.ajax({
            url: `http://localhost:8080/api/delete?id=${id}`,
            method: "DELETE",
            success: () => {
                showList();
            }
        })
    }

    //Hàm tìm kiếm tên trong modal Xóa
    function sendInf(id, name) {
        document.getElementById("idDel").value = id;
        document.getElementById("nameDel").innerText = name;
    }

    //Validate dữ liệu
    //Hàm kiểm tra dữ liệu nhập vào
    function validateAddProductData() {
        // Biểu thức chính quy cho tên (VD: ^[A-Za-z ]*$)
        let nameRegex= /^[A-Za-zÀ-Ỹà-ỹ ]*$/;
        // Biểu thức chính quy cho giá tiền 
        let priceRegex = /^\d{1,}(,\d{3})*(\.\d+)?$/;
        // Biểu thức chính quy cho màu sắc (VD: Red, blue, green)
        let colorRegex = /^[a-zA-ZÀ-Ỹà-ỹ]+$/;
        // Lấy dữ liệu từ các trường input
        let productName = $("#productName").val();
        let productPrice = $("#productPrice").val();
        let productColor = $("#productColor").val();
    
        //Kiểm tra tên
        if (!nameRegex.test(productName)) {
            showAlert("error", "Tên không hợp lệ");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }

        // Kiểm tra giá tiền
        if (!priceRegex.test(productPrice)) {
            showAlert("error", "Giá tiền không hợp lệ");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }
    
        // Kiểm tra màu sắc
        if (!colorRegex.test(productColor)) {
            showAlert("error", "Màu sắc không hợp lệ");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }
    
        return true; // Trả về true nếu dữ liệu hợp lệ
    }

    //Hàm validate chỉnh sửa
    function validateUpdateProductData() {
        // Biểu thức chính quy cho tên (VD: ^[A-Za-z ]*$)
        let nameRegex = /^[A-Za-zÀ-Ỹà-ỹ ]*$/;
        // Biểu thức chính quy cho giá tiền 
        let priceRegex = /^\d{1,}(,\d{3})*(\.\d+)?$/;
        // Biểu thức chính quy cho màu sắc (VD: Red, blue, green)
        let colorRegex = /^[a-zA-ZÀ-Ỹà-ỹ]+$/;
        
        // Lấy dữ liệu từ các trường input trong form chỉnh sửa
        let productName = $("#editProductName").val();
        let productPrice = $("#editProductPrice").val();
        let productColor = $("#editProductColor").val();
        
        // Kiểm tra tên
        if (!nameRegex.test(productName)) {
            showAlert("error", "Tên không hợp lệ");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }
    
        // Kiểm tra giá tiền
        if (!priceRegex.test(productPrice)) {
            showAlert("error", "Giá tiền không hợp lệ.");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }
        
        // Kiểm tra màu sắc
        if (!colorRegex.test(productColor)) {
            showAlert("error", "Màu sắc không hợp lệ.");
            return false; // Dừng hàm nếu dữ liệu không hợp lệ
        }
        
        return true; // Trả về true nếu dữ liệu hợp lệ
    }
    
    // Hàm hiển thị alert
    function showAlert(icon, message) {
        Swal.fire({
            icon: icon,
            title: "Oops...",
            text: message,
          });
    }