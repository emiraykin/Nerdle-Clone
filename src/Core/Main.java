package Core;
import Core.GenerateEquation.Generate;

public class Main {

    public static void main(String[] args) {
        Statistics s = new Statistics();
        IO io = new IO(); // READ STATISTICS FROM FILE
        Generate eq = new Generate();/*
        try {
            io.readFile(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.PrintStatsToTerminal(s);*/
        String equation = eq.GenerateEquation();
        //System.out.println(equation);

    }




}
