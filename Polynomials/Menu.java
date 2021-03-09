import java.util.Scanner;

public abstract class Menu {

  // Abstract Methods
  public abstract void runMenu(Polynomial[] p);

  public abstract void printHeader();

  public abstract void printMenu(Polynomial[] p);

  // Actual Methods
  private static int getInput(int numberOfChoices) {
    Scanner kb = new Scanner(System.in);
    int choice = -1;
    while (choice < 0 || choice > numberOfChoices) {
      try {
        System.out.print("\nEnter Choice: ");
        choice = Integer.parseInt(kb.next());
        if (choice > numberOfChoices) {
          System.out.println("Please enter a valid number");
        }
      } catch (Exception e) {
        System.out.println("Invalid choice please try again");
      }

    }
    return choice;
  }
}
