package Core.Equation;

import java.util.ArrayList;

public class EquationUtilities {

    public static int generateRandom(int min,int max){
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }


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

    public static Boolean checkForPriority(ArrayList<Character> ops){
        return (ops.get(1).equals('/') || ops.get(1).equals('*')) && (ops.get(0).equals('+') || ops.get(0).equals('-'));
    }


}
