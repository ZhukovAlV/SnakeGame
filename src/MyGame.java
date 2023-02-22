public class MyGame {

    // Двухмерный массив игрового поля
    public int[][] mas;

    // Направление движения
    public int napr;

    // Координады головы змейки
    private int gX, gY;

    // Количество очков
    public int kol;

    // Признак окончания игры
    public boolean endg;

    // Направление движения
    public int newNapr;

    // Длина змейки
    public int dlina;

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

        // Размещаем в центре змейку диной 3 ячейки
        mas[14][14] = 1;
        mas[14][15] = 2;
        mas[14][16] = 3;
        dlina = 3;

        // Записываем в переменные координаты головы змейки
        gX = gY = 14;

        // Выставляем признак окончания игры, что неокончена
        endg = false;

        // Создаем объект для поедания
        makeObject();
    }

    // Перемещение головы змейки
    public int peremGolova() {

        // Если текущее направление влево
        if (napr == 0) {
            if ((gX - 1) >= 0) gX--;
            else gX = 29;

        // Если текущее направление вверх
        } else if (napr == 1) {
            if ((gY - 1) >= 0) gY--;
            else gY = 29;

        // Если текущее направление вправо
        } else if (napr == 2) {
            if ((gX + 1) <= 29) gX++;
            else gX = 0;

        // Если текущее направление вниз
        } else if (napr == 3) {
            if ((gY + 1) <= 29) gY++;
            else gY = 0;
        }

        // Результат
        int rez = 0;

        // Если съеден объект
        if (mas[gY][gX] == -1) rez = 1;
            // Если перемещение в другую ячейку
        else if (mas[gY][gX] == 0) rez = 2;
            // Если попадание в туловище змейки
        else if (mas[gY][gX] > 0) rez = 3;

        // Вместо перемещения головы установим -2
        mas[gY][gX] = -2;

        // Возвращаем результат
        return rez;
    }

    // Перемещение головы змейки
    public void perem() {

        // Узнаем результат перемещения
        int flag = peremGolova();

        // Если змейка врезалась в себя конец игры
        if (flag == 3) endg = true;

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                // Если значение больше 0, то увеличиваем на 1
                if (mas[i][j] > 0) mas[i][j]++;
                // Если значение -2, то меняем на 1
                if (mas[i][j] == -2) mas[i][j] = 1;

                // Если не было поедания объекта, в хвост записываем 0
                if (flag != 1) {
                    if (mas[i][j] == dlina + 1) mas[i][j] = 0;
                }
            }
        }

        // Если съеден объект, увеличиваем длину на 1
        if (flag == 1) {
            dlina++;

            // Генерируем объет для поедания
            makeObject();

            // Увеличиваем количество очков
            kol += 10;
        }

        // Изменяем направление движения
        povorot();
    }

    // Изменение направления движения змейки
    private void povorot() {

        if(Math.abs(newNapr - napr) != 2) {
            napr = newNapr;
        }
    }
}
