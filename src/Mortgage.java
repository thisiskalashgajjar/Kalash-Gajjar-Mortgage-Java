abstract class Mortgage implements MortgageConstants {
    public int mortgageNumber;
    public String customerName;
    public double mortgageAmount;
    public double interestRate;
    public int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        setMortgageAmount(mortgageAmount);
        setTerm(term);
        setInterestRate();
    }

    public void setMortgageAmount(double mortgageAmount) {
        if (mortgageAmount > MAX_AMOUNT) {
            this.mortgageAmount = MAX_AMOUNT;
        } else {
            this.mortgageAmount = mortgageAmount;
        }
    }

    public void setTerm(int term) {
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) {
            this.term = term;
        } else {
            this.term = SHORT_TERM;
        }
    }

    public void setInterestRate() {
        if (term == SHORT_TERM) {
            interestRate = 0.04;
        } else if (term == MEDIUM_TERM) {
            interestRate = 0.05;
        } else {
            interestRate = 0.06;
        }
    }

    public double calculateMonthlyPayment() {
        int months = term * 12;
        double monthlyInterestRate = interestRate / 12;
        return mortgageAmount * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -months)));
    }

    public String getMortgageInfo() {
        return String.format(
                "Mortgage Number: %d\nCustomer Name: %s\nMortgage Amount: $%.2f\nInterest Rate: %.2f%%\nTerm: %d years",
                mortgageNumber, customerName, mortgageAmount, interestRate * 100, term);
    }
}