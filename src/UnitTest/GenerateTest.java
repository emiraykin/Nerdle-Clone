package UnitTest;

import Core.Equation.EquationControls;
import Core.Generate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateTest {

    @Test
    public void hasExactlyOneEquals() {
        //EquationControls.hasExactlyOneEquals method tests
        assertTrue(EquationControls.hasExactlyOneEquals("12+23=35"));
        assertFalse(EquationControls.hasExactlyOneEquals("12+23 35"));
        assertFalse(EquationControls.hasExactlyOneEquals("12+24=36=48-12"));
        //EquationControls.hasExactlyOneEquals method tests ENDS

        String eq = Generate.GenerateEquation();
        assertTrue(EquationControls.hasExactlyOneEquals(eq));//Generate.GenerateEquation TEST
    }
    @Test
    public void hasValidAmountOfOperators(){
        //EquationControls.hasValidAmountOfOperators method tests
        assertFalse(EquationControls.hasValidAmountOfOperators("1225=1225"));
        assertTrue(EquationControls.hasValidAmountOfOperators("144+3=147"));
        //EquationControls.hasValidAmountOfOperators method tests ENDS

        String eq = Generate.GenerateEquation();
        assertTrue(EquationControls.hasValidAmountOfOperators(eq));//Generate.GenerateEquation TEST
    }
    @Test
    public void isOperationResultIsTrue(){
        //EquationControls.isEquationResultIsTrue method tests
        assertTrue(EquationControls.isEquationResultIsTrue("12+25=37"));
        assertTrue(EquationControls.isEquationResultIsTrue("12+25*1=37"));
        assertFalse(EquationControls.isEquationResultIsTrue("12+11=22"));
        assertFalse(EquationControls.isEquationResultIsTrue("12+4/2=11"));
        //EquationControls.isEquationResultIsTrue method tests ENDS

        String eq = Generate.GenerateEquation();
        assertTrue(EquationControls.isEquationResultIsTrue(eq));//Generate.GenerateEquation TEST
    }
    @Test
    public void isValidLength(){
        //EquationControls.isEquationLengthValid tests
        assertTrue(EquationControls.isEquationLengthValid("1+40=41"));//Equation.length = 7
        assertTrue(EquationControls.isEquationLengthValid("14+44=55"));// Equation.length = 8
        assertTrue(EquationControls.isEquationLengthValid("144-45=99"));// Equation.length = 9

        assertFalse(EquationControls.isEquationLengthValid("9+4=13"));//Equation.length = 6
        assertFalse(EquationControls.isEquationLengthValid("140-12=128"));//Equation.length=9
        //EquationControls.isEquationLengthValid tests ENDS

        String eq = Generate.GenerateEquation();
        assertTrue(EquationControls.isEquationLengthValid(eq));//Generate.GenerateEquation TEST
    }

}