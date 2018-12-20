package com.ua.dp.notepad.gui;
import com.ua.dp.notepad.dao.entity.Content;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditNotePadDialog extends JDialog implements ActionListener {

    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";

    private static final int PAD = 10;
    private static final int W_L = 100;
    private static final int W_T = 300;
    private static final int W_B = 120;
    private static final int H_B = 25;

    private Long contactId = null;
    private final JTextPane name = new JTextPane();
    private final JTextPane login = new JTextPane();
    private final JTextPane password = new JTextPane();
    private final JTextPane txt = new JTextPane();
    private boolean save = false;


    public EditNotePadDialog(){

        setLayout(null);
        buildFields();

        buildButtons();
        setModal(true);
        setResizable(false);
        setBounds(130, 150, 450, 250);
        setVisible(true);
    }

    public EditNotePadDialog(Content content) {

        setLayout(null);
        buildFields();

        initFields(content);
        buildButtons();
        setModal(true);
        setResizable(false);
        setBounds(130, 150, 450, 300);
        setVisible(true);
    }


    private void buildFields() {

        JLabel lblContentName = new JLabel("Name:");
        lblContentName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContentName.setBounds(new Rectangle(PAD, 1 * H_B + PAD, W_L, H_B));
        add(lblContentName);
        name.setBounds(new Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B));
        name.setBorder(BorderFactory.createEtchedBorder());
        add(name);

        JLabel lblContentLogin = new JLabel("Login:");
        lblContentLogin.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContentLogin.setBounds(new Rectangle(PAD, 2 * H_B + PAD, W_L, H_B));
        add(lblContentLogin);
        login.setBounds(new Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B));
        login.setBorder(BorderFactory.createEtchedBorder());
        add(login);

        JLabel lblContentPass = new JLabel("Password:");
        lblContentPass.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContentPass.setBounds(new Rectangle(PAD, 3 * H_B + PAD, W_L, H_B));
        add(lblContentPass);
        password.setBounds(new Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B));
        password.setBorder(BorderFactory.createEtchedBorder());
        add(password);

        JLabel lblContentUrl = new JLabel("URL:");
        lblContentUrl.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContentUrl.setBounds(new Rectangle(PAD, 4 * H_B + PAD, W_L, H_B));
        add(lblContentUrl);
        txt.setBounds(new Rectangle(W_L + 2 * PAD, 4 * H_B + PAD, W_T, H_B));
        txt.setBorder(BorderFactory.createEtchedBorder());
        add(txt);

    }

    private void initFields(Content content) {
        if (content != null) {
            contactId = content.getContentId();
            name.setText(content.getName());
            login.setText(content.getLogin());
            password.setText(content.getPassword());
            txt.setText(content.getText());
        }
    }


    private void buildButtons() {
        JButton btnSave = new JButton("SAVE");
        btnSave.setActionCommand(SAVE);
        btnSave.addActionListener(this);
        btnSave.setBounds(new Rectangle(PAD * 5 , 6 * H_B + PAD, W_B, H_B));
        add(btnSave);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setBounds(new Rectangle( PAD * 20, 6 * H_B + PAD, W_B, H_B));
        add(btnCancel);
    }

    @Override

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        save = SAVE.equals(action);

        setVisible(false);
    }


    public boolean isSave() {
        return save;
    }


    public Content getContent() {
        Content content = new Content(contactId, name.getText(), login.getText(), password.getText() , txt.getText());
        return content;
    }

}
