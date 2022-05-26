package Core.Equation;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.Stack;

public class EquationUtilities {

    /*
        THESE METHODS WILL BE USED IN BACK-END
    */

    public static int generateRandom(int min,int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }

    //Randomly select operation
    public static void selectOP(ArrayList<Character> ops){
        int op = generateRandom(0,6);
        if(op == 0) ops.add('+');
        else if( op == 1) ops.add('-');
        else if(op==2) ops.add('*');
        else ops.add('/');
    }

    public static int calculateEquationResult(int value1, int value2,char op){
        int result;
        if(op == '+'){
            result = value1 + value2;
        }
        else if( op == '-'){
            result = value1-value2;
        }
        else if(op=='*'){
            result = value1*value2;
        }
        else {
            if(value2 == 0 ||(value1 %value2) != 0 ){
                return -9999;
            }
            else{
                result=value1/value2;
            }

        }
        return result;
    }

    //check if a character in string is operator or not
    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String[] splitEquationStringToNumbers(String Equation){
        return Equation.split("[*/+=-]");
    }

    //check for precedence if there are more than 1 operator in the equation
    public static Boolean checkForPriority(ArrayList<Character> ops){
        return (ops.get(1).equals('/') || ops.get(1).equals('*')) && (ops.get(0).equals('+') || ops.get(0).equals('-'));
    }

    //UNCOMPLETED - Calculate by precedence
    public static int calculateEquation(String Equation){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            return (int) engine.eval(Equation);
        }
        catch (Exception e){
            e.printStackTrace();
            return -9999;
        }
    }


}
