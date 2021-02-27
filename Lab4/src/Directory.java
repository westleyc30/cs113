import java.util.ArrayList;

public class Directory {
    private ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

    public Directory() {

    }

    public int getNumEntries() {
        return theDirectory.size();
    }

    public DirectoryEntry getEntry(int i) {
        return theDirectory.get(i);
    }

    /**
     * Add an entry to theDirectory or change an existing entry
     * @param aName The name of the person being added or changed
     * @param newNumber The new number to be assigned
     * @return The old number, or if a new entry, null
     */
    public String addOrChangeEntry(String aName, String newNumber) {
        String oldNumber;
        int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
        if (index != -1) {
            oldNumber = theDirectory.get(index).getNumber();
            theDirectory.get(index).setNumber(newNumber);
        } else {
            DirectoryEntry newEntry = new DirectoryEntry(aName, newNumber);
            theDirectory.add(newEntry);
            oldNumber = null;
        }

        return oldNumber;
    }

    /**
     * Remove an entry
     * @param aName name of the person being removed
     * @return the entry removed, or null if there is no entry for aName
     */
    public DirectoryEntry removeEntry(String aName) {
        DirectoryEntry removedEntry;
        int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
        if (index != -1) {
            removedEntry = theDirectory.get(index);
            theDirectory.remove(removedEntry);
        } else {
            removedEntry = null;
        }

        return removedEntry;
    }
}
