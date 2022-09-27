// Frame.java - Etude 7 - Oliver O'Connor - 6529968
import javax.swing.*;
public class Frame extends JFrame{
    Panel panel;
    Frame(){
        Panel panel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
}
