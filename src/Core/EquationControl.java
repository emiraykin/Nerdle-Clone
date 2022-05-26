package Core;

import java.util.ArrayList;

public class EquationControl {
    /*
        CRITICAL NOTE : status and visited lists size should be initialized to Equation.length() or playerInput.length()
        (don't need to say both of the strings should have equal size)

        status.get(Index) == 0 -> User Input at the right location , PAINT IT GREEN
        status.get(Index) == 1 -> User Input not in the right location, but exists in the equation , PAINT IT YELLOW
        status.get(Index) == 2 -> User Input nor in the right location or exists in the equation , PAINT IT RED

     */
    public static ArrayList<Integer> checkCharactersStatus(String Equation,String playerInput,ArrayList<Integer> status,ArrayList<Boolean> ifVisited){
        int i=0,j;
        while(i<Equation.length()){
            ifVisited.set(i,false);
            i++;
        }
        for( i=0;i<Equation.length();i++){
            if(Equation.charAt(i) == playerInput.charAt(i)){
                status.set(i,0);
                ifVisited.set(i,true);
            }
            else{
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

        }

        return status;
    }

}
