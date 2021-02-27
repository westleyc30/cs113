import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private static final String[] names = { "Steve", "Alice", "I don't know", "Man behind the counter", "pizza hut"};
    private static final String[] numbers = {"777-334-1233", "332-423-1094", "333-333-3333", "999-888-7777", "111-111-1111"};



    @Test
    void addOrChangeEntry() {
        Directory dir = new Directory();
        String changedNumber = "123-456-7890";

        // build directory
        for (int i = 0; i < names.length; i++) {
            dir.addOrChangeEntry(names[i], numbers[i]);
        }
        // test added entries
        for (int i = 0; i < dir.getNumEntries(); i++) {
//            System.out.println(dir.getEntry(i).getName() + ": " + dir.getEntry(i).getNumber());
            assertEquals(names[i], dir.getEntry(i).getName());
        }
        // Change entry test

        dir.addOrChangeEntry(names[0], changedNumber);
        assertEquals(changedNumber, dir.getEntry(0).getNumber());
    }

    @Test
    void removeEntry() {
        Directory dir = new Directory();

        // build directory
        for (int i = 0; i < names.length; i++) {
            dir.addOrChangeEntry(names[i], numbers[i]);
        }
        DirectoryEntry removedEntry = dir.removeEntry(names[0]);
        assertEquals(names[0], removedEntry.getName() );
        assertEquals(numbers[0], removedEntry.getNumber());
    }
}