package Core;
import Core.GenerateEquation.GenerateEquation;
import Core.Statistics;
public class Main {

    public static void main(String[] args) {
        Statistics s = new Statistics();
        IO io = new IO(); // READ STATISTICS FROM FILE
        GenerateEquation eq = new GenerateEquation();/*
        try {
            io.readFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.PrintStatsToTerminal(s);*/
        String equation = eq.GenerateEq();
        System.out.println(equation);

    }




}
