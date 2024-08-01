<%@page import="View61.MatHang61"%>
<%@ page import="java.util.List" %>
<%--<%@ page import="your.package.MatHang61" %>
<%@ page import="your.package.DatabaseConnection" %>--%>

<!DOCTYPE html>
<html>
<head>
    <title>Tìm M?t Hàng</title>
</head>
<body>
    <h1>Tìm M?t Hàng</h1>
    <form method="get" action="search.jsp">
        <label for="itemName">Tên m?t hàng:</label>
        <input type="text" id="itemName" name="itemName" required>
        <input type="submit" value="Tìm Ki?m">
    </form>

    <%
        String itemName = request.getParameter("itemName");
        if (itemName != null && !itemName.trim().isEmpty()) {
            List<MatHang61> items = MatHang61.getHangHoa(itemName);
    %>
        <table border="1">
            <tr>
                <th>Tên</th>
                <th>Giá</th>
                <th>S? L??ng</th>
                <th>Thêm vào gi?</th>
            </tr>
            <%
                for (MatHang61 item : items) {
            %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td><%= item.getPrice() %></td>
                    <td><%= item.getNumber() %></td>
                    <td>
                        <form action="cart.jsp" method="post">
                            <input type="hidden" name="itemId" value="<%= item.getID2() %>">
                            <input type="hidden" name="itemName" value="<%= item.getName() %>">
                            <input type="hidden" name="itemPrice" value="<%= item.getPrice() %>">
                            <input type="submit" value="Thêm vào gi?">
                        </form>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>
</body>
</html>
