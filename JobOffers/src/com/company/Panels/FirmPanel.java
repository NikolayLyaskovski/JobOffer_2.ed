package com.company.Panels;

import com.company.MainFrame.MainFrame;
import com.company.MODEL.Advertisements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmPanel extends JPanel implements ActionListener {
    public MainFrame frame;
    public JButton backButton;
    public Advertisements ad;
    public JTable firmTable;
    public JButton applyButton;
    public DefaultTableModel firmTableModel;

    public FirmPanel(MainFrame frame, Advertisements ad) {
        this.frame = frame;
        this.ad = ad;

        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        add(backButton);

        applyButton = new JButton("APPLY");
        applyButton.addActionListener(this);
        add(applyButton);

        showFirmTable();
//        showInfoFirmsTable();
    }

    // създаваме таблица само с фирмите
    public void showFirmTable() {
        firmTable = new JTable();
        JScrollPane pane = new JScrollPane();
        String columns[] = {"НОМЕР", "ФИРМА"};
        this.firmTableModel = new DefaultTableModel();
        firmTableModel.setColumnIdentifiers(columns);
        firmTable.setModel(firmTableModel);
        pane.setViewportView(firmTable);
        add(pane);
    }

    // само за попълване на инфо в таблицата с фирмите
    public void showInfoFirmsTable() {
        firmTableModel.setRowCount(0);
        int a = 0;
        for (Advertisements add : frame.adds) {
            Object row[] = new Object[2];
            row[0] = a += 1;
            row[1] = ad.firm;
            firmTableModel.addRow(row);
        }

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == backButton){
            frame.firmPanel.setVisible(false);
            frame.showcreateOffersPanel();      //връщане към първия екран
        }
        if (actionEvent.getSource() == applyButton){
            frame.showApplyPanel();
        }
    }
}
