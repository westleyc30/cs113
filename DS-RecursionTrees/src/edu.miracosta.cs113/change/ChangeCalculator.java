package edu.miracosta.cs113.change;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {

    private final static int[] COINS = {25, 10, 5, 1};

    public static HashSet<String> resultSet = new HashSet<>();

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static int calculateChange(int cents) {
        resultSet.clear();
        calculateChange(cents, 0, 0, 0, cents);
        return resultSet.size();
    }

// number of coins left
    public static void calculateChange(int cents, int q, int d, int n, int p) {

        if(q * COINS[0] + d * COINS[1] + n * COINS[2] + p > cents) {
            return;
        }
        resultSet.add("[" +q + ", " + d + ", " + n + ", " + p + "]");

        if (p >= COINS[2]) {
            calculateChange(cents, q, d, n + 1, p - 5);
        }
        if (p >= COINS[1]) {
            calculateChange(cents, q, d + 1, n, p - 10);
        }
        if (p >= COINS[0]) {
            calculateChange(cents, q + 1, d, n, p - 25);
        }


    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) {
        calculateChange(cents);
        String directory = "/Users/westley/Documents/School/cs113/DS-RecursionTrees/src/edu.miracosta.cs113/change/CoinCombinations.txt";
        StringBuilder comboString = new StringBuilder();

        for (String s : resultSet) {
            comboString.append(s).append("\n");
        }

        File file = new File(directory);
        try {
            FileWriter writer = new FileWriter(directory);
            writer.write(comboString.toString());
            writer.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());

        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.

    }



} // End of class ChangeCalculator