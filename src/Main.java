import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("Игра Змейка");
        frame.setBounds(0,0,800,650);

        // Создаем холст (панель), на котором все разместим
        MyPanel panel = new MyPanel();


        frame.add(panel);
        frame.setVisible(true);
    }

}