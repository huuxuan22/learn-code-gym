$(document).ready(function(){
    showList();
    $("#remove").click(()=>{
        let id = $("#idDelete").val();
        deleteById(id);
    })
})

function showList() {
    $("#tableProduct").empty(); // Xóa bảng sản phẩm cũ (nếu có)

    $.ajax({
        url: "http://localhost:8080/api/product",
        method: "GET",
        dataType: "json",
        success: function(response) {
            // Xử lý dữ liệu trả về
            displayList(response.content);
        },
        error: function(xhr, status, error) {
            console.error("AJAX request failed:", status, error);
            // Xử lý lỗi (nếu cần)
        }
    });
}


// hàm showList

function displayList(products) {
    if (products.length === 0) {
        $("#tableProduct").append(`<tr>
            <td colspan="7" style="text-align: center; font-size: 30px; color: red;">Không có sản phẩm nào.</td>
        </tr>`);
    } else {
        products.forEach(function(product, index) {
            $("#tableProduct").append(`<tr>
                <td>${index + 1}</td>
                <td>${product.name}</td>
                <td>${product.maSanPham}</td>
                <td>${product.description}</td>
                <td>${product.price} VNĐ</td>
                <td>${product.category}</td>
                <td>${product.productType.nameProductType}</td>
                <td>
                <a href="#" class="delete" onclick="sendInf(${product.idProduct},'${product.name}')" data-bs-toggle="modal" data-bs-target="#deleteProduct">
    <i class="material-icons" data-bs-toggle="tooltip" title="Delete">delete</i>delete
</a>
                </td>
                <td></td>
            </tr>`);
        });
    }
}


function sendInf(id, name) {
    // Cập nhật giá trị id và name vào modal
    document.getElementById('idDelete').value = id;
    document.getElementById('nameDelete').innerText = name;
    
}




//<------------------------------------ XÓa 1 sản phẩm -------------------------------------->

function deleteById(id) {
    $.ajax({
        url: `http://localhost:8080/api/delete`,
        method: "DELETE",
        data: JSON.stringify({ idProduct: id }),
        success:  () => {
            showList();
            showAlert("success","đã xóa thành công")
        },
        error: function(xhr, status, error) {
            // Xử lý phản hồi lỗi
            console.error('Lỗi khi xóa sản phẩm:', error);
            // Hiển thị thông báo lỗi cho người dùng
            showAlert('Đã xảy ra lỗi khi xóa sản phẩm. Vui lòng thử lại sau.');
        }
    })
}


function showAlert(icon, message) {
    Swal.fire({
        icon: icon,
        title: "Oops...",
        text: message,
      });
}


