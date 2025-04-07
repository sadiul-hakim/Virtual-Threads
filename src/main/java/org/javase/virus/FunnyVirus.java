package org.javase.virus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class FunnyVirus {
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int height = (int) screenSize.getHeight();
    private final int width = (int) screenSize.getWidth();
    private final Random random = new Random();

    public void blockAll() throws Exception {
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_0);
        robot.mouseMove(random.nextInt(width), random.nextInt(height));
    }

    public void popUp() {
        JWindow window = new JWindow();
        JLabel label = new JLabel("You are attacked with funny virus!", JLabel.CENTER);
        window.add(label);
        window.setSize(150, 120);
        window.setLocation(random.nextInt(width), random.nextInt(height));
        window.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        FunnyVirus fv = new FunnyVirus();

        for (int i = 1; i <= 200; i++) {
            fv.blockAll();
            fv.popUp();
        }
    }
}
