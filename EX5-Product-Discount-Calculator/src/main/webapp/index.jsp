<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .calculator-form { max-width: 500px; margin: 50px auto; padding: 30px; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        .calculator-form h2 { margin-bottom: 25px; text-align: center; }
    </style>
</head>
<body>
<div class="container">
    <div class="calculator-form">
        <h2 style="font-weight: bold">Product Discount Calculator</h2>
        <form action="discount" method="post">
            <div class="mb-3">
                <label for="productName" class="form-label">Mô Tả sản phẩm</label>
                <input type="text" class="form-control" id="productName" name="name" placeholder="Nhập mô tả sản phẩm" required>
            </div>
            <div class="mb-3">
                <label for="listPrice" class="form-label">Giá sản phẩm: </label>
                <input type="text" class="form-control" id="listPrice" name="price" placeholder="Nhập giá sản phẩm" required>
            </div>
            <div class="mb-3">
                <label for="discountPercent" class="form-label">Tỷ lệ chiết khấu (%):</label>
                <input type="text" class="form-control" id="discountPercent" name="discount" placeholder="Tỷ lệ chiết khấu" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary btn-lg">Tính chiết khấu</button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>