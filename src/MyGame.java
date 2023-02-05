public class MyGame {

    // ���������� ������ �������� ����
    public int[][] mas;

    //����������� ��������
    public int napr;

    // ���������� ������ ������
    private int gX, gY;

    // ���������� �����
    public int kol;

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

        // ���������� � ���������� ���������� ������ ������
        gX = gY = 15;

        // ��������� � ������ ������ ������
        mas[gX][gY] = 1;

        // ������� ������ ��� ��������
        makeObject();
    }

    // ����������� ������ ������
    public void peremGolova() {

        // ����� ������� ������ ������ �� ������� ������
        mas[gY][gX] = 0;

        // ���� ������� ����������� �����
        if (napr == 0) {

            if ((gX - 1) >= 0) gX--;
                else gX = 29;

        }

        // ���������� ������ ������ � ����� �������
        mas[gY][gX] = 1;
    }
}
