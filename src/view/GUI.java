package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

import static model.Config.*;


public class GUI {
    private final Color grey = new Color(71, 71, 71);
    private final Color red = new Color(206, 90, 81);
    private final Color white = new Color(255, 255, 255);
    private JFrame window;
    private JMenu file;
    private JMenuItem open;
    private JFileChooser fileChooser;
    private JButton buttonCheck;
    private JButton buttonNewGame;


    public JFrame getWindow() {
        return window;
    }

    public JButton getButtonNewGame() {
        return buttonNewGame;
    }

    public void createAndShowWindow() {
        window = new JFrame("Vocabulary Ninja");
        window.setMinimumSize(new Dimension(700, 700));
        window.setResizable(false);
        window.getContentPane().setBackground(grey);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(700, 30));
        menuBar.setBorder(null);
        menuBar.setBackground(red);
        window.setJMenuBar(menuBar);

        file = new JMenu("File");
        file.setFont(new Font("Serif", Font.PLAIN, 18));
        file.setForeground(Color.black);
        menuBar.add(file);

        open = new JMenuItem("Open");
        file.add(open);
        open.setBorder(null);

        fileChooser = new JFileChooser(
                FileSystemView
                        .getFileSystemView()
                        .getParentDirectory(new File("assets/words.csv")));
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
        open.setActionCommand(OPEN);

        buttonCheck = new JButton("Check!");
        buttonCheck.setBounds(300, 290, 100, 50);
        window.getContentPane().add(buttonCheck);
        window.getRootPane().setDefaultButton(buttonCheck);
        buttonCheck.setBackground(red);
        buttonCheck.setFont(new Font("Serif", Font.PLAIN, 20));
        buttonCheck.setActionCommand(CHECK);

        buttonNewGame = new JButton("NEW GAME");
        buttonNewGame.setBounds(540, 20, 150, 40);
        window.getContentPane().add(buttonNewGame);
        buttonNewGame.setBackground(red);
        buttonNewGame.setFont(new Font("Serif", Font.BOLD, 15));
        buttonNewGame.setActionCommand(NEW_GAME);
        buttonNewGame.setEnabled(false);

        window.setLayout(null);
        window.getContentPane().setLayout(null);
        window.setVisible(true);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addListeners(ActionListener actionListener) {
        buttonCheck.addActionListener(actionListener);
        buttonNewGame.addActionListener(actionListener);
        open.addActionListener(actionListener);
    }

}
