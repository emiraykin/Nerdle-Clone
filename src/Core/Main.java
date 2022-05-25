package Core;

import Frontend.GUI;

import static Core.Statistics.writeStatistics;

public class Main {
    public static int[] array;
    public static void main(String[] args) throws InterruptedException {
        Statistics stats = new Statistics();
        //writeStatistics(stats);
        GUI gui = new GUI();
        gui.setVisible(true);
        Statistics s = new Statistics();
        IO io = new IO(); // READ STATISTICS FROM FILE
        Generate eq = new Generate();
        /*try {
            io.readFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        /*s.PrintStatsToTerminal(s);
        String equation = eq.GenerateEquation();*/
        //System.out.println(equation);

    }





}
