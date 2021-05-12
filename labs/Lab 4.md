# Lab 4
1.
```java
class Main {

	public static void main(String\[\] args) {

		ArrayList<String\> stringList \= new ArrayList<String\>();

		stringList.add("grumpy");
		stringList.add("grumpy");
		stringList.add("grumpy");
		stringList.add("not grumps");
		System.out.println(stringList);
		replace(stringList, "grumpy", "not grumpy");
		System.out.println(stringList);
		delete(stringList, "not grumpy");
		System.out.println(stringList);

	}

	public static void replace(ArrayList<String\> aList, String oldItem, String newItem) {

		int location \= aList.indexOf(oldItem);
		while (location != \-1) {
			aList.set(location, newItem);
			location \= aList.indexOf(oldItem);
		}

	}

	public static void delete(ArrayList<String\> aList, String target) {

		int location \= aList.indexOf(target);
		aList.remove(location);

	}

}
```

2.
```java
  /** 
  Add an entry to theDirectory or change an existing entry.
  @param aName The name of the person being added or changed
  @param newNumber The new number to be assigned
  @return The old number, or if a new entry, null
  */
  public String addOrChangeEntry(String aName, String newNumber) {
	  int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
	  DirectoryEntry dE;
	  int oldNumber;
	  if (index != -1) {
		  dE = theDirectory.get(index);
		  oldNumber = dE.getNumber();
		  dE.setNumber(newNumber);
		  return oldNumber;
	  } else {
		  theDirectory.add(new DirectoryEntry(aName, newNumber));
		  return null;
	  }
  }
  
  /**
  Remove an entry
  @param aName The name of the person being removed
  @return Then entry removed, or null if there is no entry for aName
  */
  public DirectoryEntry removeEntry(String aName) {
	  int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
	  DirectoryEntry dE;
	  if (index != -1) {
		  dE = theDirectory.get(index);
		  theDirectory.remove(index);
		  return dE
	  } else {
		  return null;
	  }
  }
```