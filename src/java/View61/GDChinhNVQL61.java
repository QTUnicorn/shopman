package View61;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GDChinhNVQL61 extends JFrame {

    public GDChinhNVQL61() {
        setTitle("Giao Diện Chính Quản Lý");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton manageItemsButton = new JButton("Quản Lý Thông Tin Mặt Hàng");
        
        manageItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GDThemTTMatHang61 addItemFrame = new GDThemTTMatHang61();
                addItemFrame.setVisible(true);
            }
        });
        
        panel.add(manageItemsButton);
        add(panel);
    }

    public static void main(String[] args) {
        GDChinhNVQL61 mainFrame = new GDChinhNVQL61();
        mainFrame.setVisible(true);
    }
}
