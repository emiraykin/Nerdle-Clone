package Frontend;

import Core.Statistics;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;

import static Core.Equation.EquationControls.checkCharactersStatus;
import static Core.Equation.EquationControls.isEquationResultIsTrue;
import static Core.Generate.GenerateEquation;
import static Core.Statistics.readStatistics;
import static Core.Statistics.writeStatistics;

public class NewGame {
    int currentLine = 0;
    JButton submit = new JButton("Guess");
    JButton back = new JButton("Back");

    JLabel CorrOrWrong = new JLabel("---");
    String generatedEquation ;
    private static JTextField[][] index = new JTextField[9][9];
    JFrame frame;
    public NewGame (){
        generatedEquation = GenerateEquation();
       /* Statistics stats = new Statistics();
        stats.setAvgFinishAtLines(2);
        stats.setLosses(3);
        stats.setVictory(8);
        stats.setAvgSuccessTime(null);
        stats.setUnfinishedGames(1);
        writeStatistics(stats);*/

        frame = new JFrame("Nerdle");// tum pencere ve ismi
        //frame.getContentPane().add(draw);
        frame.setSize(750,500);
        //submit.addActionListener(this);
        JPanel board = new JPanel();

        //JPanel panel = new JPanel();
        board.setLayout(new GridLayout (6,generatedEquation.length()));
        for (int i =0;i<6;i++)
            for (int j=0;j<generatedEquation.length();j++){
                index[i][j]=new JTextField(1);
                index[i][j].setText("");
                index[i][j].setBounds(10,0,0,0);
                //index[i][j].setEditable(true);
                if(i!=currentLine){
                    index[i][j].setEditable(false);
                }

                board.add(index[i][j]);
            }

        frame.getContentPane().add(board);
        frame.getContentPane().add(submit,"South");
        frame.getContentPane().add(back,"West");

        frame.getContentPane().add(CorrOrWrong, "North");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTestActionPerformed(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        CorrOrWrong.setText(generatedEquation);
        frame.setVisible(true);
    }



    private void submitTestActionPerformed(java.awt.event.ActionEvent evt) {
        String input = "";
        int j = 0;
        while (j < generatedEquation.length() && index[currentLine][j].getText().compareTo("")!=0){
            input =input+index[currentLine][j].getText().charAt(0);
            j++;
        }
       /* for(int j=0;j<generatedEquation.length();j++){
            input =input+index[currentLine][j].getText().charAt(0);
        }*/
        System.out.println("---------------------");
        System.out.println(input);

        if(input.length() != generatedEquation.length() || !isEquationResultIsTrue(input) ){
            JOptionPane.showMessageDialog(frame, "This equation is not correct",
                    "WARNING", JOptionPane.ERROR_MESSAGE);
        }
        else{
            ArrayList<Integer> status = new ArrayList<Integer>();
            ArrayList<Boolean> ifVisited = new ArrayList<Boolean>() ;
            checkCharactersStatus(generatedEquation,input,status,ifVisited);
            for (int i = 0; i < generatedEquation.length() ; i++) {
                switch (status.get(i)){
                    case 0:
                        /*for (int j = currentLine; j < 6 ; j++) {
                            index[j][i].setText(String.valueOf(input.charAt(i)));
                            index[j][i].setEditable(false);
                            index[j][i].setBackground(Color.green);
                        }*/
                        index[currentLine][i].setBackground(Color.green);
                        index[currentLine][i].setEditable(false);

                        break;
                    case 1:
                        index[currentLine][i].setEditable(false);
                        index[currentLine][i].setBackground(Color.YELLOW);
                        break;
                    case 2:
                        index[currentLine][i].setEditable(false);
                        index[currentLine][i].setBackground(Color.RED);
                        break;


                }
            }
            if(input.compareTo(generatedEquation)==0){
                JOptionPane.showMessageDialog(frame, " You Won.\n ",
                        "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                Statistics stats = new Statistics();
                stats=readStatistics();
                stats.setAvgSuccessTime(null); /** burayı UNUTMA */
                stats.setAvgFinishAtLines( ((stats.getAvgFinishAtLines() * stats.getVictory())  +currentLine + 1) / (stats.getVictory()+1));
                stats.setVictory(stats.getVictory()+1);

                writeStatistics(stats);

            }
            else {
                if(currentLine==5){
                    JOptionPane.showMessageDialog(frame, "You lost.\n ",
                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    Statistics stats = new Statistics();
                    stats=readStatistics();
                    stats.setLosses(stats.getLosses()+1);
                    writeStatistics(stats);
                }
                else{
                    currentLine++;
                    for (int i = 0; i < generatedEquation.length(); i++) {
                        index[currentLine][i].setEditable(true);

                    }
                }

            }

        }
    }

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui = new GUI();
        gui.setVisible(true);
        frame.dispose();
    }

    public static int[][] submit(){
        int[][]result = new int[9][9];
        for (int i =0;i<9;i++)
            for (int j=0;j<9;j++){
                try {
                    result[i][j]=Integer.parseInt(index[i][j].getText());
                }catch (Exception e){
                    result[i][j]=-1;
                }
            }
        return result;
    }





    public static void main(String[] args) {
        //Create the sudoku
        //SudokuGenerator SDGN = new SudokuGenerator();
        //SudokuGenerator.main(null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new GUI();
    }

}
