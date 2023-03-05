import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class MyPanel extends JPanel {

    // Логика игры
    private MyGame myGame;

    // Изображения, используемые в игре
    private Image fon, telo, golova, ob, endg;

    // Две кнопки
    private JButton btn1, btn2;

    // Таймер
    private Timer update;

    public MyPanel() {
        myGame = new MyGame();
        myGame.start();

        // Загружаем картинки
        try {
            fon = ImageIO.read(new File("img/fon.jpg"));
            telo = ImageIO.read(new File("img/telo.png"));
            golova = ImageIO.read(new File("img/golova.png"));
            ob = ImageIO.read(new File("img/ob.png"));
            endg = ImageIO.read(new File("img/endg.jpg"));
        } catch (Exception e) {
            System.out.println("Картинки не загрузились");
        }

        // Чтобы размещать элементы как хотим
        setLayout(null);

        btn1 = new JButton("Новая игра");
        btn1.setForeground(Color.BLUE);
        btn1.setFont(new Font("serif", 0,20));
        btn1.setBounds(630,30,150,50);
        add(btn1);

        btn2 = new JButton("Выход");
        btn2.setForeground(Color.RED);
        btn2.setFont(new Font("serif", 0,20));
        btn2.setBounds(630,100,150,50);
        add(btn2);

        addKeyListener(new MyKeyListener());
        setFocusable(true);

        update = new Timer(500, event -> {
            if (myGame.napr == 0) {
                if (myGame.gX == 29) myGame.gX = 0;
                else myGame.gX++;
            } else if (myGame.napr == 1) {
                if (myGame.gY == 0) myGame.gY = 29;
                else myGame.gY--;
            } else if (myGame.napr == 2) {
                if (myGame.gX == 0) myGame.gX = 29;
                else myGame.gX--;
            } else if (myGame.napr == 3) {
                if (myGame.gY == 29) myGame.gY = 0;
                else myGame.gY++;
            }

            myGame.perem();

            repaint();
        });
        update.start();

    }

    // Метод отрисовки
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        // Отрисовка фона
        gr.drawImage(fon, 0, 0, 800, 650, null);

        // Отрисовка сетки игрового поля
        gr.setColor(Color.BLUE);
        for (int i = 0; i <= 30; i++) {        Graphics2D g2 = (Graphics2D) gr;
            BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
            g2.setStroke(stroke);
            gr.drawLine(10 + i*20,10, 10 + i*20, 610);
            gr.drawLine(10,10 + i*20, 610, 10 + i*20);
        }

        // Нарисуем змейку, яблоко и хвост
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (myGame.mas[i][j] == 1) {
                    gr.drawImage(golova, 10 + j*20, 10 + i*20,20,20,null);
                } else if (myGame.mas[i][j] == -1) {
                    gr.drawImage(ob, 10 + j*20, 10 + i*20,20,20,null);
                } else if (myGame.mas[i][j] == 2) {
                    gr.drawImage(telo, 10 + j*20, 10 + i*20,20,20,null);
                }
            }
        }
    }

    class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyCode());

            if (e.getKeyCode() == KeyEvent.VK_LEFT) myGame.napr = 1;
            else if (e.getKeyCode() == KeyEvent.VK_UP) myGame.napr = 2;
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) myGame.napr = 3;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) myGame.napr = 0;
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
