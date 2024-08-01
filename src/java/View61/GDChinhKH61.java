package View61;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GDChinhKH61 extends JFrame {

    public GDChinhKH61() {
        setTitle("Giao Diện Chính Khách Hàng");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton orderButton = new JButton("Đặt Hàng");
        
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GDTimMatHang61 searchItemFrame = new GDTimMatHang61();
                searchItemFrame.setVisible(true);
            }
        });
        
        panel.add(orderButton);
        add(panel);
    }

    public static void main(String[] args) {
        GDChinhKH61 mainFrame = new GDChinhKH61();
        mainFrame.setVisible(true);
    }
}
