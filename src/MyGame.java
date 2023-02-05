public class MyGame {

    // Двухмерный массив игрового поля
    public int[][] mas;

    // Конструктор
    public MyGame() {
        this.mas = new int[30][30];
    }

    // Генерация нового объекта случайно
    private void makeObject() {

        while(true) {
            int x = (int)(Math.random()*30);
            int y = (int)(Math.random()*30);

            if(mas[x][y] == 0) {
                mas[x][y] = -1;
                break;
            }
        }
    }

    // Запуск игры
    public void start() {

        // Заполняем массив 0
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                mas[i][j] = 0;
            }
        }

        // Размещаем в центре голову змейки
        mas[15][15] = 1;

        // Создаем обьъект для поедания
        makeObject();
    }
}
