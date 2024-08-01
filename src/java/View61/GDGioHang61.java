package View61;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GDGioHang61 extends JFrame {

    private JTable cartTable;

    public GDGioHang61() {
        setTitle("Giỏ Hàng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel cartLabel = new JLabel("Giỏ Hàng");
        cartLabel.setBounds(10, 20, 100, 25);
        panel.add(cartLabel);

        cartTable = new JTable(new DefaultTableModel(new Object[]{"Tên", "Số Lượng", "Giá", "Xóa"}, 0));
        JScrollPane scrollPane = new JScrollPane(cartTable);
        scrollPane.setBounds(10, 60, 560, 240);
        panel.add(scrollPane);

        JButton submitButton = new JButton("Xác Nhận Đơn Hàng");
        submitButton.setBounds(10, 320, 200, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean result = GioHang61.submitOrder();
                if (result) {
                    System.out.println("Đơn hàng đã được lưu thành công.");
                } else {
                    System.out.println("Lỗi khi lưu đơn hàng.");
                }
            }
        });

        updateCartTable();
        add(panel);
    }

    private void updateCartTable() {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0);
        List<MatHang61> cartItems = GioHang61.getCartItems();
        for (final MatHang61 item : cartItems) {
            JButton removeButton = new JButton("Xóa");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GioHang61.removeItemFromCart(item.getID2());
                    updateCartTable();
                }
            });
            model.addRow(new Object[]{item.getName(), item.getNumber(), item.getPrice(), removeButton});
        }
    }
}
