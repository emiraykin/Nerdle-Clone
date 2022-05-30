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
    public static void selectOP(ArrayList<Character> ops){ //Selects operation
        //op = 0 addition, op== 1 sub, op ==2 ,mul, op 3,4,5,6,7,8 div
        //there is a chance for mul result is not valid, so I give it more possibility to increase variation in the equation
        int op = generateRandom(0,8);
        if(op == 0) ops.add('+');
        else if( op == 1) ops.add('-');
        else if(op==2) ops.add('*');
        else ops.add('/');
    }

    //calculate result of the two Integers with given operation
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
            if(value2 == 0 ||(value1 %value2) != 0 ){ //if the divider == 0 or result ist not Integer return -9999
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

    //splits equation based on operator signs and equal sign
    public static String[] splitEquationStringToNumbers(String Equation){
        return Equation.split("[*/+=-]");
    }

    //check for precedence if there are more than 1 operator in the equation
    public static Boolean checkForPriority(ArrayList<Character> ops){
        return (ops.get(1).equals('/') || ops.get(1).equals('*')) && (ops.get(0).equals('+') || ops.get(0).equals('-'));
        //return true if the right side of the operation has more precedence
    }

    public static int[] selectNumberInterval(int[] MinMaxArray){ //this function helps to increase equation variety
        //0-10 has more possibility
        if(generateRandom(0,10) > 3) {
            MinMaxArray[0] = 0;
            MinMaxArray[1] = 10;
        }
        else {
            MinMaxArray[0] = 11;
            MinMaxArray[1] = 99;
        }
        return MinMaxArray;
    }


}
