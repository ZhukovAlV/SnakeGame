public class MyGame {

    // Двухмерный массив игрового поля
    public int[][] mas = new int[30][30];

    // Координады головы змейки
    public int gX, gY;

    // Направление движения
    int napr;

    // Запуск игры
    public void start() {

        // Заполняем массив 0
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                mas[i][j] = 0;
            }
        }

        // Начальное направление
        napr = 0;

        // Записываем в переменные координаты головы змейки
        gX = 14;
        gY = 14;
        mas[gX][gY] = 1;

        // Тело
        mas[14][15] = 2;
        mas[14][16] = 2;

        // Яблоко
        mas[20][16] = -1;
    }


    void perem() {

        // Удаляем старое положение головы змейки
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (mas[i][j] == 1) mas[i][j] = 0;
            }
        }

        // Прорисовывем новое положение головы змейки
        mas[gX][gY] = 1;

 /*       int x = (int)(Math.random()*30);
        int y = (int)(Math.random()*30);

        if (gX == appleX && gY == appleY) {
            appleX = x;
            appleY = y;
        }
        */

            // TODO скорость увеличить
    }
}
