package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Steel And Honor");


        MainMenuPanel menu = new MainMenuPanel(
            e -> {
              
                window.getContentPane().removeAll();
                GamePanel gamePanel = new GamePanel();
                window.add(gamePanel);
                gamePanel.setFocusable(true);
                gamePanel.requestFocusInWindow();
                window.revalidate();
                window.pack();
                gamePanel.StarGameThread();
            },
            e -> System.exit(0)
        );

        window.add(menu);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
