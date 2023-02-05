import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    // Логика игры
    // private MyGame myGame;

    // Таймеры отрисовки и изменения логики игры
    //private Timer tmDraw;

    // Изображения, используемые в игре
    Image fon, telo, golova, ob, endg;

    // Надпись для количества очков
    private JLabel lb;

    // Две кнопки
    private JButton btn1, btn2;

    public MyPanel() {

        setLayout(null);

        lb = new JLabel("Очки: 0");
        lb.setForeground(Color.DARK_GRAY);
        lb.setFont(new Font("serif", 0,30));
        lb.setBounds(630,200,150,50);
        add(lb);

        btn1 = new JButton("Новая игра");
        btn1.setForeground(Color.DARK_GRAY);
        btn1.setFont(new Font("serif", 0,20));
        btn1.setBounds(630,30,150,50);
        add(btn1);

        btn2 = new JButton("Завершить");
        btn2.setForeground(Color.DARK_GRAY);
        btn2.setFont(new Font("serif", 0,20));
        btn2.setBounds(630,100,150,50);
        add(btn2);
    }
}
