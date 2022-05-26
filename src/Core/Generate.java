package Core;
import java.util.ArrayList;


public class Generate {

    public static int generateRandom(int min,int max){
         return (int) Math.floor(Math.random()*(max-min+1)+min);
    }

    public static void selectOP(ArrayList<Character>ops){
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

    public static String GenerateEquation(){
        ArrayList<Integer> eq = new ArrayList<>();
        ArrayList<Character>ops = new ArrayList<>();
        String equationString;
        int max = 12;
        int min = 0;
        do{
            equationString = "";
            eq.clear();
            ops.clear();
            eq.add(generateRandom(min,max));
            eq.add(generateRandom(min,max));
            eq.add(generateRandom(min,max));
            selectOP(ops);
            eq.add(calculateEquationResult(eq.get(0),eq.get(1),ops.get(0)));
            System.out.println(eq);
            if(eq.get(3) != -9999){
                equationString = Integer.toString(eq.get(0)) + ops.get(0) + (eq.get(1)) + "=" + (eq.get(3));
                if(equationString.length()<7){
                    selectOP(ops);
                    eq.set(3,calculateEquationResult(eq.get(3),eq.get(2),ops.get(1)));
                    System.out.println(eq);
                    if(eq.get(3) != -9999){
                        if(checkForPriority(ops)){
                            eq.set(3,calculateEquationResult(eq.get(1),eq.get(2),ops.get(1)));
                            if(eq.get(3) != -9999)
                                eq.set(3,calculateEquationResult(eq.get(3),eq.get(0),ops.get(0)));
                        }
                        System.out.println(eq);
                        equationString = Integer.toString(eq.get(0)) + ops.get(0) + (eq.get(1)) + ops.get(1) + (eq.get(2))+ "=" + (eq.get(3));
                    }
                }
            }
            System.out.println(equationString);
            System.out.println(ops);
            System.out.println("-----------------");
        }while (equationString.length()<7 || equationString.length() > 9);



        return equationString;
    }
}
