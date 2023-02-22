public class MyGame {

    // ���������� ������ �������� ����
    public int[][] mas;

    // ����������� ��������
    public int napr;

    // ���������� ������ ������
    private int gX, gY;

    // ���������� �����
    public int kol;

    // ������� ��������� ����
    public boolean endg;

    // ����������� ��������
    public int newNapr;

    // ����� ������
    public int dlina;

    // �����������
    public MyGame() {
        this.mas = new int[30][30];
    }

    // ��������� ������ ������� �������� ��������
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

    // ������ ����
    public void start() {

        // ��������� ������ 0
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                mas[i][j] = 0;
            }
        }

        // ��������� ����������� - �����
        napr = 0;

        // ���������� ����� 0
        kol = 0;

        // ��������� � ������ ������ ����� 3 ������
        mas[14][14] = 1;
        mas[14][15] = 2;
        mas[14][16] = 3;
        dlina = 3;

        // ���������� � ���������� ���������� ������ ������
        gX = gY = 14;

        // ���������� ������� ��������� ����, ��� ����������
        endg = false;

        // ������� ������ ��� ��������
        makeObject();
    }

    // ����������� ������ ������
    public int peremGolova() {

        // ���� ������� ����������� �����
        if (napr == 0) {
            if ((gX - 1) >= 0) gX--;
            else gX = 29;

        // ���� ������� ����������� �����
        } else if (napr == 1) {
            if ((gY - 1) >= 0) gY--;
            else gY = 29;

        // ���� ������� ����������� ������
        } else if (napr == 2) {
            if ((gX + 1) <= 29) gX++;
            else gX = 0;

        // ���� ������� ����������� ����
        } else if (napr == 3) {
            if ((gY + 1) <= 29) gY++;
            else gY = 0;
        }

        // ���������
        int rez = 0;

        // ���� ������ ������
        if (mas[gY][gX] == -1) rez = 1;
            // ���� ����������� � ������ ������
        else if (mas[gY][gX] == 0) rez = 2;
            // ���� ��������� � �������� ������
        else if (mas[gY][gX] > 0) rez = 3;

        // ������ ����������� ������ ��������� -2
        mas[gY][gX] = -2;

        // ���������� ���������
        return rez;
    }

    // ����������� ������ ������
    public void perem() {

        // ������ ��������� �����������
        int flag = peremGolova();

        // ���� ������ ��������� � ���� ����� ����
        if (flag == 3) endg = true;

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                // ���� �������� ������ 0, �� ����������� �� 1
                if (mas[i][j] > 0) mas[i][j]++;
                // ���� �������� -2, �� ������ �� 1
                if (mas[i][j] == -2) mas[i][j] = 1;

                // ���� �� ���� �������� �������, � ����� ���������� 0
                if (flag != 1) {
                    if (mas[i][j] == dlina + 1) mas[i][j] = 0;
                }
            }
        }

        // ���� ������ ������, ����������� ����� �� 1
        if (flag == 1) {
            dlina++;

            // ���������� ����� ��� ��������
            makeObject();

            // ����������� ���������� �����
            kol += 10;
        }

        // �������� ����������� ��������
        povorot();
    }

    // ��������� ����������� �������� ������
    private void povorot() {

        if(Math.abs(newNapr - napr) != 2) {
            napr = newNapr;
        }
    }
}
