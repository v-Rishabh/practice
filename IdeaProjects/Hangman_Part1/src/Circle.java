import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.color.*;


    public class Circle extends JPanel{
        public void paint(Graphics g){
            setSize(500,500);
            g.drawOval(100,100,50,50);
            g.drawLine(100,100,200,200);
        }

        public static void main(String args[]){
            JFrame MainFrame = new JFrame();

            MainFrame.setSize(600,60);

            Circle CirclePanel = new Circle();
            MainFrame.add(CirclePanel);
            MainFrame.setVisible(true);
        }
    }

