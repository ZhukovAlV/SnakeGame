import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyPanel extends JPanel {

    // Изображения, используемые в игре
    private Image fon, telo, golova, ob, endg;

    // Две кнопки
    private JButton btn1, btn2;

    // Таймер
    private Timer update;

    // Логика игры
    private MyGame myGame;

    public MyPanel() {

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
        btn2.addActionListener(eventExit -> System.exit(0));

        update = new Timer(250, event -> {

            if (MyGame.napr == 0) {
                if (MyGame.gX == 29) MyGame.gX = 0;
                else MyGame.gX++;
            } else if (MyGame.napr == 1) {
                if (MyGame.gY == 0) MyGame.gY = 29;
                else MyGame.gY--;
            } else if (MyGame.napr == 2) {
                if (MyGame.gX == 0) MyGame.gX = 29;
                else MyGame.gX--;
            } else if (MyGame.napr == 3) {
                if (MyGame.gY == 29) MyGame.gY = 0;
                else MyGame.gY++;
            }

            repaint();
        });
        update.start();


        addKeyListener(new MyKeyListener());
        setFocusable(true);
    }

    // Метод отрисовки
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        // Отрисовка фона
        gr.drawImage(fon, 0, 0, 800, 650, null);

        // Отрисовка сетки игрового поля
        gr.setColor(Color.BLUE);
        for (int i = 0; i <= 30; i++) {
            gr.drawLine(10 + i*20,10, 10 + i*20, 610);
            gr.drawLine(10,10 + i*20, 610, 10 + i*20);
        }

        // Нарисуем змейку
        gr.drawImage(golova, 10 + (myGame.gX * 20), 10 + (myGame.gY * 20),20 ,20,null);
        gr.drawImage(ob, 30, 30,20 ,20,null);

    }
}
