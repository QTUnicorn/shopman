<%@page import="View61.GioHang61"%>

<!DOCTYPE html>
<html>
<head>
    <title>X�c Nh?n ??n H�ng</title>
</head>
<body>
    <h1>X�c Nh?n ??n H�ng</h1>
    <%
        boolean result = GioHang61.submitOrder();
        if (result) {
            out.println("??n h�ng ?� ???c l?u th�nh c�ng.");
        } else {
            out.println("L?i khi l?u ??n h�ng.");
        }
    %>
    <a href="main.jsp">Tr? v? trang ch�nh</a>
</body>
</html>
