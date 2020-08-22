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
