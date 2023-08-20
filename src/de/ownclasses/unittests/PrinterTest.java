package de.ownclasses.unittests;

import org.junit.Test;

import de.ownclasses.Printer;


public class PrinterTest {
    
    @Test
    public void printerIntTest() {
        Printer print = new Printer();
        int[] intArray = {1,2,3,4,5,6,7,8,9,0};
        print.printArray(intArray);
    }

    @Test
    public void printerDoubleTest() {
        Printer print = new Printer();
        double[] doubleArray = {1.0d, 2.0d, 3.0d};
        print.printArray(doubleArray);
    }

    @Test
    public void printerStringTest() {
        Printer print = new Printer();
        String[] stringArray = {"Das", "ist", "ein", "String-Array!"};
        print.printArray(stringArray);
    }
}
