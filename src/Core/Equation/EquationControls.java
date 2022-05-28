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
        for (i=0;i<Equation.length();i++)
            if(EquationUtilities.isOperator(Equation.charAt(i)))
                ops.add(Equation.charAt(i));

        String[] tokens = EquationUtilities.splitEquationStringToNumbers(Equation);
        for(i=0;i<tokens.length;i++){
            numbers.add(Integer.parseInt(tokens[i]));
        }
        if(ops.size() == 1){
            return numbers.get(2) == EquationUtilities.calculateEquationResult(numbers.get(0), numbers.get(1), ops.get(0));
        }
        else{
            i=0;
            if(EquationUtilities.checkForPriority(ops)){
                i = EquationUtilities.calculateEquationResult(numbers.get(2),numbers.get(1), ops.get(1));
                i = EquationUtilities.calculateEquationResult(numbers.get(0),i,ops.get(0));
            }
            else {
                i = EquationUtilities.calculateEquationResult(numbers.get(0),numbers.get(1), ops.get(0));
                i = EquationUtilities.calculateEquationResult(i,numbers.get(2),ops.get(1));
            }
            return i == numbers.get(3);
        }
    }
}
