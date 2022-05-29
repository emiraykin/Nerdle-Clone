package Frontend;

import Core.Statistics;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;

import static Core.Equation.EquationControls.*;
import static Core.Generate.GenerateEquation;
import static Core.Statistics.readStatistics;
import static Core.Statistics.writeStatistics;

public class NewGame implements ActionListener  {
    int currentLine = 0;
    int currentColumn = 0;
    JButton submit = new JButton("Guess");
    JButton back = new JButton("Back to menu");
    JButton btn0 = new JButton("    0   ");
    JButton btn1 = new JButton("    1   ");
    JButton btn2 = new JButton("    2   ");
    JButton btn3 = new JButton( "   3   ");
    JButton btn4 = new JButton("    4   ");
    JButton btn5 = new JButton("    5   ");
    JButton btn6 = new JButton("    6   ");
    JButton btn7 = new JButton("    7   ");
    JButton btn8 = new JButton("    8   ");
    JButton btn9 = new JButton("    9   ");
    JButton btnplus = new JButton("    +   ");
    JButton btnminus = new JButton("    -   ");
    JButton btncross = new JButton("    *   ");
    JButton btnslash = new JButton("    /   ");
    JButton btnequals = new JButton("   =  ");
    JButton btndelete = new JButton("Delete");

    JButton btnSave = new JButton("Save game");


    JPanel main = new JPanel( new BorderLayout() );
    JLabel CorrOrWrong = new JLabel("---");
    String generatedEquation ;
    private static JTextField[][] index = new JTextField[9][9];
    JFrame frame;
    int i,j;

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
        board.setPreferredSize( new Dimension(300, 500) );
        main.add(board,BorderLayout.CENTER);
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
                index[i][j].setHorizontalAlignment(JTextField.CENTER);

                board.add(index[i][j]);
            }

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(200,100));


        buttonsPanel.add(btn1);
        buttonsPanel.add(btn2);
        buttonsPanel.add(btn3);
        buttonsPanel.add(btn4);
        buttonsPanel.add(btn5);
        buttonsPanel.add(btn6);
        buttonsPanel.add(btn7);
        buttonsPanel.add(btn8);
        buttonsPanel.add(btn9);
        buttonsPanel.add(btn0);
        buttonsPanel.add(back);
        buttonsPanel.add(btnSave);
        buttonsPanel.add(btnplus);
        buttonsPanel.add(btnminus);
        buttonsPanel.add(btncross);
        buttonsPanel.add(btnslash);
        buttonsPanel.add(btnequals);
        buttonsPanel.add(btndelete);

        buttonsPanel.add(submit);
        back.setBackground(Color.PINK);
        btnSave.setBackground(Color.yellow);




        main.add(buttonsPanel,BorderLayout.PAGE_END);


        frame.getContentPane().add(main);
        //frame.getContentPane().add(submit,"South");
        //frame.getContentPane().add(back,"West");

        frame.getContentPane().add(CorrOrWrong, "North");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        submit.addActionListener(this);

        back.addActionListener(this);
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnequals.addActionListener(this);
        btnplus.addActionListener(this);
        btnminus.addActionListener(this);
        btncross.addActionListener(this);
        btnslash.addActionListener(this);
        btndelete.addActionListener(this);
        btnSave.addActionListener(this);
        CorrOrWrong.setText(generatedEquation);
        frame.setVisible(true);

        /*index[currentLine][currentColumn].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                index[currentLine][0].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][0].setBackground(Color.WHITE);


            }

        });
        index[currentLine][1].addMouseListener(this);
            index[currentLine][1].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 1;
                index[currentLine][1].setBackground(Color.CYAN);
            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][1].setBackground(Color.WHITE);


            }

        });
        index[currentLine][2].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 2;
                index[currentLine][2].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][2].setBackground(Color.WHITE);


            }

        });
        index[currentLine][3].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 3;
                index[currentLine][3].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][3].setBackground(Color.WHITE);


            }

        });
        index[currentLine][4].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 4;
                index[currentLine][4].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][4].setBackground(Color.WHITE);


            }

        });
        index[currentLine][5].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 5;
                index[currentLine][5].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                index[currentLine][5].setBackground(Color.WHITE);


            }

        });
        index[currentLine][6].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                currentColumn = 6;
                index[currentLine][6].setBackground(Color.CYAN);

            }

            @Override
            public void focusLost(FocusEvent e) {
                    index[currentLine][6].setBackground(Color.WHITE);




            }

        });
        try{
            index[currentLine][7].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    currentColumn = 7;
                    index[currentLine][7].setBackground(Color.CYAN);

                }

                @Override
                public void focusLost(FocusEvent e) {

                        index[currentLine][7].setBackground(Color.WHITE);



                }

            });
            index[currentLine][8].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    currentColumn = 8;
                    index[currentLine][8].setBackground(Color.CYAN);

                }

                @Override
                public void focusLost(FocusEvent e) {
                    index[currentLine][8].setBackground(Color.WHITE);

                }

            });
        }catch (Exception e){

        }*/

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == submit)
        {
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

            if(input.length() != generatedEquation.length() || !EquationRegexControl(input) ){
                JOptionPane.showMessageDialog(frame, "This equation is not correct",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else{
                ArrayList<Integer> status = new ArrayList<Integer>();
                ArrayList<Boolean> ifVisited = new ArrayList<Boolean>() ;
                checkCharactersStatus(generatedEquation,input,status,ifVisited);
                for (int  i = 0; i < generatedEquation.length() ; i++) {
                    switch (status.get(i)){
                        case 0:
                        /*for (int j = currentLine; j < 6 ; j++) {
                            index[j][i].setText(String.valueOf(input.charAt(i)));
                            index[j][i].setEditable(false);
                            index[j][i].setBackground(Color.green);
                        }*/
                            index[currentLine][i].setBackground(Color.green.darker());

                            index[currentLine][i].setEditable(false);

                            break;
                        case 1:
                            index[currentLine][i].setEditable(false);
                            index[currentLine][i].setBackground(Color.yellow.darker());
                            break;
                        case 2:
                            index[currentLine][i].setEditable(false);
                            index[currentLine][i].setBackground(Color.red.darker());
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
                        currentColumn=0;
                        for (int i = 0; i < generatedEquation.length(); i++) {
                            index[currentLine][i].setEditable(true);

                        }

                        index[currentLine][currentColumn].requestFocus();

                    }

                }

            }


        }
        else if( e.getSource() == back){
            GUI gui = new GUI();
            gui.setVisible(true);
            frame.dispose();
        }
        else if (e.getSource() == btn0){
            index[currentLine][currentColumn].setText(String.valueOf(0)) ;
            next();
        }
        else if (e.getSource() == btn1){
            index[currentLine][currentColumn].setText(String.valueOf(1)) ;
            next();

        }
        else if (e.getSource() == btn2){
            index[currentLine][currentColumn].setText(String.valueOf(2)) ;
            next();

        }
        else if (e.getSource() == btn3){
            index[currentLine][currentColumn].setText(String.valueOf(3)) ;
            next();

        }
        else if (e.getSource() == btn4){
            index[currentLine][currentColumn].setText(String.valueOf(4)) ;
            next();

        }
        else if (e.getSource() == btn5){
            index[currentLine][currentColumn].setText(String.valueOf(5)) ;
            next();

        }
        else if (e.getSource() == btn6){
            index[currentLine][currentColumn].setText(String.valueOf(6)) ;
            next();

        }
        else if (e.getSource() == btn7){
            index[currentLine][currentColumn].setText(String.valueOf(7)) ;
            next();

        }
        else if (e.getSource() == btn8){
            index[currentLine][currentColumn].setText(String.valueOf(8)) ;
            next();

        }

        else if (e.getSource() == btn9){
            index[currentLine][currentColumn].setText(String.valueOf(9)) ;
            next();

        }
        else if (e.getSource() == btnplus){
            index[currentLine][currentColumn].setText("+") ;
            next();

        }
        else if (e.getSource() == btnminus){
            index[currentLine][currentColumn].setText("-") ;
            next();

        }
        else if (e.getSource() == btncross){
            index[currentLine][currentColumn].setText("*") ;
            next();

        }
        else if (e.getSource() == btnslash){
            index[currentLine][currentColumn].setText("/");
            next();

        }
        else if (e.getSource() == btnequals){
            index[currentLine][currentColumn].setText("=");
            next();

        }
        else if (e.getSource() == btndelete){
            index[currentLine][currentColumn].setText("");
            back();

        }

    }

    private void back() {
        if(currentColumn>0){
            index[currentLine][--currentColumn].requestFocus();

        }else {
            index[currentLine][currentColumn].requestFocus();

        }
    }

    private void next() {
       if(currentColumn<generatedEquation.length()-1){
           index[currentLine][++currentColumn].requestFocus();
       }
       else {
           index[currentLine][currentColumn].requestFocus();
       }


    }

    public int getCurrentLine() {
         return currentLine;
     }



    /*
        private void submitTestActionPerformed (java.awt.event.ActionEvent evt){
        String input = "";
        int j = 0;
        while (j < generatedEquation.length() && index[currentLine][j].getText().compareTo("") != 0) {
            input = input + index[currentLine][j].getText().charAt(0);
            j++;
        }
       *//* for(int j=0;j<generatedEquation.length();j++){
            input =input+index[currentLine][j].getText().charAt(0);
            }*//*
        System.out.println("---------------------");
        System.out.println(input);

        if (input.length() != generatedEquation.length() || !isEquationResultIsTrue(input)) {
            JOptionPane.showMessageDialog(frame, "This equation is not correct",
                    "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<Integer> status = new ArrayList<Integer>();
            ArrayList<Boolean> ifVisited = new ArrayList<Boolean>();
            checkCharactersStatus(generatedEquation, input, status, ifVisited);
            for (int i = 0; i < generatedEquation.length(); i++) {
                switch (status.get(i)) {
                    case 0:
                        *//*for (int j = currentLine; j < 6 ; j++) {
                            index[j][i].setText(String.valueOf(input.charAt(i)));
                            index[j][i].setEditable(false);
                            index[j][i].setBackground(Color.green);
                        }*//*
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
            if (input.compareTo(generatedEquation) == 0) {
                JOptionPane.showMessageDialog(frame, " You Won.\n ",
                        "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                Statistics stats = new Statistics();
                stats = readStatistics();
                stats.setAvgSuccessTime(null); *//** burayı UNUTMA *//*
                stats.setAvgFinishAtLines(((stats.getAvgFinishAtLines() * stats.getVictory()) + currentLine + 1) / (stats.getVictory() + 1));
                stats.setVictory(stats.getVictory() + 1);

                writeStatistics(stats);

            } else {
                if (currentLine == 5) {
                    JOptionPane.showMessageDialog(frame, "You lost.\n ",
                            "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    Statistics stats = new Statistics();
                    stats = readStatistics();
                    stats.setLosses(stats.getLosses() + 1);
                    writeStatistics(stats);
                } else {
                    currentLine++;
                    for (int i = 0; i < generatedEquation.length(); i++) {
                        index[currentLine][i].setEditable(true);

                    }
                }

            }

        }
    }

        private void backActionPerformed (java.awt.event.ActionEvent evt){
        GUI gui = new GUI();
        gui.setVisible(true);
        frame.dispose();
    }*/




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
