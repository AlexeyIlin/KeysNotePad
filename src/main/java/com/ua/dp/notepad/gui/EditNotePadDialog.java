package com.ua.dp.notepad.gui;
import com.ua.dp.notepad.dao.UserDAO;
import com.ua.dp.notepad.entity.Content;
import com.ua.dp.notepad.entity.User;
import com.ua.dp.notepad.services.NotePadManager;

import static com.sun.glass.ui.Cursor.setVisible;
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


    private final JTextPane txt = new JTextPane();
    private Long contactId = null;
    private Long userId = null;
    private final JTextPane name = new JTextPane();
    private final JTextPane login = new JTextPane();
    private final JTextPane password = new JTextPane();
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

    public EditNotePadDialog(Content content, User user) {

        setLayout(null);
        buildFields();

        initFields(content, user);
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

        JLabel lblContentId = new JLabel("URL:");
        lblContentId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContentId.setBounds(new Rectangle(PAD, 4 * H_B + PAD, W_L, H_B));
        add(lblContentId);
        txt.setBounds(new Rectangle(W_L + 2 * PAD, 4 * H_B + PAD, W_T, H_B));
        txt.setBorder(BorderFactory.createEtchedBorder());
        add(txt);

    }

    private void initFields(Content content, User user) {
        if (content != null) {
            contactId = content.getContentId();
            userId = user.getUserId();
            login.setText(user.getLogin());
            password.setText(user.getPassword());
            txt.setText(content.getText());
            name.setText(user.getName());
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
        Content content = new Content(contactId, userId , txt.getText());
        return content;
    }

    public User getUser() {
        User user = new User(userId ,login.getText(), password.getText(), name.getText());
        return user;
    }
}
