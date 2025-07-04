import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Open new window");

    LaunchPage() {

        button.setBounds(150, 150, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button);
        frame.setTitle("OpenNewWindow");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button) {
            frame.dispose(); //rids the launch page when opening a new window
            NewWindow window = new NewWindow();
        }
    }
}
