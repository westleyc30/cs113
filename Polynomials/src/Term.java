

public class Term {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term() {

    }

    public Term(Term original) {
        if (original == null) {
            System.out.println("VALIDATION ERROR: copy constructor");
            System.exit(0);
        }
        boolean setSuccessful = setAll(original.getCoefficient(), original.getExponent());
        if (!setSuccessful) {
            System.out.println("VALIDATION ERROR: copy constructor");
            System.exit(0);
        }
    }

    public boolean setCoefficient(int coefficient) {
        boolean isValid;
        isValid = coefficient == (int) coefficient;
        if (isValid) {
            this.coefficient = coefficient;
            return isValid;
        }
        return isValid;
    }
    public boolean setExponent(int exponent) {
        boolean isValid;
        isValid = exponent == (int) exponent;
        if (isValid) {
            this.exponent = exponent;
            return isValid;
        }
        return isValid;
    }

    public boolean setAll(int coefficient, int exponent) {
        return setCoefficient(coefficient) && setExponent(exponent);
    }

    public int getExponent() {
        return exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }
    public void sumOfCoefficients(int otherCoefficient) {
        this.coefficient = coefficient + otherCoefficient;
    }


    public String ToString() {
        String sign;
        if (coefficient > 0) {
            sign = "+";
        }
        // coefficient = 0
        // coefficient = 1 or -1 and exponent != 0
        // exponent = 0
        // exponent = 1
        return "";
    }


}
