package de.dhbwka.java.exams.darts;

// Teilaufgabe b
public class Board {
    private Field[] fields = new Field[63];

    public Board() {
        fields[0] = new Field("x", 0 ,false);
        fields[1] = new Field("Single Bull", 25 ,false);
        fields[2] = new Field("BULL", 50 ,true);

        //Standardzahlenwerte
        for(int i=3; i<23; i++) {
            fields[i] = new Field(String.valueOf(i-2), (i-2), false);
        }
        //Doppelzahlenwerte
        for(int i=23; i<43; i++) {
            fields[i] = new Field(("D" + String.valueOf(i-22)), (i-22)*2, true);
        }
        //Triplezahlenwerte
        for(int i=43; i<63; i++) {
            fields[i] = new Field(("T" + String.valueOf(i-42)), (i-42)*3, true);
        }
    }

    public Field parseField(String label) {
        for(int i = 0; i<fields.length; i++) {
            if (this.fields[i].getLabel().equals(label)) {
                return fields[i];
            }
        }
        return null;
    }
    // public static void main(String[] args) {
    //      Board test = new Board();
    //      System.out.println("hallo");
    //      Field tester = test.parseField("20");
    //      System.out.println("hallo");
    // }
}
