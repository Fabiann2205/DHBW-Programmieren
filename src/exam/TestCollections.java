package exam;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(String.valueOf(i));
            linkedList.add(String.valueOf(i));
            hashMap.put(String.valueOf(i), i + 1);
            hashSet.add(String.valueOf(i));
        }
        hashSet.add("1"); // wird nicht geaddet wegen HasSet (keine Duplicates)
        System.out.println("HashSet: ");
        System.out.println(hashSet);


        Iterator<String> it = arrayList.iterator();

        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
            if (s.equals("2") || s.equals("5")) {
                it.remove();
            }
            System.out.println(arrayList);
        }


    }
}
