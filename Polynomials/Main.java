import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Polynomial poly1 = new Polynomial();
        Polynomial poly2 = new Polynomial();
        Polynomial[] polynomialArray = { poly1, poly2 };
        // mainMenu(polynomialArray);
        MainMenu.runMenu(polynomialArray);
    }

    // public static void mainMenu(Polynomial[] p) {
    // Scanner keyboard = new Scanner(System.in);
    // System.out.println("MAIN MENU");
    // int choice;

    // displayMainMenuOptions(p);
    // choice = KeyIn.inInt("Select Menu Option: ");
    // while (choice != 0) {
    // choice = keyboard.nextInt();
    // switch (choice) {
    // case 1:
    // polynomialMenu(p[0]);
    // displayMainMenuOptions(p);
    // break;
    // case 2:
    // polynomialMenu(p[1]);
    // displayMainMenuOptions(p);
    // break;
    // case 3:
    // displayMainMenuOptions(p);
    // break;
    // case 0:
    // break;
    // default:
    // System.out.println("Please choose one of the options listed");
    // displayMainMenuOptions(p);
    // break;
    // }
    // }
    // }

    // public static void polynomialMenu(Polynomial p) {
    // //
    // Scanner keyboard = new Scanner(System.in);
    // int choice = -1;
    // do {
    // System.out.println("Polynomial 1: " + p.toString());
    // try {
    // choice = keyboard.nextInt(); // could throw exception here and skip rest of
    // code
    // } catch (InputMismatchException ime) {
    // // What goes here??
    // System.out.println("\nInvalid choice, please pick a valid option from the
    // menu.\n");
    // continue;
    // }

    // keyboard.nextLine();
    // System.out.println();

    // switch (choice) {
    // case 1:
    // // add Term

    // String termString;
    // System.out.println("enter a term using the format '3x^4'");

    // try {
    // Term newTerm;
    // termString = keyboard.next();
    // newTerm = new Term(termString);
    // System.out.println(newTerm.toString());
    // p.addTerm(newTerm);
    // } catch (Exception e) {
    // // TODO: handle exception
    // System.out.println(e.getMessage());
    // }
    // break;
    // case 2:
    // // clear Polynomial
    // break;
    // case 0:
    // keyboard.close();
    // break;
    // default:
    // System.out.println("Please choose one of the options listed");
    // break;
    // }
    // } while (choice != 0);
    // }

    // public static void displayMainMenuOptions(Polynomial[] p) {
    // System.out.println("Polynomial 1: " + p[0].toString());
    // System.out.println("Polynomial 2: " + p[1].toString());

    // System.out.println("1) Edit Polynomial 1");
    // System.out.println("2) Edit Polynomial 2");
    // System.out.println("3) Display combined polynomials");
    // System.out.println("0) Exit program");
    // }
}
