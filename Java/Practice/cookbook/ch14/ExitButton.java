import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ExitButton extends JFrame {
    public ExitButton() {
        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(50, 60, 80, 30);
        quitButton.setToolTipText("This is a quit Button");
        quitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        JButton consolePrintButton = new JButton("Console Button");
        consolePrintButton.setToolTipText("This is a print Button");
        consolePrintButton.setBounds(150, 60, 200, 30);
        consolePrintButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hey! I being printed this Console.");
            }
        });

        panel.add(quitButton);
        panel.add(consolePrintButton);
        panel.setToolTipText("A Panel Contianer");

        setTitle("Quit button");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ExitButton ex = new ExitButton();
        ex.setVisible(true);
    }
}