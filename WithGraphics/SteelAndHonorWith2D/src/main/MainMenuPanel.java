package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    
    public MainMenuPanel(ActionListener startGameAction, ActionListener quitAction) {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900, 600));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(15, 0, 15, 0);

        JLabel title = new JLabel("STEEL AND HONOR");
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.YELLOW);
        gbc.gridy = 0;
        add(title, gbc);

        JButton newGame = new JButton("NEW GAME");
        JButton quit = new JButton("QUIT");

   
        JButton[] buttons = {newGame, quit};
        for (JButton b : buttons) {
            b.setFont(new Font("Serif", Font.BOLD, 28));
            b.setForeground(Color.YELLOW);
            b.setBackground(new Color(0, 0, 0, 200));
            b.setFocusPainted(false);
            gbc.gridy++;
            add(b, gbc);
        }

        newGame.addActionListener(startGameAction);
        quit.addActionListener(quitAction);
    }
}
