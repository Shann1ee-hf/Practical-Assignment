public class SavingsAccount extends Account {

    private final double minimumBalance;
    private static final double MONTHLY_INTEREST_RATE = 0.005; // 0.5% per month

    public SavingsAccount(String accountNumber, double initialBalance, double minimumBalance) {
        super(accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("  [" + accountNumber + "] Withdrawal rejected: amount must be positive.");
            return;
        }
        if (balance - amount < minimumBalance) {
            System.out.printf("  [%s] SAVINGS withdrawal of %.2f REJECTED: balance would fall below the minimum of %.2f.%n",
                    accountNumber, amount, minimumBalance);
            return;
        }
        balance -= amount;
        System.out.printf("  [%s] SAVINGS withdrew %.2f. New balance: %.2f%n", accountNumber, amount, balance);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        System.out.printf("  [%s] SAVINGS month-end: interest of %.2f added. New balance: %.2f%n",
                accountNumber, interest, balance);
    }
}