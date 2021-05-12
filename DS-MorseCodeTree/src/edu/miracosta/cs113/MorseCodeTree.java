package edu.miracosta.cs113;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {
    protected Node<Character> root = new Node<>(null);
    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.

    public MorseCodeTree() {
        readMorseCodeTree(root);
    }



    public void readMorseCodeTree(Node<Character> root) {
        Node<Character> currentRoot = root;
//        System.out.println("We are in the root " + root.data);
        File file = new File("/Users/westley/Documents/School/cs113/DS-MorseCodeTree/src/edu/miracosta/cs113/key.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] keyValue = sc.nextLine().split(" ");
                Character letter = keyValue[0].charAt(0);
                String morse = keyValue[1];
//                System.out.println(letter);
//                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < morse.length(); i++) {
                    if (morse.charAt(i) == '*' && i < morse.length() - 1) {
//                        sb.append("*");
                        currentRoot = currentRoot.right;
                    }
                    if (morse.charAt(i) == '-' && i < morse.length() - 1) {
//                        sb.append("-");
                        currentRoot = currentRoot.left;
                    }
                    if (i == morse.length() - 1) {
                        if (morse.charAt(i) == '*') {
                            currentRoot.left = new Node<>(letter);
//                            sb.append("*");
//                            System.out.println(sb + ": " + currentRoot.left.data);
                        }
                        if (morse.charAt(i) == '-') {
                            currentRoot.right = new Node<>(letter);
//                            sb.append("-");
//                            System.out.println(sb + ": " + currentRoot.right.data);
                        }
                    }
                }
                currentRoot = root;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        }

    }

    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public String translateFromMorseCode(String morseCode) {
        String[] codeArray = morseCode.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String code:
             codeArray) {
            if (code.length() > 4) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) != '*' && code.charAt(i) != '-') {
                    throw new IllegalArgumentException();
                }
            }
        }
        for (String s : codeArray) {
            sb.append(decode(s));
        }
        return sb.toString();
    }

    private String decode(String code) {

        Node<Character> currentRoot = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '*' && i < code.length() - 1) {
                currentRoot = currentRoot.right;
            }
            if (code.charAt(i) == '-' && i < code.length() - 1) {
                currentRoot = currentRoot.left;
            }
            if (i == code.length() - 1) {
                if (code.charAt(i) == '*') {
                    sb.append(currentRoot.left.data);
                }
                if (code.charAt(i) == '-') {
                    sb.append(currentRoot.right.data);
                }
            }
        }

        return sb.toString();
    }

} // End of class MorseCodeTree