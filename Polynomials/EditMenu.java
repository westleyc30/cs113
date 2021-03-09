import java.util.Scanner;

public class EditMenu {
  public static void runMenu(Polynomial p) {
    boolean exit = false;
    printHeader(p);

    printMenu();
    while (!exit) {
      System.out.print("Select an option");
      int choice = getInput(3);
      switch (choice) {
      case 0:
        exit = true;
        System.out.println("Returning to menu");
        break;
      case 1:
        System.out.println("Add a Term to polynomial:");
        System.out.print("enter the coefficient: ");
        int coefficient = getTermInput();
        System.out.print("enter the exponent: ");
        int exponent = getTermInput();
        p.addTerm(createTerm(coefficient, exponent));

        System.out.println("Polynomial is now: " + p.toString());

        printMenu();
        break;
      case 2:
        p.clear();
        System.out.println("Clearing polynomial");
        System.out.println("Polynomial is now: " + p.toString());
        printMenu();
        break;
      default:
        break;
      }
    }
  }

  private static void printMenu() {
    System.out.println("\n1) Add a Term to Polynomial");
    System.out.println("2) Clear terms from Polynomial");
    System.out.println("0) Return to root menu");
  }

  private static Term createTerm(int c, int e) {
    Term t = new Term(c, e);
    System.out.println("Adding " + t.toString() + " to polynomial");
    return t;
  }

  private static void printHeader(Polynomial p) {
    System.out.println("*********************************");
    System.out.println("|                               |");
    System.out.println("|      Clear, add or Edit       |");
    System.out.println(p.toString());
    System.out.println("*********************************");
  }

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

  private static int getTermInput() {
    Scanner kb = new Scanner(System.in);
    int choice = 1;
    boolean termAccepted = false;
    while (!termAccepted) {
      try {
        // System.out.print("\nEnter Term: ");
        choice = Integer.parseInt(kb.next());
        termAccepted = true;
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    return choice;
  }
}
