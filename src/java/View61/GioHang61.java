package View61;

import Model61.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GioHang61 {

    private static List<MatHang61> cartItems = new ArrayList<>();

    public static void addItemToCart(int id, String name, int price) {
        for (MatHang61 item : cartItems) {
            if (item.getID2() == id) {
                item.setNumber(item.getNumber() + 1);
                return;
            }
        }
        MatHang61 newItem = new MatHang61();
        newItem.setID2(id);
        newItem.setName(name);
        newItem.setPrice(price);
        newItem.setNumber(1);
        cartItems.add(newItem);
    }

    public static List<MatHang61> getCartItems() {
        return cartItems;
    }

    public static void removeItemFromCart(int id) {
        cartItems.removeIf(item -> item.getID2() == id);
    }

    public static boolean submitOrder() {
        String sql = "INSERT INTO DonHang61 (Description, Name, Discount, Transportfee, Status, Totalprice, Date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            for (MatHang61 item : cartItems) {
                // Thêm các thông tin của từng mặt hàng vào cơ sở dữ liệu
                pstmt.setString(1, item.getDescription());
                pstmt.setInt(2, item.getID2());
                pstmt.setString(3, ""); // Giảm giá (nếu có)
                pstmt.setString(4, ""); // Phí vận chuyển (nếu có)
                pstmt.setString(5, ""); // Trạng thái đơn hàng (nếu có)
                pstmt.setInt(6, item.getPrice() * item.getNumber()); // Tổng giá trị
                pstmt.setString(7, ""); // Ngày đặt hàng (nếu có)
                pstmt.executeUpdate();
            }
            cartItems.clear(); 
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
