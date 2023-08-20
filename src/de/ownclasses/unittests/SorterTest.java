package de.ownclasses.unittests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import de.ownclasses.Sorter;

public class SorterTest {

    @Test
    public void sorterTester() {
        int[] inter = { 1, 4, 2, 5, 10, 3 };
        double[] doubler = { 1.0d, 4.0d, 2.0d, 5.0d, 10.0d, 3.0d };
        Sorter sort = new Sorter(inter);

        double[] gotarray = sort.getVector();

        int[] intArray = new int[gotarray.length];
        for (int i = 0; i < intArray.length; ++i) {
            intArray[i] = (int) gotarray[i];
        }

        assertArrayEquals(inter, intArray);

        sort.setVector(doubler);
        sort.bubblesort();
        gotarray = sort.getVector();

        intArray = new int[gotarray.length];
        for (int i = 0; i < intArray.length; ++i){
            intArray[i] = (int) gotarray[i];
        }

        int[] sortedArrayToCompare = {1,2,3,4,5,10};
        assertArrayEquals(intArray, sortedArrayToCompare);
    }
}
