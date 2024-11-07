<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        .form-log-in{
            width: 400px;
            height: 400px;
            border: 1px solid black;
            justify-content: center;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="form-log-in">
    <h1>Product Discount Calculator</h1>
    <form action="/tinh-chiet-khau" method="post">
                <label for="Description">Product Description(Mô tả sản phẩm): </label></br>
                <textarea id="Description" name="Description" placeholder="Description"></textarea></br>
                <label >Giá Niêm yết sản phẩm:  </label></br>
                <input name="Price" placeholder="price"></br>
                <label>Tỷ lệ chiết khấu: </label></br>
                <input name="Perrent" placeholder="perrent">
                <button type="submit">send</button>
    </form>
</div>
</body>
</html>