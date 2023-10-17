class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
    }

    @Override
    public void setInterestRate() {
        interestRate = 0.01 + 0.01 * super.interestRate;
    }
}