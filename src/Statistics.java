import java.io.BufferedWriter;
import java.io.FileWriter;

public class Statistics {
    private int victory;
    private int losses;
    private int unfinishedGames;
    private int avgFinishAtLines;
    private int avgSuccessTime;
    private String fileName;

    public Statistics() {//Constructor
    }

    public boolean writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(victory + " " + losses + " " + unfinishedGames + " " + avgFinishAtLines + " " + avgSuccessTime);

            writer.close();
        }
        catch (java.io.IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean readFile(){



        return true;
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
