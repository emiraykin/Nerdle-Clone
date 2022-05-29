package Core.Equation;

import java.util.ArrayList;
import java.util.Arrays;

public class EquationControls {

    /*
        THESE METHODS WILL BE USED IN FRONT-END
     */

    /*
        CRITICAL NOTE : status and visited lists size should be initialized to Equation.length()

        status.get(Index) == 0 -> User Input at the right location , PAINT IT GREEN
        status.get(Index) == 1 -> User Input not in the right location, but exists in the equation , PAINT IT YELLOW
        status.get(Index) == 2 -> User Input nor in the right location or exists in the equation , PAINT IT RED
        status.get(Index) == 3 -> Neutral, PAINT IT GRAY or whatever
     */
    public static void checkCharactersStatus(String Equation,String playerInput,ArrayList<Integer> status,ArrayList<Boolean> ifVisited){
        int i,j;
        for (int k = 0; k < Equation.length(); k++) {
            status.add(3);
            ifVisited.add(false);
        }
        for( i=0;i<Equation.length();i++){
            for(j=0;j<Equation.length();j++){
                if(playerInput.charAt(i) == Equation.charAt(j) && !ifVisited.get(j)){
                    status.set(i,1);
                    ifVisited.set(j,true);
                    break;
                }
            }
            if (j == Equation.length()){
                status.set(i,2);
            }
        }
        for(i=0;i<Equation.length();i++){
            if(Equation.charAt(i) == playerInput.charAt(i)){
                status.set(i,0);
                ifVisited.set(i,true);
            }
        }

    }
    /*
        Returns True if equation is valid
     */
    public static boolean isEquationResultIsTrue(String Equation){
        int i;
        ArrayList<Character> ops = new ArrayList<>(2);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (i=0;i<Equation.length();i++){
            if(Equation.charAt(i) == '=') break;
            if(EquationUtilities.isOperator(Equation.charAt(i))) ops.add(Equation.charAt(i));
        }
        String[] tokens = EquationUtilities.splitEquationStringToNumbers(Equation);
        for (String token : tokens) {
            if(!token.equals(""))
                numbers.add(Integer.parseInt(token));
        }
        if(Equation.charAt(i+1) == '-') numbers.set(numbers.size()-1,Integer.parseInt(String.valueOf(- numbers.get(numbers.size() - 1))));
        if(ops.size() == 1){
            return numbers.get(2) == EquationUtilities.calculateEquationResult(numbers.get(0), numbers.get(1), ops.get(0));
        }
        else{
            if(EquationUtilities.checkForPriority(ops)){
                i = EquationUtilities.calculateEquationResult(numbers.get(1),numbers.get(2), ops.get(1));
                i = EquationUtilities.calculateEquationResult(numbers.get(0),i,ops.get(0));
            }
            else {
                i = EquationUtilities.calculateEquationResult(numbers.get(0),numbers.get(1), ops.get(0));
                i = EquationUtilities.calculateEquationResult(i,numbers.get(2),ops.get(1));
            }
            return i == numbers.get(3);
        }
    }

    public static boolean EquationRegexControl(String Equation){
        int i,equalsCounter=0,opCounter=0;
        //if equation too big return false
        if(Equation.length() > 9) return false;
        //if first or last character is an operator return false
        if(EquationUtilities.isOperator(Equation.charAt(0)) || EquationUtilities.isOperator(Equation.charAt(Equation.length()-1)))
            return false;
        for(i=1;i<Equation.length();i++){
            //if two operators are in series or an operator is right behind equals sign, return false
            if(EquationUtilities.isOperator(Equation.charAt(i-1))  && (EquationUtilities.isOperator(Equation.charAt(i)) || Equation.charAt(i) == '='))
                return false;
            if (Equation.charAt(i) == '=') equalsCounter++;
            if(EquationUtilities.isOperator(Equation.charAt(i))) opCounter++;
        }
        if(equalsCounter == 0 ||opCounter == 0 ||opCounter>2) return false;
        else return true;
    }
}



