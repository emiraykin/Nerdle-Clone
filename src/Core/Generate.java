package Core;
import Core.Equation.EquationUtilities;

import java.util.ArrayList;


public class Generate {



    public static String GenerateEquation(){
        ArrayList<Integer> eq = new ArrayList<>();
        ArrayList<Character>ops = new ArrayList<>();
        String equationString;
        int max = 12;
        int min = 0;
        int minusCTRL;
        do{
            equationString = "";
            minusCTRL = 0;
            eq.clear();
            ops.clear();
            eq.add(EquationUtilities.generateRandom(min,max));
            eq.add(EquationUtilities.generateRandom(min,max));
            eq.add(EquationUtilities.generateRandom(min,max));
            EquationUtilities.selectOP(ops);
            eq.add(EquationUtilities.calculateEquationResult(eq.get(0),eq.get(1),ops.get(0)));

            System.out.println(eq);
            if(eq.get(3) != -9999){
                equationString = Integer.toString(eq.get(0)) + ops.get(0) + (eq.get(1)) + "=" + (eq.get(3));
                if(equationString.length()<7){
                    EquationUtilities.selectOP(ops);
                    eq.set(3,EquationUtilities.calculateEquationResult(eq.get(3),eq.get(2),ops.get(1)));
                    System.out.println(eq);
                    if(eq.get(3) != -9999){
                        if(EquationUtilities.checkForPriority(ops)){
                            eq.set(3,EquationUtilities.calculateEquationResult(eq.get(1),eq.get(2),ops.get(1)));
                            if(eq.get(3) != -9999)
                                eq.set(3,EquationUtilities.calculateEquationResult(eq.get(0),eq.get(3),ops.get(0)));
                        }
                        System.out.println(eq);
                        equationString = Integer.toString(eq.get(0)) + ops.get(0) + (eq.get(1)) + ops.get(1) + (eq.get(2))+ "=" + (eq.get(3));
                    }
                }
            }
            System.out.println(equationString);
            System.out.println(ops);
            System.out.println("-----------------");
            if(eq.get(3) < 0) minusCTRL = 1;
        }while (equationString.length() - minusCTRL<7|| equationString.length()- minusCTRL > 9 );



        return equationString;
    }
}
