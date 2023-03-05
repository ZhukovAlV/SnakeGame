import javax.swing.*;

/**
 * Класс окна игрового поля
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Игра Змейка");
        setBounds(0,0,800,650);

        // Создаем холст (панель), на котором все разместим
        MyPanel panel = new MyPanel();
        add(panel);

        setVisible(true);
    }
}
