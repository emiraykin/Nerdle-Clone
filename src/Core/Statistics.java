package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// istatistikleri  daha kolay kaydedebilmek icin istatistikleri serialize eden , dosyaya okuyup yazan siniftir.

public class Statistics implements Serializable,ActionListener {
    private static final long serialVersionUID = 1L;
    private static boolean isPlayedBefore;
    private Integer victory;
    private Integer losses;
    private Integer unfinishedGames;
    private float avgFinishAtLines;
    private int avgSuccessTime;
    private static final String fileName = "GameStatistics";



    public Statistics() {//Constructor
       victory = 0;
        losses = 0;
        unfinishedGames = 0;
        avgFinishAtLines = 0;
        avgSuccessTime = 0;
    }
    public void PrintStatsToTerminal(Statistics s){
        System.out.println("Wins : " + s.getVictory() + "\nLosses : " + s.getLosses() + "\nUnfinished Games : "
                + s.getUnfinishedGames() + "\nAverage Finish At Lines : " + s.getAvgFinishAtLines() + "\nAvg Success Time : " +
                s.getAvgSuccessTime()
        );
    }
    public static void writeStatistics(Statistics s){
        String filename = "Stats.dat";
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));
            writer.writeObject(s);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static Statistics readStatistics(){
        String filename = "Stats.dat";
        File f = new File("Stats.dat");
        if(!f.exists()){
            return null;
        }
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename));
            Statistics stats = (Statistics) reader.readObject();
            reader.close();
            return stats;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            return null;
        }
        return null;
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

    public void setAvgFinishAtLines(float avgFinishAtLines) {
        this.avgFinishAtLines = avgFinishAtLines;
    }

    public int getAvgSuccessTime() {
        return avgSuccessTime;
    }

    public void setAvgSuccessTime(int avgSuccessTime) {
        this.avgSuccessTime = avgSuccessTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
