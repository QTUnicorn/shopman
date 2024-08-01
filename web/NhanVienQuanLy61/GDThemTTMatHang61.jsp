<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>

<!DOCTYPE html>
<html>
<head>
    <title>Th�m Th�ng Tin M?t H�ng</title>
</head>
<body>
    <h1>Th�m Th�ng Tin M?t H�ng</h1>
    <form action="addItem.jsp" method="post">
        <label for="itemName">T�n m?t h�ng:</label>
        <input type="text" id="itemName" name="itemName" required><br><br>
        
        <label for="itemCode">M� m?t h�ng:</label>
        <input type="text" id="itemCode" name="itemCode" required><br><br>

        <label for="itemType">Lo?i m?t h�ng:</label>
        <input type="text" id="itemType" name="itemType" required><br><br>

        <label for="itemQuantity">S? l??ng:</label>
        <input type="number" id="itemQuantity" name="itemQuantity" required><br><br>

        <label for="itemPrice">Gi�:</label>
        <input type="number" id="itemPrice" name="itemPrice" required><br><br>

        <label for="itemDescription">M� t?:</label>
        <textarea id="itemDescription" name="itemDescription" required></textarea><br><br>

        <input type="submit" value="Th�m M?t H�ng">
    </form>

    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String itemName = request.getParameter("itemName");
            String itemCode = request.getParameter("itemCode");
            String itemType = request.getParameter("itemType");
            int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
            int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
            String itemDescription = request.getParameter("itemDescription");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabaseName", "yourUsername", "yourPassword");

                String query = "INSERT INTO MatHang61 (Name, Price, Number, Description) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, itemName);
                ps.setInt(2, itemPrice);
                ps.setInt(3, itemQuantity);
                ps.setString(4, itemDescription);

                int result = ps.executeUpdate();

                if (result > 0) {
                    out.println("<p>M?t h�ng ?� ???c th�m th�nh c�ng!</p>");
                } else {
                    out.println("<p>C� l?i x?y ra, vui l�ng th? l?i.</p>");
                }

                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p>C� l?i x?y ra: " + e.getMessage() + "</p>");
            }
        }
    %>
</body>
</html>
