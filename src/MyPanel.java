import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MyPanel extends JPanel {

    // Изображения, используемые в игре
    private Image fon, telo, golova, ob, endg;

    // Две кнопки
    private JButton btn1, btn2;

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
        gr.drawImage(golova, 10, 10,20 ,20,null);
        gr.drawImage(ob, 30, 30,20 ,20,null);

    }
}
