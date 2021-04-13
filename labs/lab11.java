import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<String> s = new HashSet<String>();
    s.add("hello");
    s.add("bye");
    s.addAll(s);
    Set<String> t = new TreeSet<String>();
    t.add("123");
    s.addAll(t);
    System.out.println(s.containsAll(t));
    System.out.println(t.containsAll(s));
  }
}