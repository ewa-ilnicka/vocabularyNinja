package controller;

import view.GUI;

import model.Dictionary;
import model.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static model.Config.CHECK;
import static model.Config.NEW_GAME;
import static model.Config.OPEN;

public class Controller implements ActionListener {

    private GUI gui;
    private Dictionary dictionary;
    private int currentItemNumber;
    private Item randomItem;
    private List<Item> copyOfList = new ArrayList<>();

    {
        gui = new GUI();
        dictionary = new Dictionary();
    }

    public void run() {
        gui.createAndShowWindow();
        gui.addListeners(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case CHECK:
                handleCheckEvent();
                break;
            case NEW_GAME:
                handleNEW_GAMEEvent();
                break;
            case OPEN:
                handleOpenEvent();
        }
    }


}
