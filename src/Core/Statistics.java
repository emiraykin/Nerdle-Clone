package Core;

import java.io.*;
import java.util.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Statistics implements Serializable {
    private boolean isPlayedBefore;
    private int victory;
    private int losses;
    private int unfinishedGames;
    private float avgFinishAtLines;
    private Timer avgSuccessTime;
    private static final String fileName = "GameStatistics";

    public Statistics() {//Constructor
        victory = 0;
        losses = 0;
        unfinishedGames = 0;
        avgFinishAtLines = 0;
        avgSuccessTime = null;
    }
    public void PrintStatsToTerminal(Statistics s){
        System.out.println("Wins : " + s.getVictory() + "\nLosses : " + s.getLosses() + "\nUnfinished Games : "
                + s.getUnfinishedGames() + "\nAverage Finish At Lines : " + s.getAvgFinishAtLines() + "\nAvg Success Time : " +
                s.getAvgSuccessTime()
        );
    }
    /*public

            try {
                File myObj = new File("dosyam.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }*/




    public String getFileName() {
        return fileName;
    }

    public int getUnfinishedGames() {
        return unfinishedGames;
    }

    public void setUnfinishedGames(int unfinishedGames) {
        this.unfinishedGames = unfinishedGames;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public float getAvgFinishAtLines() {
        return avgFinishAtLines;
    }

    public void setAvgFinishAtLines(int avgFinishAtLines) {
        this.avgFinishAtLines = avgFinishAtLines;
    }

    public Timer getAvgSuccessTime() {
        return avgSuccessTime;
    }

    public void setAvgSuccessTime(Timer avgSuccessTime) {
        this.avgSuccessTime = avgSuccessTime;
    }
}
