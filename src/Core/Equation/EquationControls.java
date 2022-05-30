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
        for (int k = 0; k < Equation.length(); k++) { // creates lists
            status.add(3);
            ifVisited.add(false);
        }
        for( i=0;i<Equation.length();i++){
            for(j=0;j<Equation.length();j++){
                //User Input not in the right location, but exists in the equation
                if(playerInput.charAt(i) == Equation.charAt(j) && !ifVisited.get(j)){
                    status.set(i,1);
                    ifVisited.set(j,true);
                    break;
                }
            }
            //User Input nor in the right location or exists in the equation
            if (j == Equation.length()){
                status.set(i,2);
            }
        }
        //User Input at the right location
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
        //finds operators until = sign comes
        for (i=0;i<Equation.length();i++){
            if(Equation.charAt(i) == '=') break;
            if(EquationUtilities.isOperator(Equation.charAt(i))) ops.add(Equation.charAt(i));
        }
        //parses equation to numbers
        String[] tokens = EquationUtilities.splitEquationStringToNumbers(Equation);
        for (String token : tokens) {
            if(!token.equals("")) // control for a special case --> if there is - after = sign
                numbers.add(Integer.parseInt(token));
        }
        //if there is - after = sign set last number to neg
        if(Equation.charAt(i+1) == '-') numbers.set(numbers.size()-1,-numbers.get(numbers.size()-1));
        if(ops.size() == 1){
            //if there is only one operation
            return numbers.get(2) == EquationUtilities.calculateEquationResult(numbers.get(0), numbers.get(1), ops.get(0));
        }
        else{
            //if right side has more precedence
            if(EquationUtilities.checkForPriority(ops)){
                i = EquationUtilities.calculateEquationResult(numbers.get(1),numbers.get(2), ops.get(1));
                i = EquationUtilities.calculateEquationResult(numbers.get(0),i,ops.get(0));
            }
            //if there is no precedence or left has more
            else {
                i = EquationUtilities.calculateEquationResult(numbers.get(0),numbers.get(1), ops.get(0));
                i = EquationUtilities.calculateEquationResult(i,numbers.get(2),ops.get(1));
            }
            return i == numbers.get(3);
        }
    }

    /*
        Returns TRUE if equation is in valid format
     */
    public static boolean EquationRegexControl(String Equation){
       // if(!Equation.matches(pattern)) return false;
        int i,equalsCounter=0,opCounter=0;
        boolean flagOperationAfterEqualsSign = false;

        //if first or last character is an operator return false
        if(EquationUtilities.isOperator(Equation.charAt(0)) || EquationUtilities.isOperator(Equation.charAt(Equation.length()-1)))
            return false;
        for(i=1;i<Equation.length();i++){
            //if two operators are in series or an operator is right behind equals sign, return false
            if(EquationUtilities.isOperator(Equation.charAt(i-1))  && (EquationUtilities.isOperator(Equation.charAt(i)) || Equation.charAt(i) == '='))
                return false;
            //counts equal character in player input
            if (Equation.charAt(i) == '=')
                equalsCounter++;

            if(flagOperationAfterEqualsSign){
                //if there is an operator after equals sign return false
                if(Equation.charAt(i-1) == '=' && Equation.charAt(i) != '-'){
                    if((EquationUtilities.isOperator(Equation.charAt(i)) )){
                        return false;
                    }
                }
            }
            if (Equation.charAt(i) == '=') flagOperationAfterEqualsSign = true;
            //counts how many operations
            if(EquationUtilities.isOperator(Equation.charAt(i))) opCounter++;
        }
        //if there are no equal or operation sign, or operation sign is more than 3 (which is max ops for
        //max length) or equals sign more than 1 (which is max for all equations) return false
        if(equalsCounter == 0 ||opCounter == 0 ||opCounter>3 || equalsCounter>1) return false;
        else return true;
    }
}



