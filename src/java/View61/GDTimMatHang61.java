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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GDTimMatHang61 extends JFrame {

    private JTextField searchField;
    private JTable resultTable;

    public GDTimMatHang61() {
        setTitle("Tìm Mặt Hàng");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel searchLabel = new JLabel("Tên mặt hàng:");
        searchLabel.setBounds(10, 20, 100, 25);
        panel.add(searchLabel);

        searchField = new JTextField(20);
        searchField.setBounds(120, 20, 165, 25);
        panel.add(searchField);

        JButton searchButton = new JButton("Tìm Kiếm");
        searchButton.setBounds(300, 20, 100, 25);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = searchField.getText();
                List<MatHang61> items = getHangHoa(itemName);
                updateResultTable(items);
            }
        });

        resultTable = new JTable(new DefaultTableModel(new Object[]{"Tên", "Giá", "Số Lượng", "Thêm vào giỏ"}, 0));
        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBounds(10, 60, 560, 290);
        panel.add(scrollPane);

        add(panel);
    }

    private List<MatHang61> getHangHoa(String itemName) {
        // Lấy danh sách mặt hàng từ cơ sở dữ liệu
        return MatHang61.getHangHoa(itemName);
    }

    private void updateResultTable(List<MatHang61> items) {
        DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
        model.setRowCount(0);
        for (final MatHang61 item : items) {
            JButton addToCartButton = new JButton("Thêm vào giỏ");
            addToCartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GioHang61.addItemToCart(item.getID2(), item.getName(), item.getPrice());
                }
            });
            model.addRow(new Object[]{item.getName(), item.getPrice(), item.getNumber(), addToCartButton});
        }
    }
}
