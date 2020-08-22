package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

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


    public JFrame getWindow() {
        return window;
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


        window.setLayout(null);
        window.getContentPane().setLayout(null);
        window.setVisible(true);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
