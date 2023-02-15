import javax.swing.*;

/**
 * ����� ���� �������� ����
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        // ��������� ����
        setTitle("���� ������");

        // ������� ������������ ����
        setBounds(0,0,800,650);

        // ������� ����� (������), �� ������� ��� ���������
        MyPanel myPanel = new MyPanel();
        add(myPanel);

        // ���������� ��������� ��� �������� ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ������ �� ��������� ����
        setResizable(false);

        // ���������� ����
        setVisible(true);
    }
}
