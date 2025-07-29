import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener {
  JPanel centerPanel, buttonPanel;
  JButton addBtn, resetBtn, subtractBtn;
  JLabel countText;
  int count = 0;

  Frame() {
    this.setTitle("Counter");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500,500);

    centerPanel = new JPanel(new BorderLayout());
    buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

    countText = new JLabel("0", SwingConstants.CENTER);
    countText.setFont(new Font("Arial", Font.BOLD, 24));
    centerPanel.add(countText, BorderLayout.NORTH);

    addBtn = new JButton("+");
    addBtn.setFocusable(false);
    addBtn.addActionListener(this);
    resetBtn = new JButton("Reset");
    resetBtn.setFocusable(false);
    resetBtn.addActionListener(this);
    subtractBtn = new JButton("-");
    subtractBtn.setFocusable(false);
    subtractBtn.addActionListener(this);

    buttonPanel.add(addBtn);
    buttonPanel.add(resetBtn);
    buttonPanel.add(subtractBtn);
    centerPanel.add(buttonPanel, BorderLayout.CENTER);

    this.add(centerPanel, BorderLayout.CENTER);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int countTextVal = Integer.parseInt(countText.getText());

    if(e.getSource() == addBtn) {
      countTextVal++;
      countText.setText(String.valueOf(countTextVal));
    } else if(e.getSource() == subtractBtn) {
      countTextVal--;
      countText.setText(String.valueOf(countTextVal));
    } else {
      countTextVal = 0;
      countText.setText(String.valueOf(countTextVal));
    }
  }
}
