/** This class implements some of the methods of the Java
 * ArrayList class
 */

public class KWArrayLilst<E> {
// Data Fields
/** The default initioal capacity */
private static final int INITIAL_CAPACITY = 10;

/** The underlying data array */
private E[] theData;

/** The current size */
private int size = 0;

/** The current capacity */
private int capacity = 0;

public KWArrayLilst() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
        }
        }