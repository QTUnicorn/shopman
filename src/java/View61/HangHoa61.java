package View61;

import Model61.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HangHoa61 {

    public String setHangHoa(String tenMatHang, String maMatHang, String loaiMatHang, int soLuong, double gia, String moTa) {
        String sql = "INSERT INTO hanghoa (Name, Price, Number, Description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tenMatHang);
            pstmt.setDouble(2, gia);
            pstmt.setInt(3, soLuong);
            pstmt.setString(4, moTa);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                return "Thêm mặt hàng thành công!";
            } else {
                return "Thêm mặt hàng thất bại!";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Lỗi khi thêm mặt hàng!";
        }
    }
}
