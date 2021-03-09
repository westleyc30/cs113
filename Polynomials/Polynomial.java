
import java.util.LinkedList;

public class Polynomial {
    private LinkedList<Term> termList = new LinkedList<>();

    public Polynomial() {

    }

    /**
     * Copy constructor
     * 
     * @param original Polynomial
     */
    public Polynomial(Polynomial original) {
        if (original == null) {
            System.out.println("VALIDATION ERROR: copy constructor");
            System.exit(0);
        }
        // this.termList = new LinkedList<Term>(original.getList());
        for (int i = 0; i < original.getNumTerms(); i++) {
            Term originalTerm = original.getTerm(i);
            Term newTerm = new Term(originalTerm.getCoefficient(), originalTerm.getExponent());
            termList.add(newTerm);
        }
    }

    public LinkedList<Term> getList() {
        return this.termList;
    }

    /**
     * counts number of terms in termList
     * 
     * @return number of terms in TermList
     */
    public int getNumTerms() {
        return termList.size();
    }

    /**
     * Adds Term to termList
     * 
     * @param t Term
     */
    public void addTerm(Term t) {
        boolean termAdded = false;
        if (this.getNumTerms() == 0) {
            termList.add(t);
            termAdded = true;
        } else {
            for (int i = 0; i < this.getNumTerms(); i++) {
                if (t.compareTo(this.getTerm(i)) > 0 && !termAdded) {
                    termList.add(i, t);
                    termAdded = true;
                } else if (t.compareTo(this.getTerm(i)) == 0) {
                    if (this.getTerm(i).getCoefficient() + t.getCoefficient() == 0) {
                        termList.remove(i);
                    } else {
                        this.combineTerms(this.getTerm(i), t);
                    }
                    termAdded = true;
                }
            }
        }
        if (!termAdded) {
            termList.add(t);
        }
        // for (int i = 0; i < this.getNumTerms();)
    }

    /**
     * Gets term at i
     * 
     * @param i
     * @return Term
     */
    public Term getTerm(int i) {
        //
        return termList.get(i);
    }

    /**
     * clears termList
     */
    public void clear() {
        //

        termList.clear();
    }

    /**
     * 
     * @param p Polynomial
     */
    public void add(Polynomial p) {
        for (int i = 0; i < p.getNumTerms(); i++) {
            this.addTerm(p.getTerm(i));
        }
    }

    @Override
    public String toString() {
        String positive = " + ";
        String negative = " - ";
        String output = "0";
        for (int i = 0; i < this.getNumTerms(); i++) {
            if (i == 0 && this.getTerm(i).getCoefficient() > 0) {
                output = (this.getTerm(i).toString().substring(1));
            } else if (i == 0 && this.getTerm(i).getCoefficient() < 0) {
                output = "- " + this.getTerm(i).toString().substring(1);
            } else {
                output += this.getTerm(i).toString();
            }
            // else if (this.getTerm(i).getCoefficient() > 0) {
            // output += positive + this.getTerm(i).toString().substring(1);
            // } else if (this.getTerm(i).getCoefficient() < 0) {
            // output += negative + this.getTerm(i).toString().substring(1);
            // }
        }
        return output;
    }

    // OTHER METHODS
    public boolean checkForEqualExponent(Term term1, Term term2) {
        return term1.getExponent() == term2.getExponent();
    }

    public void combineTerms(Term term1, Term term2) {
        term1.setCoefficient(term1.getCoefficient() + term2.getCoefficient());
    }

}
