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
    private JLabel labelScore;
    private JLabel labelEngWord;
    private JLabel labelAuthor;
    private JLabel labelActualScore;
    private JTextField textFieldAnswer;
    private JLabel picture;
    private JButton buttonCheck;
    private JButton buttonNewGame;
    private JFileChooser fileChooser;
    int score = 0;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public JTextField getTextFieldAnswer() {
        return textFieldAnswer;
    }

    public JLabel getLabelEngWord() {
        return labelEngWord;
    }

    public JLabel getPicture() {
        return picture;
    }

    public JFrame getWindow() {
        return window;
    }

    public JLabel getLabelActualScore() {
        return labelActualScore;
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


        labelScore = new JLabel("Score:");
        labelScore.setBounds(10, 10, 150, 50);
        labelScore.setFont(new Font("Serif", Font.PLAIN, 30));
        labelScore.setForeground(white);
        window.getContentPane().add(labelScore);

        labelEngWord = new JLabel("English Word");
        labelEngWord.setBounds(290, 170, 150, 50);
        labelEngWord.setFont(new Font("Serif", Font.PLAIN, 30));
        labelEngWord.setForeground(white);
        window.getContentPane().add(labelEngWord);

        labelAuthor = new JLabel("@Author: EwaI");
        labelAuthor.setBounds(10, 590, 100, 50);
        labelAuthor.setFont(new Font("Serif", Font.PLAIN, 10));
        labelAuthor.setForeground(white);
        window.getContentPane().add(labelAuthor);


        String scoreString = String.valueOf(score);
        labelActualScore = new JLabel(scoreString);
        labelActualScore.setBounds(100, 10, 100, 50);
        labelActualScore.setFont(new Font("Serif", Font.PLAIN, 30));
        labelActualScore.setForeground(white);
        window.getContentPane().add(labelActualScore);

        textFieldAnswer = new JTextField("Your answer...");
        textFieldAnswer.setBounds(205, 230, 300, 50);
        textFieldAnswer.setFont(new Font("Serif", Font.PLAIN, 20));
        window.getContentPane().add(textFieldAnswer);

        picture = new JLabel(new ImageIcon(
                "C:\\Users\\E\\IdeaProjects\\workshop_code\\src\\com\\ewai\\vocabulary_game\\ninja_cat3.png"));
        picture.setBounds(445, 390, 250, 250);
        window.getContentPane().add(picture);

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

    public File showFileChooser() {
        fileChooser.showOpenDialog(window);
        return fileChooser.getSelectedFile();
    }
}
