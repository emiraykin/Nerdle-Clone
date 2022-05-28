package Core;

import Core.Equation.EquationControls;
import Frontend.GUI;

import java.util.ArrayList;
import java.util.Scanner;

import static Core.Equation.EquationControls.checkCharactersStatus;
import static Core.Equation.EquationControls.isEquationResultIsTrue;
import static Core.Statistics.readStatistics;
import static Core.Statistics.writeStatistics;

public class Main {
    Statistics stats;

    public static int[] array;
    public static void main(String[] args) throws InterruptedException {
        Statistics stats;
        if(readStatistics()==null){
            stats = new Statistics();

        }
        else{
            stats = readStatistics();
        }
        writeStatistics(stats);
        GUI gui = new GUI();
        gui.setVisible(true);
        Statistics s = new Statistics();
        IO io = new IO(); // READ STATISTICS FROM FILE


        //PLAYABLE DEMO ON THE TERMINAL
        Scanner sc= new Scanner(System.in);
        String Equation = Generate.GenerateEquation();
        String playerInput;
        int counter = 0;
        int i;
        ArrayList<Integer> status = new ArrayList<>(Equation.length());
        i=0;
        while(i<Equation.length()){
            status.add(i,3);
            i++;
        }
        i = 0;
        ArrayList<Boolean> ifVisited = new ArrayList<>(Equation.length());
        while(i<Equation.length()){
            ifVisited.add(i,false);
            i++;
        }
        while (counter != 6 && (status.contains(1) || status.contains(2) || status.contains(3))){
            System.out.println(Equation);
            do{
                System.out.println("Your input: \n");
                playerInput = sc.nextLine();              //reads string
                if(!isEquationResultIsTrue(playerInput))
                    System.out.println("This eq is not calculable!!\n Please re-enter your input.\n");
            }while (!isEquationResultIsTrue(playerInput));
            checkCharactersStatus(Equation,playerInput,status,ifVisited);
            System.out.println(status);
            counter++;
        }
        //PLAYABLE DEMO END

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
