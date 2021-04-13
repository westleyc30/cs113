package lab11;

import java.util.HashSet;
import java.util.Set;

public class programming2 {
  public static void main(String[] args) {
    String[] listA = { "Ann", "Sally", "Jill", "Sally" };
    String[] listB = { "Bob", "Bill", "Ann", "Jill" };
    Set<String> setA = new HashSet<String>();
    Set<String> setACopy = new HashSet<String>();
    Set<String> setB = new HashSet<String>();

    // load sets from arrays
    for (int i = 0; i < listA.length; i++) {
      setA.add(listA[i]);
      setACopy.add(listA[i]);
    }

    for (int i = 0; i < listB.length; i++) {
      setB.add(listB[i]);
    }
    System.out.println("The 2 sets are: \n" + setA + '\n' + setB);

    // Display the union and intersection
    setA.addAll(setB); // set union
    setACopy.retainAll(setB); // set intersection
    System.out.println("Items in the set union are: " + setA);
    System.out.println("Items in set intersection are: " + setACopy);
  }
}
