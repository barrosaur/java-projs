import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        // adjust size (width, height)
        frame.setSize(500, 500);

        // title
        frame.setTitle("TLauncher");

        // when we press the x button on the window, it won't close the program
        // to fix that
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // to prevent screen resizing
        // frame.setResizable(false);

        // To change the icon
        // ImageIcon image = new Image("image.png")
        // frame.setIconImage(image.getImage())

        // To change background color
        frame.getContentPane().setBackground(Color.WHITE);
        // to make our own color, in the set background make a new Color object and set it to
        // either a hexadecimal or rgb

        // For labeling
        JLabel label = new JLabel();
        label.setText("NIG--");
        frame.add(label);

        frame.setVisible(true); //pops the frame up
    }
}