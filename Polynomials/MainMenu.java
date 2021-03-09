import java.util.Scanner;

class MainMenu {

  public static void runMenu(Polynomial[] p) {
    boolean exit = false;
    printHeader();
    while (!exit) {
      printMenu(p);
      int userChoice = getInput(3);
      System.out.println(userChoice);
      switch (userChoice) {
      case 0:
        exit = true;
        System.out.println("Exiting program");
        break;
      case 1:
        System.out.println("Choice 1");
        EditMenu.runMenu(p[0]);
        break;
      case 2:
        System.out.println("Choice 2");
        EditMenu.runMenu(p[1]);
        break;
      case 3:
        getCombinedPolynomials(p);
        break;
      default:
        System.out.println("Unknown error... Mysterious");
        break;
      }
    }
  }

  private static void printHeader() {
    System.out.println("*********************************");
    System.out.println("|                               |");
    System.out.println("|        Polynomial Menun       |");
    System.out.println("|                               |");
    System.out.println("*********************************");
  }

  private static void printMenu(Polynomial[] p) {
    System.out.println("Polynomial 1: " + p[0].toString());
    System.out.println("Polynomial 2: " + p[1].toString());
    System.out.println("\n1) Edit Polynomial 1");
    System.out.println("2) Edit Polynomial 2");
    System.out.println("3) Display combined polynomials");
    System.out.println("0) Exit program");
  }

  private static void getCombinedPolynomials(Polynomial[] p) {
    Polynomial copy = new Polynomial(p[0]);
    copy.add(p[1]);

    System.out.println("\n*********************************\n");
    System.out.println("When we combine, " + p[0].toString() + " and " + p[1]);
    System.out.println("we get: " + copy.toString());
    System.out.println("\n*********************************\n");

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
}
