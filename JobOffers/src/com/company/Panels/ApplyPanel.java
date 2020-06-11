package com.company.Panels;

import com.company.MainFrame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyPanel extends JPanel implements ActionListener {

    public MainFrame frame;
    public JTextField nameField;
    public JTextField mailField;
    public JTextField phoneField;
    public JTextField yearField;
    public JTextField motivationTextField;
    public JButton okButton;
    public JButton cancelButton;

    public ApplyPanel(MainFrame frame) {
        this.frame = frame;

        nameField = new JTextField("Enter your name");
        add(nameField);
        mailField = new JTextField("Enter your email");
        add(mailField);
        phoneField = new JTextField("Enter your phone");
        add(phoneField);
        yearField = new JTextField("Enter your year experience");
        add(yearField);
        motivationTextField = new JTextField("Say few words");
        add(motivationTextField);

        okButton = new JButton("OK");
        okButton.addActionListener(this);
        add(okButton);

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(this);
        add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == okButton) {
                        //numberCandidates += 1 ?
        }
        if (actionEvent.getSource() == cancelButton) {
            int a = JOptionPane.showConfirmDialog(null, "Сигурни ли сте?", "INFORMATION", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                frame.applyPanel.setVisible(false);
                frame.showcreateOffersPanel();
            }
        }

    }

    // метод за проверка на полетата
    public void checkApplyTextField() {
        if (nameField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете три имена", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (mailField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете валиден емейл", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (phoneField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете валиден номер", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (yearField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете години стаж", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (motivationTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете мотивационен текст", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }


}
