public class Term {
    private int coefficient;
    private int exponent;

    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public Term(String s) {
        int xLocation = -1;
        int carrotLocation = -1;
        boolean isPositive;
        if (s.charAt(0) == '+') {
            isPositive = true;
        } else {
            isPositive = false;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'x') {
                xLocation = i;
            }

            if (s.charAt(i) == '^') {
                carrotLocation = i;
            }
        }

        int coefficientInt;
        int exponentInt;
        if (xLocation == -1) {
            coefficientInt = Integer.parseInt(s);
            exponentInt = 0;
        } else if (s.length() == 2 && xLocation != -1 && carrotLocation == -1 && isPositive) {
            coefficientInt = 1;
            exponentInt = 1;
        } else if (s.length() == 2 && xLocation != -1 && carrotLocation == -1 && !isPositive) {
            coefficientInt = -1;
            exponentInt = 1;
        } else {
            String coefficientString;
            if (s.length() > 2 && xLocation != -1 && carrotLocation == -1) {
                coefficientString = s.substring(0, xLocation);
                coefficientInt = Integer.parseInt(coefficientString);
                exponentInt = 1;
            } else {
                String exponentString;
                if (s.length() > 2 && xLocation == 1) {
                    if (isPositive) {
                        coefficientInt = 1;
                    } else {
                        coefficientInt = -1;
                    }

                    exponentString = s.substring(carrotLocation + 1, s.length());
                    exponentInt = Integer.parseInt(exponentString);
                } else {
                    coefficientString = s.substring(0, xLocation);
                    exponentString = s.substring(carrotLocation + 1, s.length());
                    coefficientInt = Integer.parseInt(coefficientString);
                    exponentInt = Integer.parseInt(exponentString);
                }
            }
        }

        this.setAll(coefficientInt, exponentInt);
    }

    public Term() {
        this.setAll(1, 1);
    }

    public Term(Term original) {
        if (original == null) {
            System.out.println("VALIDATION ERROR: copy constructor");
            System.exit(0);
        }

        boolean setSuccessful = this.setAll(original.getCoefficient(), original.getExponent());
        if (!setSuccessful) {
            System.out.println("VALIDATION ERROR: copy constructor");
            System.exit(0);
        }

    }

    public boolean setCoefficient(int coefficient) {
        boolean isValid = coefficient == coefficient;
        if (isValid) {
            this.coefficient = coefficient;
            return isValid;
        } else {
            return isValid;
        }
    }

    public boolean setExponent(int exponent) {
        boolean isValid = exponent == exponent;
        if (isValid) {
            this.exponent = exponent;
            return isValid;
        } else {
            return isValid;
        }
    }

    public boolean setAll(int coefficient, int exponent) {
        return this.setCoefficient(coefficient) && this.setExponent(exponent);
    }

    public int getExponent() {
        return this.exponent;
    }

    public int getCoefficient() {
        return this.coefficient;
    }

    public void sumOfCoefficients(int otherCoefficient) {
        this.coefficient += otherCoefficient;
    }

    public String toString() {
        if (this.exponent == 0 && this.coefficient > 0) {
            return "+" + this.coefficient;
        } else if (this.exponent == 0 && this.coefficient < 0) {
            return "" + this.coefficient;
        } else if (this.exponent == 1 && this.coefficient == 1) {
            return "+x";
        } else if (this.exponent == 1 && this.coefficient == -1) {
            return "-x";
        } else if (this.exponent == 1 && this.coefficient > 0) {
            return "+" + this.coefficient + "x";
        } else if (this.exponent == 1 && this.coefficient < 0) {
            return this.coefficient + "x";
        } else if ((this.exponent <= 1 || this.coefficient != 1) && (this.exponent >= 1 || this.coefficient != 1)) {
            if (this.exponent > 1 && this.coefficient == -1 || this.exponent < 1 && this.coefficient == -1) {
                return "-x^" + this.exponent;
            } else if (this.coefficient > 1) {
                return "+" + this.coefficient + "x^" + this.exponent;
            } else {
                return this.coefficient < -1 ? this.coefficient + "x^" + this.exponent : "";
            }
        } else {
            return "+x^" + this.exponent;
        }
    }

    public Object clone() {
        return new Term(this);
    }

    public int compareTo(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null data");
        } else if (o.getClass() != this.getClass()) {
            throw new ClassCastException("Parameter must be of 'Term' class");
        } else {
            Term otherTerm = (Term) o;
            return this.exponent - otherTerm.exponent;
        }
    }

    public boolean equals(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null data");
        } else if (o.getClass() != this.getClass()) {
            throw new ClassCastException("Parameter must be of 'Term' class");
        } else {
            Term otherTerm = (Term) o;
            return this.getExponent() == otherTerm.getExponent() && this.getCoefficient() == otherTerm.getCoefficient();
        }
    }
}
