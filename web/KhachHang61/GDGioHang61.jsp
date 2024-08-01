<%@ page import="java.util.List" %>
<%@ page import="your.package.MatHang61" %>
<%@ page import="your.package.GioHang61" %>

<!DOCTYPE html>
<html>
<head>
    <title>Gi? H�ng</title>
</head>
<body>
    <h1>Gi? H�ng</h1>
    <%
        String itemId = request.getParameter("itemId");
        String itemName = request.getParameter("itemName");
        String itemPrice = request.getParameter("itemPrice");

        if (itemId != null && itemName != null && itemPrice != null) {
            int id = Integer.parseInt(itemId);
            int price = Integer.parseInt(itemPrice);
            GioHang61.addItemToCart(id, itemName, price);
        }
    %>
    <table border="1">
        <tr>
            <th>T�n</th>
            <th>S? L??ng</th>
            <th>Gi�</th>
            <th>X�a</th>
        </tr>
        <%
            List<MatHang61> cartItems = GioHang61.getCartItems();
            for (MatHang61 item : cartItems) {
        %>
            <tr>
                <td><%= item.getName() %></td>
                <td><%= item.getNumber() %></td>
                <td><%= item.getPrice() %></td>
                <td>
                    <form action="cart.jsp" method="post">
                        <input type="hidden" name="removeItemId" value="<%= item.getID2() %>">
                        <input type="submit" value="X�a">
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>
    <form action="submitOrder.jsp" method="post">
        <input type="submit" value="X�c Nh?n ??n H�ng">
    </form>
</body>
</html>
