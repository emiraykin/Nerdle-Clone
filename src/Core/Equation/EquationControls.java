package Core.Equation;

import java.util.ArrayList;

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
        for (int k = 0; k < Equation.length(); k++) { // Create lists
            status.add(3);
            ifVisited.add(false);
        }
        //User Input at the right location
        for(i=0;i<Equation.length();i++){
            if(Equation.charAt(i) == playerInput.charAt(i)){
                status.set(i,0);
                ifVisited.set(i,true);
            }
        }
        //User input exists in the equation but in the wrong place
        for( i=0;i<Equation.length();i++){
            if(!ifVisited.get(i)){
                for(j=0;j<Equation.length();j++){
                    //User Input not in the right location, but exists in the equation
                    if(playerInput.charAt(i) == Equation.charAt(j) && !ifVisited.get(j)){
                        status.set(i,1);
                        ifVisited.set(i,true);
                        break;
                    }
                }

            }
        }
        //User Input nor in the right location or exists in the equation
        for (i=0;i<Equation.length();i++)
            if (!ifVisited.get(i)) status.set(i,2);
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
        int i;
        boolean flagOperationAfterEqualsSign = false;
        //if first or last character is an operator return false
        if(EquationUtilities.isOperator(Equation.charAt(0)) || EquationUtilities.isOperator(Equation.charAt(Equation.length()-1)))
            return false;
        for(i=1;i<Equation.length();i++){
            //if two operators are in series or an operator is right behind equals sign, return false
            if(EquationUtilities.isOperator(Equation.charAt(i-1))  && (EquationUtilities.isOperator(Equation.charAt(i)) || Equation.charAt(i) == '='))
                return false;
            if(flagOperationAfterEqualsSign){
                //if there is an operator after equals sign return false
                if(Equation.charAt(i-1) == '=' && Equation.charAt(i) != '-'){
                    if((EquationUtilities.isOperator(Equation.charAt(i)) )){
                        return false;
                    }
                }
            }
            if (Equation.charAt(i) == '=') flagOperationAfterEqualsSign = true;

        }
        //if there are no equal or operation sign, or operation sign is more than 3 (which is max ops for
        //max length) or equals sign more than 1 (which is max for all equations) return false
        //if there is a character which is not a digit or operation return false;
        return hasOnlyDigitsAndOperators(Equation) && hasValidAmountOfOperators(Equation) && hasExactlyOneEquals(Equation);
    }

    /*
        THIS METHODS WILL BE USED IN UNIT TEST OF Generate.GenerateEquation
     */
    public static boolean isEquationLengthValid(String eq){
        return eq.length() >= 7 && eq.length() <= 9;
    }

    public static boolean hasExactlyOneEquals(String eq){
        int counter = 0;
        for (int i=0; i< eq.length();i++){
            if (eq.charAt(i) == '=') counter++;
        }
        return counter == 1;
    }

    public static boolean hasValidAmountOfOperators(String eq){
        int counter = 0;
        for (int i=0; i< eq.length();i++){
            if (EquationUtilities.isOperator(eq.charAt(i))) counter++;
        }
        return counter == 1 || counter == 2;
    }

    public static boolean hasOnlyDigitsAndOperators(String Equation){
        for(int i=0;i<Equation.length();i++){
            //if input is not a digit or operation or equals sign return false;
            if(Equation.charAt(i)!='0' && Equation.charAt(i)!='1' && Equation.charAt(i)!='2' && Equation.charAt(i)!='3' &&
                    Equation.charAt(i)!='4' && Equation.charAt(i)!='5' && Equation.charAt(i)!='6' && Equation.charAt(i)!='7'
                    && Equation.charAt(i)!='8' && Equation.charAt(i)!='9' && Equation.charAt(i) != '=' && !EquationUtilities.isOperator(Equation.charAt(i)))
                return false;
        }
        return true;
    }
}



