package com.company.MainFrame;

import com.company.Panels.ApplyPanel;
import com.company.Panels.CreateOffersPanel;
import com.company.MODEL.Advertisements;
import com.company.Panels.FirmPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    public ArrayList<Advertisements> adds = new ArrayList<>();  // за обявите
    public ArrayList<String> firms = new ArrayList<>();     // за фирмите на FirmPanel

    public CreateOffersPanel createOffersPanel;
    public FirmPanel firmPanel;
    public ApplyPanel applyPanel;



    public MainFrame() {
        super("JOB OFFERS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLayout(new FlowLayout());

        showcreateOffersPanel();
    }

    // да показва панела за създаване на обяви с таблицата
    public void showcreateOffersPanel() {
        createOffersPanel = new CreateOffersPanel(this);
        createOffersPanel.setSize(getWidth(), getHeight());
        createOffersPanel.setVisible(true);
        add(createOffersPanel);
    }

    // да показва панела с таблицата само с една фирма
    public void showFirmPanel(Advertisements ad) {
        createOffersPanel.setVisible(false);
        remove(createOffersPanel);
        firmPanel = new FirmPanel(this, ad);
        firmPanel.setSize(getWidth(), getHeight());
        firmPanel.setVisible(true);
        add(firmPanel);
    }

    //  да показава панела за кандидатстване
    public void showApplyPanel(){
        firmPanel.setVisible(false);
        remove(firmPanel);
        applyPanel = new ApplyPanel(this);
        applyPanel.setSize(getWidth(), getHeight());
        applyPanel.setVisible(true);
        add(applyPanel);
    }
}
