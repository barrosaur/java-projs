import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());

        // display
        JTextField display = new JTextField();
        display.setPreferredSize(new Dimension(400, 100));
        display.setBackground(Color.LIGHT_GRAY);
        display.setFont(new Font("Arial", Font.PLAIN, 30));
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        // buttons
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(4, 4));
        Map<String, JButton> btn = new HashMap<>();
        String[] buttonLabels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "x",
                "0", "C", "=", "/"
        };
        for(String buttonLabel : buttonLabels) {
            JButton button = new JButton(buttonLabel);
            button.setFocusable(false);

            btn.put(buttonLabel, button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String equation = display.getText() + " " + e.getActionCommand();
                    if(equation.endsWith("=")) {
                        equation = equation.substring(0, equation.length() - 1).trim();
                    }
                    display.setText(equation);

                    if(e.getActionCommand().equals("=")) {
                       display.setText(String.valueOf(evaluateExpression(equation)));
                    } else if(e.getSource() == btn.get("C")) {
                        display.setText("");
                    }
                }
            });

            btnPanel.add(button);
        }
        frame.add(btnPanel);

        frame.setVisible(true);
    }

    private static int evaluateExpression(String equation) {
        String[] tokens = equation.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for(int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = Integer.parseInt(tokens[i + 1]);

            if(operator.equals("+")) {
                result += number;
            } else if(operator.equals("-")) {
                result -= number;
            } else if(operator.equals("x")) {
                result *= number;
            } else if(operator.equals("/")) {
                result /= number;
            }
        }

        return result;
    }
}