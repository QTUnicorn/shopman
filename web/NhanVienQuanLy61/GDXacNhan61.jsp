<%@page import="View61.GioHang61"%>

<!DOCTYPE html>
<html>
<head>
    <title>Xác Nh?n ??n Hàng</title>
</head>
<body>
    <h1>Xác Nh?n ??n Hàng</h1>
    <%
        boolean result = GioHang61.submitOrder();
        if (result) {
            out.println("??n hàng ?ã ???c l?u thành công.");
        } else {
            out.println("L?i khi l?u ??n hàng.");
        }
    %>
    <a href="main.jsp">Tr? v? trang chính</a>
</body>
</html>
