import java.io.*;

public class Statistics implements Serializable {
    private int victory;
    private int losses;
    private int unfinishedGames;
    private int avgFinishAtLines;
    private int avgSuccessTime;
    private static final String fileName = "GameStatistics";

    public Statistics() {//Constructor
        victory = 0;
        losses = 0;
        unfinishedGames = 0;
        avgFinishAtLines = 0;
        avgSuccessTime = 0;
    }

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

    public int getAvgFinishAtLines() {
        return avgFinishAtLines;
    }

    public void setAvgFinishAtLines(int avgFinishAtLines) {
        this.avgFinishAtLines = avgFinishAtLines;
    }

    public int getAvgSuccessTime() {
        return avgSuccessTime;
    }

    public void setAvgSuccessTime(int avgSuccessTime) {
        this.avgSuccessTime = avgSuccessTime;
    }
}
