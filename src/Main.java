import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Statistics s = new Statistics();
        IO io = new IO(); // READ STATISTICS FROM FILE
        try {
            io.readFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Wins : " + s.getVictory() + "\nLosses : " + s.getLosses() + "\nUnfinished Games : "
                + s.getUnfinishedGames() + "\nAverage Finish At Lines : " + s.getAvgFinishAtLines() + "\nAvg Success Time : " +
                s.getAvgSuccessTime()
        );


    }




}
