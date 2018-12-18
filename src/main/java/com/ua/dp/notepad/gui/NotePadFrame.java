package com.ua.dp.notepad.gui;

import com.ua.dp.notepad.entity.Content;
import com.ua.dp.notepad.entity.User;
import com.ua.dp.notepad.services.NotePadManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NotePadFrame extends JFrame implements ActionListener {

    private static final String LOAD = "LOAD";
    private static final String ADD = "ADD";
    private static final String EDIT = "EDIT";
    private static final String DELETE = "DELETE";

    private final NotePadManager notePadManager = new NotePadManager();
    private final JTable contentTable = new JTable();

    public NotePadFrame(){
        contentTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;

        gbc.fill = GridBagConstraints.BOTH;

        gbc.insets = new Insets(0, 0, 0, 0);


        JPanel btnPanel = new JPanel();

        btnPanel.setLayout(gridbag);

        btnPanel.add(createButton(gridbag, gbc, "Обновить", LOAD));
        btnPanel.add(createButton(gridbag, gbc, "Добавить", ADD));
        btnPanel.add(createButton(gridbag, gbc, "Исправить", EDIT));
        btnPanel.add(createButton(gridbag, gbc, "Удалить", DELETE));


        JPanel left = new JPanel();

        left.setLayout(new BorderLayout());

        left.add(btnPanel, BorderLayout.NORTH);

        add(left, BorderLayout.WEST);

        add(new JScrollPane(contentTable), BorderLayout.CENTER);

        setBounds(100, 200, 800, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        loadContent();
    }


    private JButton createButton(GridBagLayout gridbag, GridBagConstraints gbc, String title, String action) {

        JButton button = new JButton(title);

        button.setActionCommand(action);

        button.addActionListener(this);

        gridbag.setConstraints(button, gbc);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch (action) {
            case LOAD:
                loadContent();
                break;
            case ADD:
                addContent();
                break;
            case EDIT:
                editContent();
                break;
            case DELETE:
                deleteContent();
                break;
        }
    }

    private void loadContent() {
        List<Content> contents = notePadManager.findContents();
        List<User> users = notePadManager.findUsers();
        NotePadModel npm = new NotePadModel(contents, users);
        contentTable.setModel(npm);
        contentTable.removeColumn(contentTable.getColumnModel().getColumn(0));
        contentTable.removeColumn(contentTable.getColumnModel().getColumn(0));
    }

    private void addContent() {
        EditNotePadDialog enpd = new EditNotePadDialog();
        saveContent(enpd);
    }


    private void editContent() {

        int sr = contentTable.getSelectedRow();

        if (sr != -1) {

            Long id = Long.parseLong(contentTable.getModel().getValueAt(sr, 0).toString());
            Long userid = Long.parseLong(contentTable.getModel().getValueAt(sr, 1).toString());

            Content cnt = notePadManager.getContent(id);
            User usr = notePadManager.getUser(userid);

            EditNotePadDialog ecd = new EditNotePadDialog(cnt, usr);
            saveContent(ecd);
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования");
        }
    }


    private void deleteContent() {

        int sr = contentTable.getSelectedRow();
        if (sr != -1) {

            Long id = Long.parseLong(contentTable.getModel().getValueAt(sr, 0).toString());
            Long usrid = Long.parseLong(contentTable.getModel().getValueAt(sr, 1).toString());

            notePadManager.deleteContent(id);
            notePadManager.deleteUser(usrid);

            loadContent();
        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления");
        }
    }

    private void saveContent(EditNotePadDialog ecd) {

        if (ecd.isSave()) {

            Content cnt = ecd.getContent();
            User usr = ecd.getUser();

            if (cnt.getContentId() != null) {
                notePadManager.updateContent(cnt);
                notePadManager.updateUser(usr);

            } else {
                notePadManager.addContent(cnt);
                notePadManager.addUser(usr);
            }
            loadContent();
        }

}



}
