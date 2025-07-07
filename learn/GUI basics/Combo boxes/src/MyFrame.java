import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{

    JComboBox comboBox;

    MyFrame() {
        this.setTitle("Combo Boxes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(100, 100);

        // it should always be wrapper that are passed
        // so if you want to pass in a range of integers
        //      instead of int[] --> Integer[]
        String[] animals = {"dog", "cat", "rat"};
        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);

        this.add(comboBox);
        this.setVisible(true);
    }

    /*
        comboBox.setEditable(true)              you can edit stuff
        comboBox.getItemCount()                 counts all the items in the array you passed
        comboBox.addItem()
        comboBox.insertItemAt(value, index)
        comboBox.setSelectedIndex()             default will be set here 0 for first
        comboBox.removeItem()
        comboBox.removeItemAt()
        comboBox.removeAllItems()
    */

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
