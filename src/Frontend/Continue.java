package Frontend;

import Core.SavedGame;
import Core.Statistics;
                          /** NewGame class'inin aynisi sadece matris dosyadan okunup en başta yaziliyor */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.util.ArrayList;

import static Core.Equation.EquationControls.*;
import static Core.Generate.GenerateEquation;
import static Core.SavedGame.readGame;
import static Core.SavedGame.writeGame;
import static Core.Statistics.readStatistics;
import static Core.Statistics.writeStatistics;

public class Continue implements ActionListener  {
    int elapsedTime = 0;
    int seconds =0;
    int minutes =0;
    int hours =0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    JLabel time = new JLabel("");
    JLabel footer = new JLabel("5 - 20011103 Mehmet Keçeci - 20011062 Emir Çağrı Aykın");


    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            elapsedTime=elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) ;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            time.setText(String.valueOf(seconds));
        }

    });

    int currentLine = 0;
    int currentColumn = 0;
    JButton submit = new JButton("   Guess   ");
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
    JButton btndelete = new JButton("   Delete   ");

    JButton btnSave = new JButton("Continue later");


    JPanel main = new JPanel( new BorderLayout() );
    JLabel CorrOrWrong = new JLabel("---");
    String generatedEquation ;
    private static JTextField[][] index = new JTextField[9][9];
    JFrame frame;



    public Continue (){
        if(!started){
            start();
            started=true;
        }
        generatedEquation = GenerateEquation();
        frame = new JFrame("Nerdle");// tum pencere ve ismi
        //frame.getContentPane().add(draw);
        frame.setSize(750,500);
        //submit.addActionListener(this);
        JPanel board = new JPanel();
        board.setPreferredSize( new Dimension(300, 500) );
        main.add(board,BorderLayout.CENTER);
        //JPanel panel = new JPanel();

        /** oyunu dosyadan okuma islemleri */

        if(readGame()!=null){
            SavedGame savedGame = new SavedGame();
            savedGame = readGame();
            index = savedGame.savedMatris;
            generatedEquation = savedGame.equation;
            currentLine=savedGame.currentLine;
            currentColumn=savedGame.currentColumn;
            elapsedTime=savedGame.seconds * 1000;

        }



        board.setLayout(new GridLayout (6,generatedEquation.length()));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j<generatedEquation.length(); j++){
                board.add(index[i][j]);
                int finalI = i;
                int finalJ = j;
                index[i][j].addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if(index[finalI][finalJ].isEditable()){
                            index[finalI][finalJ].setBackground(Color.CYAN);
                            currentColumn=finalJ;
                        }

                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if(index[finalI][finalJ].isEditable()) {
                            index[finalI][finalJ].setBackground(Color.WHITE);
                        }

                    }

                });
            }
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
        //buttonsPanel.add(back);
        buttonsPanel.add(btnSave);
        btnplus.setFont(new Font("Arial", Font.PLAIN, 16)); buttonsPanel.add(btnplus);
        btnminus.setFont(new Font("Arial", Font.PLAIN, 16)); buttonsPanel.add(btnminus);
        btncross.setFont(new Font("Arial", Font.PLAIN, 16));buttonsPanel.add(btncross);
        btnslash.setFont(new Font("Arial", Font.PLAIN, 16));buttonsPanel.add(btnslash);
        btnequals.setFont(new Font("Arial", Font.PLAIN, 16));buttonsPanel.add(btnequals);
        buttonsPanel.add(btndelete);

        buttonsPanel.add(submit);
        back.setBackground(Color.PINK);
        btnSave.setBackground(Color.yellow);
        buttonsPanel.add(time);



        main.add(buttonsPanel,BorderLayout.PAGE_END);


        frame.getContentPane().add(main);
        //frame.getContentPane().add(CorrOrWrong, "North");
        frame.getContentPane().add(footer, "South");

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
            if(!hasValidAmountOfOperators(input)){
                JOptionPane.showMessageDialog(frame, "maximum amounf of operators should be 2",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            }
            else if(input.length() != generatedEquation.length() || !EquationRegexControl(input) ){
                JOptionPane.showMessageDialog(frame, "Invalid Input Error",
                        "WARNING", JOptionPane.ERROR_MESSAGE);
            }else if (!isEquationResultIsTrue(input)){
                JOptionPane.showMessageDialog(frame, "This equation is wrong",
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
                    if(started){
                        stop();
                        started=false;
                    }

                    JOptionPane.showMessageDialog(frame, " You Won. Redirecting to Menu\n ",
                            "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    Statistics stats = new Statistics();
                    stats=readStatistics();
                    stats.setAvgSuccessTime((stats.getAvgSuccessTime() * stats.getVictory() + seconds )/(stats.getVictory() + 1)); /** burayı UNUTMA */
                    stats.setAvgFinishAtLines( ((stats.getAvgFinishAtLines() * stats.getVictory())  +currentLine + 1) / (stats.getVictory()+1));
                    stats.setVictory(stats.getVictory()+1);
                    stats.setUnfinishedGames(stats.getUnfinishedGames()-1);
                    writeStatistics(stats);
                    File file = new File("SavedGame.dat");
                    file.delete();
                    GUI gui = new GUI();
                    gui.setVisible(true);

                    frame.dispose();

                }
                else {
                    if(currentLine==5){
                        stop();
                        JOptionPane.showMessageDialog(frame, "You lost. Equation was : "+generatedEquation+ "  . Redirecting to menu",
                                "Game Over", JOptionPane.INFORMATION_MESSAGE);
                        Statistics stats = new Statistics();
                        stats=readStatistics();
                        stats.setLosses(stats.getLosses()+1);
                        writeStatistics(stats);
                        frame.getContentPane().add(CorrOrWrong, "North");
                        File file = new File("SavedGame.dat");
                        file.delete();
                        GUI gui = new GUI();
                        gui.setVisible(true);

                        frame.dispose();
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
            stop();
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
            back();
            index[currentLine][currentColumn].setText("");


        }
        else if(e.getSource() == btnSave){
            try{

                SavedGame savedGame = new SavedGame();
                savedGame.equation=generatedEquation;
                savedGame.savedMatris = index;
                savedGame.currentLine=currentLine;
                savedGame.currentColumn=currentColumn;
                savedGame.seconds=seconds;

                writeGame(savedGame);

                stop();
                JOptionPane.showMessageDialog(frame, "Your game is saved. Redirecting to Menu\n ",
                        "Saved", JOptionPane.INFORMATION_MESSAGE);
                Statistics stats = new Statistics();
                stats=readStatistics();
                stats.setUnfinishedGames(stats.getUnfinishedGames());
                writeStatistics(stats);
                GUI gui = new GUI();
                gui.setVisible(true);

                frame.dispose();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private void back() {
        if(currentColumn>0){
            if(index[currentLine][currentColumn].getText().compareTo("")==0){
                index[currentLine][--currentColumn].requestFocus();
            }

            else{
                index[currentLine][currentColumn].requestFocus();
                index[currentLine][currentColumn].setText("");
            }


        }else {
            if(index[currentLine][currentColumn].getText().compareTo("")!=0)
                index[currentLine][currentColumn].setText("");
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



    void start() {
        timer.start();
    }
    void stop() {
        timer.stop();
    }
    void reset(){
        timer.restart();
    }



/*
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
    }*/


}
