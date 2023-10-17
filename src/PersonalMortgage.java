class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
    }

    @Override
    public void setInterestRate() {
        interestRate = 0.02 + 0.01 * super.interestRate;
    }
}