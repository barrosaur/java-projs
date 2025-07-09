import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;

    MyFrame() {
        this.setTitle("Selecting a file...");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select a file");
        button.setPreferredSize(new Dimension(150, 50));
        button.addActionListener(this);
        button.setFocusable(false);

        this.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null); // select file to open

            // to save a file .showSaveDialog()

            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
