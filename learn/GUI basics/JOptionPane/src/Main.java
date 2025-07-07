import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        /*
            JOptionPane -- Dialog Box that prompts users for a value or informs them of something
        */

//        JOptionPane.showMessageDialog(null, "Warning", "Title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Warning", "Title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Warning", "Title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Warning", "Title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Warning", "Title", JOptionPane.ERROR_MESSAGE);

        // with responses
        // JOptionPane.showConfirmDialog(null, "Really?", "Title", JOptionPane.YES_NO_CANCEL_OPTION);

        // show input dialog
        // JOptionPane.showInputDialog("Enter your card account and password below OR ELSE");

        // The one that combines them all together
        JOptionPane.showOptionDialog(null, "YEAHH", "Title",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, null, 0);

    }
}