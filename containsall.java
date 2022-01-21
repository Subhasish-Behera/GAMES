import java.util.*;

class SetDemo {
    public static void main(String args[])
    {

        // Creating an empty set
        Set<String>
                set = new HashSet<String>();

        // Use add() method to
        // add elements in the set
        set.add("Geeks");
        set.add("for");
        set.add("Geeks");
        set.add("10");
        set.add("20");

        // prints the set
        System.out.println("Set 1: "
                + set);

        // Creating another empty set
        Set<String>
                set2 = new HashSet<String>();

        // Use add() method to
        // add elements in the set
        set2.add("Geeks");
        set2.add("for");
        //set2.add("Geeks");
        //set2.add("10");
        set2.add("20");

        // prints the set
        System.out.println("Set 2: "
                + set2);

        // Check if the set
        // contains same elements
        System.out.println("\nDoes set 1 contains set 2?: "
                + set.containsAll(set2));
    }
}