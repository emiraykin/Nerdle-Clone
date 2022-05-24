package Core.GenerateEquation;
import java.util.ArrayList;


public class Generate {

    public int generateRandom(int min,int max){
         return (int) Math.floor(Math.random()*(max-min+1)+min);
    }


    public int Calculate2(int op,int value1, int value2){
        int result;
        if(op == 0){
            result = value1 + value2;;
        }
        else if( op == 1){
            result = value1-value2;
        }
        else if(op==2){
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
            if(value2 == 0 ||(value1 %value2) != 0 ){
                ops.add('?');
                return -9999;
            }
            else{
                result=value1/value2;
                ops.add('/');
            }

        }


        return result;
    }


    public String GenerateEquation(){
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
            eq.add(Calculate(eq.get(0),eq.get(1),ops));
            System.out.println(eq);
            if(eq.get(3) != -9999){
                equationString = Integer.toString(eq.get(0)) + ops.get(0) + Integer.toString(eq.get(1)) + "=" + Integer.toString(eq.get(3));
                if(equationString.length()<7){
                    eq.set(3,Calculate(eq.get(3),eq.get(2),ops));
                    System.out.println(eq);
                    if(eq.get(3) != -9999){
                        if((ops.get(1).equals('/')  || ops.get(1).equals('*') ) && !(ops.get(0).equals('/')  || !ops.get(0).equals('*'))){
                            eq.set(3,Calculate2(eq.get(1),eq.get(2),ops.get(1)));
                            eq.set(3,Calculate2(eq.get(3),eq.get(0),ops.get(0)));
                        }
                        System.out.println(eq);
                        equationString = Integer.toString(eq.get(0)) + ops.get(0) + Integer.toString(eq.get(1)) + ops.get(1) + Integer.toString(eq.get(2))+
                                "=" + Integer.toString(eq.get(3));
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
