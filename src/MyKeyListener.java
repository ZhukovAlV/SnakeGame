import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

        if (e.getKeyCode() == KeyEvent.VK_LEFT) MyGame.napr = 2;
        else if (e.getKeyCode() == KeyEvent.VK_UP) MyGame.napr = 1;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) MyGame.napr = 0;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) MyGame.napr = 3;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
