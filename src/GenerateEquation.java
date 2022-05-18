import java.util.*;
public class GenerateEquation {
    static ArrayList<Integer> numbers = new ArrayList<Integer>();
    static ArrayList<String> equation = new ArrayList<String>();
    static int[] numbersi = new int[4] ;
    static char[] symbolsc = {'+','-','*','/'};
    static char[] symbols = new char[3];

    private static Random rnd = new Random();
    public static void main(String[]args) {
        int j;

        //char[] equation = new char[10];
        int length = rnd.nextInt(7,10);
        System.out.println(length);
        int counter = 0;
        String emre = new String();
        int result;
        while (counter != length){
            int i = 0;
            equation.clear();
            if(length == 7 || length == 8 ) {
                numbersi[0] = rnd.nextInt(1, 9);
                counter++;
                for (j = 1; j < 3; j++) {
                    numbersi[j] = rnd.nextInt(1, 9);
                    counter++;
                }
                symbols[0] = symbolsc[rnd.nextInt(2)];
                for (j = 1; j < 2; j++) {
                    symbols[j] = symbolsc[rnd.nextInt(2)];
                    counter++;
                }


                for (j = 0; j < numbersi.length - 2; j++) {
                    equation.add(Integer.toString(numbersi[j]));
                    equation.add(Character.toString(symbols[j]));


                }
                equation.add(Integer.toString( numbersi[j]));

                System.out.println("");
                equation.add("=");
                result=calcResult();
                equation.add(Integer.toString(result));
                counter+=result/10 + 1;
                for (String str : equation) {
                    System.out.print(str);
                }
            }


        }


    }//end main
    public static int calcResult(){
        int i=1;
        int result=numbersi[0];
        while(numbersi[i]!=0){
            if(symbols[i]=='+'){
                result+=numbersi[i];
            }

            else if(symbols[i]=='-'){
                result-=numbersi[i];
            }
            i++;
        }


        return result;
    }
/*
        private static int[][] create(int[][] ray, int row, int col){
            try{
                //Variable used to detect if the sudoku puzzle is stuck
                int countLoop = 0;
                do{
                    if(countLoop ==10) {ray = cleanRow(ray, row); col = 0;}
                    ray[row][col] = rnd.nextInt(9)+1; //return a number from 1 to 9.
                    countLoop++;
                } while(!(testSquare(ray, row, col) && testColRow(ray, row, col)));
                countLoop = 0;

                //Base case: if the puzzle has been fully solved, return the provided array.
                if(row == 8 && col==8) return ray;

                //Restart Row
                if(col==8) return create(ray, row+1, 0);

                //Restart Col
                return create(ray, row, col+1);
            } catch (StackOverflowError e) {
                return null;
            } catch (NullPointerException e) {
                return null;
            }
        }//end method

/**


*/


}
