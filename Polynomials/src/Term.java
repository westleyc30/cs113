public class Term {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(String s) {
        boolean isPositive;
        int xLocation = -1;
        int carrotLocation = -1;
        String coefficientString;
        String exponentString;
        int coefficientInt;
        int exponentInt;
        // check if positive
        if (s.charAt(0) == '+') {
            isPositive = true;
        } else {
            isPositive = false;
        }
        // find location of 'x' and '^' if they exist
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                xLocation = i;
            }
            if (s.charAt(i) == '^') {
                carrotLocation = i;
            }
        }

        // no x
        if (xLocation == -1) {
            coefficientInt = Integer.parseInt(s);
            exponentInt = 0;
        } else if (s.length() == 2 && xLocation != -1 && carrotLocation == -1 && isPositive) { // +x
            coefficientInt = 1;
            exponentInt = 1;
        } else if (s.length() == 2 && xLocation != -1 && carrotLocation == -1 && !isPositive) { // -x
            coefficientInt = -1;
            exponentInt = 1;
        } else if (s.length() > 2 && xLocation != -1 && carrotLocation == -1) { // 33x no exponent has coefficient
            coefficientString = s.substring(0, xLocation);
            coefficientInt = Integer.parseInt(coefficientString);
            exponentInt = 1;
        } else if (s.length() > 2 && xLocation == 1) { // +x^3434 or -x^34 coefficient is 1 or negative 1 and ther is an exponent
            if (isPositive) {
                coefficientInt = 1;
            } else {
                coefficientInt = -1;
            }
            exponentString = s.substring(carrotLocation + 1, s.length());
            exponentInt = Integer.parseInt(exponentString);
        } else { // all other cases 3334x^32
            coefficientString = s.substring(0, xLocation);
            exponentString = s.substring(carrotLocation + 1, s.length());
            coefficientInt = Integer.parseInt(coefficientString);
            exponentInt = Integer.parseInt(exponentString);
        }

        this.setAll(coefficientInt, exponentInt);
    }
    public Term() {
        setAll(1,1);
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


    public String toString() {


        // exponent = 0 & coefficient  > 0
        if (exponent == 0 && coefficient > 0) {
            return "+" + coefficient;
        }
        // exponent = 0 && coefficient < 0
        if (exponent == 0 && coefficient < 0) {
            return "" +  coefficient;
        }
        // exponent = 1 & coefficient == 1
        if (exponent == 1 && coefficient == 1) {
            return "+x";
        }
        // exponent = 1 & coefficient == -1
        if (exponent == 1 && coefficient == -1) {
            return "-x";
        }

        //exponent == 1 & coefficient > 0
        if (exponent == 1 && coefficient > 0) {
            return "+" + coefficient + "x";
        }

        //exponent == 1 & coefficient < 0
        if (exponent == 1 && coefficient < 0) {
            return  coefficient + "x";
        }

        // exponent > 1 && coefficient = 1
        if (exponent > 1 && coefficient == 1 || exponent < 1 && coefficient == 1) {
            return "+x^" + exponent;
        }

        if (exponent > 1 && coefficient == -1 || exponent < 1 && coefficient == -1) {
            return "-x^" + exponent;
        }

        if (coefficient > 1) {
            return "+" + coefficient + "x^" + exponent;
        }

        if (coefficient < -1) {
            return coefficient + "x^" + exponent;
        }



        return "";
    }

    public Object clone() {
        return new Term(this);
    }

    public int compareTo(Object o) {
        if( o == null ) {
            throw new IllegalArgumentException("null data");
        } else if (o.getClass() != this.getClass()) {
            throw new ClassCastException("Parameter must be of 'Term' class");
        }
        Term otherTerm = (Term) o;
        return this.exponent - otherTerm.exponent;
    }

    public boolean equals(Object o) {
        if( o == null ) {
            throw new IllegalArgumentException("null data");
        } else if (o.getClass() != this.getClass()) {
            throw new ClassCastException("Parameter must be of 'Term' class");
        }
        Term otherTerm = (Term) o;
        return this.getExponent() == otherTerm.getExponent() && this.getCoefficient() == otherTerm.getCoefficient();
    }
}
