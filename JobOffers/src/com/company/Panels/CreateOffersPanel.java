package com.company.Panels;

import com.company.MainFrame.MainFrame;
import com.company.MODEL.Advertisements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateOffersPanel extends JPanel implements ActionListener {

    public MainFrame frame;
    public JLabel firmLabel;
    public JTextField firmField;
    public JLabel positionLabel;
    public JTextField positionField;
    public JLabel typeLabel;
    public JTextField typeField;
    public JLabel descriptionLabel;
    public JTextField descriptionField;
    public JTable offersTable;
    public DefaultTableModel model;
    public JTextField searchField;
    public JButton addOfferButton;
    public JButton removeOfferButton;
    public JButton showFirmButton;
    public JButton searchButton;
    public Advertisements ad;

    public CreateOffersPanel(MainFrame frame) {
        this.frame = frame;
        firmLabel = new JLabel("Фирма");
        add(firmLabel);
        firmField = new JTextField("Enter a firm");
        add(firmField);

        positionLabel = new JLabel("Позиция");
        add(positionLabel);
        positionField = new JTextField("Enter a position");
        add(positionField);

        typeLabel = new JLabel("Тип");
        add(typeLabel);
        typeField = new JTextField("Enter a type");
        add(typeField);

        descriptionLabel = new JLabel("Описание");
        add(descriptionLabel);
        descriptionField = new JTextField("Enter a description");
        add(descriptionField);

        addOfferButton = new JButton("ADD");
        addOfferButton.addActionListener(this);
        add(addOfferButton);

        removeOfferButton = new JButton("REMOVE");
        removeOfferButton.addActionListener(this);
        add(removeOfferButton);

        showFirmButton = new JButton("SHOW OFFER");
        showFirmButton.addActionListener(this);
        add(showFirmButton);

        searchField = new JTextField("Enter type");
        add(searchField);

        searchButton = new JButton("SEARCH");
        searchButton.addActionListener(this);
        add(searchButton);

        showOffersTable();
    }

    // таблица за показване на създадените оферти
    public void showOffersTable() {
        offersTable = new JTable();
        JScrollPane pane = new JScrollPane();
        String[] columns = {"ФИРМА", "ПОЗИЦИЯ", "ТИП", "ОПИСАНИЕ", "БРОЙ КАНДИДАТИ"};
        this.model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        offersTable.setModel(model);
        pane.setViewportView(offersTable);
        add(pane);
    }

    //създаваме оферта от въведеното в полетата и проверка дали не са празни
    public void createOffer() {
        Advertisements a = new Advertisements(firmField.getText(), positionField.getText(), typeField.getText(), descriptionField.getText(), 0);

        if (firmField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете фирма", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (positionField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете позиция", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (typeField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете тип", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (descriptionField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Въведете описание", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        frame.adds.add(a);  //добавяме в масива
        showInfoOffersTable(frame.adds);    //показваме в таблицата
        firmField.setText("Enter a firm");
        positionField.setText("Enter a position");
        typeField.setText("Enter a type");
        descriptionField.setText("Enter a description");
    }

    // показване на инфо в таблицата
    public void showInfoOffersTable(ArrayList<Advertisements> arrayList) {
        model.setRowCount(0);
        for (Advertisements adds : arrayList) {
            Object[] row = new Object[5];
            row[0] = adds.firm;
            row[1] = adds.position;
            row[2] = adds.type;
            row[3] = adds.description;
            row[4] = 0;
            model.addRow(row);
        }
    }

    // метод за търсене по type
    public void searchTypeOffer() {
        ArrayList<Advertisements> searchList = new ArrayList<>();
        boolean isFound = false;
        for (Advertisements adds : frame.adds) {
            if (adds.type.equalsIgnoreCase(searchField.getText())) {
                isFound = true;
                searchList.add(adds);
            }
        }
        if (!isFound) {
            JOptionPane.showMessageDialog(null, "НЯМА РЕЗУЛТАТ", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            showInfoOffersTable(frame.adds);
        }
        showInfoOffersTable(searchList);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addOfferButton) {
            createOffer();
        }
        if (actionEvent.getSource() == showFirmButton) {
            Advertisements ad = frame.adds.get(offersTable.getSelectedRow());
            frame.firms.add(ad.firm);  //добавяме в масива
            frame.showFirmPanel(ad); //показваме следващия екран
            frame.firmPanel.showInfoFirmsTable();
        }
        if (actionEvent.getSource() == removeOfferButton) {
            int option = JOptionPane.showConfirmDialog(null, "Сигурни ли сте че искате да изтриете тази оферта ?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                frame.adds.remove(offersTable.getSelectedRow());    //триене на обява
                showInfoOffersTable(frame.adds);
            }
        }
        if (actionEvent.getSource() == searchButton) {
            searchTypeOffer();
            System.out.println("serachsghsg");
        }
    }
}

