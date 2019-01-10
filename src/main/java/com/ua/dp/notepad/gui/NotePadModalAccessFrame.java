package com.ua.dp.notepad.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePadModalAccessFrame extends JFrame implements ActionListener {

    private static final String okButton = "OK";
    private static final String cancelButton = "Cancel";
    private static final String code = " ";

    private final JTextField field = new JTextField(10);

    public NotePadModalAccessFrame(){

        JPanel window = new JPanel();
        window.add(field);

        window.add(createButton("Okay",okButton));
        window.add(createButton("Cancel",cancelButton));
        add(window, BorderLayout.SOUTH);


        setBounds(500, 500, 300, 80);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JButton createButton(String title,String action) {

        JButton button = new JButton(title);

        button.setActionCommand(action);

        button.addActionListener(this);

        return button;
    }


    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case okButton:
                checkPassword(field.getText());
                break;
            case cancelButton:
                System.exit(0);
        }
    }


    private void checkPassword(String fieldText){

        switch (fieldText) {
            case "":
                JOptionPane.showMessageDialog(this, "Введите секретное слово");

                break;
            case code:
                setVisible(false);
                NotePadFrame npf = new NotePadFrame();
                npf.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Неверное секретное слово");
                break;
        }
    }

}
