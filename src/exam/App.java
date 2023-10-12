package exam;

import de.ownclasses.Printer;
import de.ownclasses.Sorter;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        double[] test = {1.0d, 5.0d, 2.0d, -2.0d};
        Sorter sorting = new Sorter(test);
        Printer print = new Printer();
        sorting.insertSort();
        print.printArray(sorting.getVector());
    }
}
