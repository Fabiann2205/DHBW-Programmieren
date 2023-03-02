package de.dhbwka.java.exercise.methods;

public class Quicksort {
    public static void main(String[] args) {
        int[] test = {4,2,5,7,9,10,1};
        Quicksort tester = new Quicksort(test);
        tester.sort(); 
        System.out.println(tester.toString());
    }

    private int[] elements;
    public Quicksort(int[] array) {
        this.elements = array;
    }
    public void sort() {
        quicksort(this.elements, 0, this.elements.length - 1);
      }
    
      private void quicksort(int[] elements, int left, int right) {
        // End of recursion reached?
        if (left >= right) {
          return;
        }
    
        int pivotPos = partition(elements, left, right);
        quicksort(elements, left, pivotPos - 1);
        quicksort(elements, pivotPos + 1, right);
      }
    
      public int partition(int[] elements, int left, int right) {
        int pivot = elements[right];
    
        int i = left;
        int j = right - 1;
        while (i < j) {
          // Find the first element >= pivot
          while (elements[i] < pivot) {
            i++;
          }
    
          // Find the last element < pivot
          while (j > left && elements[j] >= pivot) {
            j--;
          }
    
          // If the greater element is left of the lesser element, switch them
          if (i < j) {
            int iValue = elements[i], jValue= elements[j];
            elements[i] = jValue;
            elements[j] = iValue;
            i++;
            j--;
          }
        }
    
        // i == j means we haven't checked this index yet.
        // Move i right if necessary so that i marks the start of the right array.
        if (i == j && elements[i] < pivot) {
          i++;
        }
    
        // Move pivot element to its final position
        if (elements[i] != pivot) {
            int iiValue = elements[i], rightValue= elements[right];
            elements[i] = rightValue;
            elements[right] = iiValue;
        }
        return i;
      }

    @Override
    public String toString() {
        String ausgabe = "Sortiert: ";
        for(int i=0;i<this.elements.length; i++) {
            ausgabe += elements[i] + ", ";
            
        }
        ausgabe = ausgabe.substring(0, ausgabe.length()-2);
        return ausgabe;
    }

    
}
