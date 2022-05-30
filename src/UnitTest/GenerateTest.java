package UnitTest;

import Core.Equation.EquationControls;
import Core.Generate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTest {

    @Test
    public void hasExactlyOneEquals() {
        String eq = Generate.GenerateEquation();
        assertTrue(Generate.hasExactlyOneEquals(eq));
    }
    @Test
    public void hasValidAmountOfOperators(){
        String eq = Generate.GenerateEquation();
        assertTrue(Generate.hasValidAmountOfOperators(eq));
    }
    @Test
    public void isOperationResultIsTrue(){
        String eq = Generate.GenerateEquation();
        assertTrue(EquationControls.isEquationResultIsTrue(eq));
    }
    @Test
    public void isValidLength(){
        String eq = Generate.GenerateEquation();
        assertTrue(Generate.isEquationLengthValid(eq));
    }

}