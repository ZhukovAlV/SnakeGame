public class MyGame {

    // Двухмерный массив игрового поля
    public int[][] mas;

    //Направление движения
    public int napr;

    // Координады головы змейки
    private int gX, gY;

    // Количество очков
    public int kol;

    // Конструктор
    public MyGame() {
        this.mas = new int[30][30];
    }

    // Генерация нового объекта поедания случайно
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

        // Начальное направление - влево
        napr = 0;

        // Количество очков 0
        kol = 0;

        // Записываем в переменные координаты головы змейки
        gX = gY = 15;

        // Размещаем в центре голову змейки
        mas[gX][gY] = 1;

        // Создаем объект для поедания
        makeObject();
    }

    // Перемещение головы змейки
    public void peremGolova() {

        // Сразу удаляем голову змейки из текущей ячейки
        mas[gY][gX] = 0;

        // Если текущее направление влево
        if (napr == 0) {

            if ((gX - 1) >= 0) gX--;
                else gX = 29;

        }

        // Перемещаем голову змейки в новую позицию
        mas[gY][gX] = 1;
    }
}
