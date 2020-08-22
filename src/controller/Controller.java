package controller;

import view.GUI;

import static model.Config.CHECK;
import static model.Config.NEW_GAME;
import static model.Config.OPEN;

public class Controller {

    private GUI gui;

    {
        gui = new GUI();
    }

    public void run() {
        gui.createAndShowWindow();
    }

}
