import javax.swing.*;

/**
 * Класс окна игрового поля
 */
public class MyFrame extends JFrame {

    public MyFrame() {
        // Заголовок игры
        setTitle("Игра Змейка");

        // Границы расположения окна
        setBounds(0,0,800,650);

        // Создаем холст (панель), на котором все разместим
        MyPanel myPanel = new MyPanel();
        add(myPanel);

        // Завершение программы при закрытии окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Запрет на изменение окна
        setResizable(false);

        // Отображаем окно
        setVisible(true);
    }
}
