import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    // ������ ����
    // private MyGame myGame;

    // ������� ��������� � ��������� ������ ����
    //private Timer tmDraw;

    // �����������, ������������ � ����
    Image fon, telo, golova, ob, endg;

    // ������� ��� ���������� �����
    private JLabel lb;

    // ��� ������
    private JButton btn1, btn2;

    public MyPanel() {

        setLayout(null);

        lb = new JLabel("����: 0");
        lb.setForeground(Color.DARK_GRAY);
        lb.setFont(new Font("serif", 0,30));
        lb.setBounds(630,200,150,50);
        add(lb);

        btn1 = new JButton("����� ����");
        btn1.setForeground(Color.DARK_GRAY);
        btn1.setFont(new Font("serif", 0,20));
        btn1.setBounds(630,30,150,50);
        add(btn1);

        btn2 = new JButton("���������");
        btn2.setForeground(Color.DARK_GRAY);
        btn2.setFont(new Font("serif", 0,20));
        btn2.setBounds(630,100,150,50);
        add(btn2);
    }
}
