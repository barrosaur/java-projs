import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
  public static class Frame extends JFrame implements ActionListener {
    JLabel from, to, answerLabel;
    JPanel mainPanel, convertPanel, inputPanel, answerPanel;
    JTextField txtField;
    JComboBox<String> fromUnits, toUnits;
    JButton convertBtn;

    Frame() {
      this.setTitle("Unit Converter");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(400, 150);

      // panels
      mainPanel = new JPanel(new BorderLayout());
      convertPanel = new JPanel(new FlowLayout());
      inputPanel = new JPanel(new FlowLayout());

      // labels and combo box
      String[] units = {
              "Centimeter (cm)",
              "Meter (m)",
              "Kilometer (km)"
      };
      from = new JLabel("From:");
      to = new JLabel("To:");
      fromUnits = new JComboBox<String>(units);
      fromUnits.setFocusable(false);
      toUnits = new JComboBox<String>(units);
      toUnits.setFocusable(false);
      fromUnits.addActionListener(this);

      convertPanel.add(from);
      convertPanel.add(fromUnits);
      convertPanel.add(to);
      convertPanel.add(toUnits);

      // text Field and btn
      txtField = new JTextField();
      txtField.setPreferredSize(new Dimension(200, 30));
      convertBtn = new JButton("Convert");
      convertBtn.addActionListener(this);

      inputPanel.add(txtField);
      inputPanel.add(convertBtn);

      // answer panel and answer label
      answerPanel = new JPanel();
      answerLabel = new JLabel("0", SwingConstants.CENTER);
      answerLabel.setPreferredSize(new Dimension(300, 30));
      answerLabel.setFont(new Font("Arial", Font.BOLD, 30));
      answerPanel.add(answerLabel);

      mainPanel.add(convertPanel, BorderLayout.CENTER);
      mainPanel.add(answerPanel, BorderLayout.NORTH);
      mainPanel.add(inputPanel, BorderLayout.SOUTH);

      this.add(mainPanel, BorderLayout.CENTER);
      this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String mode_1 = String.valueOf(fromUnits.getSelectedItem());
      String mode_2 = String.valueOf(toUnits.getSelectedItem());
      float num = Float.parseFloat(txtField.getText());

      if(e.getSource() == convertBtn) {
        float converted_num = Convert(mode_1, mode_2, num);
        answerLabel.setText(String.valueOf(converted_num));
      }

    }
  }

  private static float Convert(String mode_1, String mode_2, float num) {
    boolean cm_to_m = (mode_1 == "Centimeter (cm)") && (mode_2 == "Meter (m)");
    boolean cm_to_km = (mode_1 == "Centimeter (cm)") && (mode_2 == "Kilometer (km)");
    boolean m_to_cm = (mode_1 == "Meter (m)") && (mode_2 == "Centimeter (cm)");
    boolean m_to_km = (mode_1 == "Meter (m)") && (mode_2 == "Kilometer (km)");
    boolean km_to_cm = (mode_1 == "Kilometer (km)") && (mode_2 == "Centimeter (cm)");
    boolean km_to_m = (mode_1 == "Kilometer (km)") && (mode_2 == "Meter (m)");

    if(cm_to_m) {
      return Conversion.cm_to_m(num);
    } else if (cm_to_km) {
      return Conversion.cm_to_km(num);
    } else if(m_to_cm) {
      return Conversion.m_to_cm(num);
    } else if(m_to_km) {
      return Conversion.m_to_km(num);
    } else if(km_to_cm) {
      return Conversion.km_to_cm(num);
    } else if(km_to_m) {
      return Conversion.km_to_m(num);
    }

    return num;
  }

  public static void main(String[] args) {
    new Frame();
  }
}