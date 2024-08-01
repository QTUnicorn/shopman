package View61;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GDThemTTMatHang61 extends JFrame {

    private JTextField tenMatHangField;
    private JTextField maMatHangField;
    private JTextField loaiMatHangField;
    private JTextField soLuongField;
    private JTextField giaField;
    private JTextField moTaField;

    public GDThemTTMatHang61() {
        setTitle("Thêm Mặt Hàng");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel tenMatHangLabel = new JLabel("Tên Mặt Hàng:");
        tenMatHangLabel.setBounds(10, 20, 100, 25);
        panel.add(tenMatHangLabel);

        tenMatHangField = new JTextField(20);
        tenMatHangField.setBounds(120, 20, 165, 25);
        panel.add(tenMatHangField);

        JLabel maMatHangLabel = new JLabel("Mã Mặt Hàng:");
        maMatHangLabel.setBounds(10, 50, 100, 25);
        panel.add(maMatHangLabel);

        maMatHangField = new JTextField(20);
        maMatHangField.setBounds(120, 50, 165, 25);
        panel.add(maMatHangField);

        JLabel loaiMatHangLabel = new JLabel("Loại Mặt Hàng:");
        loaiMatHangLabel.setBounds(10, 80, 100, 25);
        panel.add(loaiMatHangLabel);

        loaiMatHangField = new JTextField(20);
        loaiMatHangField.setBounds(120, 80, 165, 25);
        panel.add(loaiMatHangField);

        JLabel soLuongLabel = new JLabel("Số Lượng:");
        soLuongLabel.setBounds(10, 110, 100, 25);
        panel.add(soLuongLabel);

        soLuongField = new JTextField(20);
        soLuongField.setBounds(120, 110, 165, 25);
        panel.add(soLuongField);

        JLabel giaLabel = new JLabel("Giá:");
        giaLabel.setBounds(10, 140, 100, 25);
        panel.add(giaLabel);

        giaField = new JTextField(20);
        giaField.setBounds(120, 140, 165, 25);
        panel.add(giaField);

        JLabel moTaLabel = new JLabel("Mô Tả:");
        moTaLabel.setBounds(10, 170, 100, 25);
        panel.add(moTaLabel);

        moTaField = new JTextField(20);
        moTaField.setBounds(120, 170, 165, 25);
        panel.add(moTaField);

        JButton submitButton = new JButton("Xác Nhận");
        submitButton.setBounds(10, 210, 150, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenMatHang = tenMatHangField.getText();
                String maMatHang = maMatHangField.getText();
                String loaiMatHang = loaiMatHangField.getText();
                int soLuong = Integer.parseInt(soLuongField.getText());
                double gia = Double.parseDouble(giaField.getText());
                String moTa = moTaField.getText();

//                HangHoa61 HangHoa = new HangHoa61();
//                String ketQua = hangHoa.setHangHoa(tenMatHang, maMatHang, loaiMatHang, soLuong, gia, moTa);

//                System.out.println(ketQua);
            }
        });

        add(panel);
    }
}
