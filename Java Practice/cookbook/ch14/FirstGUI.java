import java.awt.*;
import javax.swing.*;

class FirstGUI extends JFrame {

    static final long serialVersionUID = 536871008;

    public FirstGUI() {
        setTitle("First GUI using Java Swing");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        FirstGUI FG = new FirstGUI();
        FG.setVisible(true);
    }
}