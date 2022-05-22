package Core.GenerateEquation;
import java.util.ArrayList;


public class GenerateEquation {

    public int generateRandom(int min,int max){
         return (int) Math.floor(Math.random()*(max-min+1)+min);
    }

    public int Calculate(int value1, int value2,ArrayList<Character>ops){
        int result;
        int op = generateRandom(0,6);
        if(op == 0){
            result = value1 + value2;
            ops.add('+');
        }
        else if( op == 1){
            result = value1-value2;
            ops.add('-');
        }
        else if(op==2){
            result = value1*value2;
            ops.add('*');
        }
        else {
            if(value2 == 0){
                return -9999;
            }
            else if((value1 %value2) == 0)
                result=value1/value2;
            else
                return-9999;
            ops.add('/');
        }


        return result;
    }


    public String GenerateEq(){
        ArrayList<Integer> eq = new ArrayList<>();
        ArrayList<Character>ops = new ArrayList<>();
        String equationString ;
        int max = 12;
        int min = 0;
        System.out.println("x");
        do{
            System.out.println("y");
            eq.clear();
            eq.add(generateRandom(min,max));
            eq.add(generateRandom(min,max));
            eq.add(Calculate(eq.get(0),eq.get(1),ops));
            equationString = Integer.toString(eq.get(0)) + ops.get(0) + Integer.toString(eq.get(1)) + "=" + Integer.toString(eq.get(2));
            if(eq.get(2) != -9999){
                if(equationString.length()<7){
                    eq.add(generateRandom(min,max));
                    eq.add(Calculate(eq.get(2),eq.get(3),ops));
                    if(eq.get(4) != -9999){
                        equationString = Integer.toString(eq.get(0)) + ops.get(0) + Integer.toString(eq.get(1)) + ops.get(1) + Integer.toString(eq.get(3))+
                                "=" + Integer.toString(eq.get(4));
                    }
                }
            }

        }while (equationString.length()<7 || equationString.length() > 9);



        return equationString;
    }
}
