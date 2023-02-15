import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

/**
 * ����� ������ �������� ����
 */
public class MyPanel extends JPanel {

    // ������ ����
    private MyGame myGame;

    // ������� ��������� � ��������� ������ ����
    private Timer tmDraw, tmUpdate;

    // �����������, ������������ � ����
    private Image fon, telo, golova, ob, endg;

    // ������� ��� ���������� �����
    private JLabel lb;

    // ��� ������
    private JButton btn1, btn2;

    // �����������
    public MyPanel() {

        // ��������� ��������
        try {
            fon = ImageIO.read(new File("img/fon.jpg"));
            telo = ImageIO.read(new File("img/telo.png"));
            golova = ImageIO.read(new File("img/golova.png"));
            ob = ImageIO.read(new File("img/ob.png"));
            endg = ImageIO.read(new File("img/endg.jpg"));
        } catch (IOException e) {
            System.out.println("�������� �� �����������");
        }

        // ������� ������ ����
        myGame = new MyGame();
        myGame.start();

        tmDraw = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
       // tmDraw = new Timer(20, e -> repaint());
        tmDraw.start();

        tmUpdate = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ���������� ������ ������
                myGame.peremGolova();

                // ������� ���������� � ���������� �����
                lb.setText("����" + myGame.kol);
            }
        });
        tmUpdate.start();

        // ����� ��������� �������� ��� �����
        setLayout(null);

        // ���� ����
        lb = new JLabel("����: 0");
        lb.setForeground(Color.WHITE);
        lb.setFont(new Font("serif", 0,30));
        lb.setBounds(630,200,150,50);
        add(lb);

        btn1 = new JButton("����� ����");
        btn1.setForeground(Color.BLUE);
        btn1.setFont(new Font("serif", 0,20));
        btn1.setBounds(630,30,150,50);
        btn1.addChangeListener(event -> myGame.start());
        add(btn1);

        btn2 = new JButton("�����");
        btn2.setForeground(Color.RED);
        btn2.setFont(new Font("serif", 0,20));
        btn2.setBounds(630,100,150,50);
        btn2.addChangeListener(event -> System.exit(0));
        add(btn2);

        // ���������� ��������� �� ������� ����������
        addKeyListener(new MyKey());

        // ������ ������ � ������ ��� ������ ������� �� ����������
        setFocusable(true);
    }

    // ����� ���������
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        // ��������� ����
        gr.drawImage(fon, 0, 0, 800, 650, null);

        // ��������� �������� ���� �� ��������� �������
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                    // ������ ���� ������, ���� ������ ��������
                    if (myGame.mas[i][j] == 1) {
                        gr.drawImage(golova, 10 + j*20, 10 + i*20,20,20,null);
                    } else if (myGame.mas[i][j] == -1) {
                        gr.drawImage(ob, 10 + j*20, 10 + i*20,20,20,null);
                    }

            }
        }

        // ��������� ����� �������� ����
        gr.setColor(Color.BLUE);
        for (int i = 0; i < 30; i++) {
            gr.drawLine(10 + i*20,10, 10 + i*20, 610);
            gr.drawLine(10,10 + i*20, 610, 10 + i*20);
        }
    }

    class MyKey implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            // ��������� ���� ������� �������
            int key = e.getKeyCode();

            // ���� ������� ����� �� ���������, �� ������ �����������
            switch (key) {
                case KeyEvent.VK_LEFT -> myGame.napr = 0;
                case KeyEvent.VK_UP -> myGame.napr = 1;
                case KeyEvent.VK_RIGHT -> myGame.napr = 2;
                case KeyEvent.VK_DOWN -> myGame.napr = 3;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
