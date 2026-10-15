public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Concrete method shared by all account types
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("  [" + accountNumber + "] Deposit rejected: amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("  [%s] Deposited %.2f. New balance: %.2f%n", accountNumber, amount, balance);
    }

    // Concrete method shared by all account types
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Subclasses MUST provide their own behaviour
    public abstract void withdraw(double amount);

    public abstract void endOfMonth();
}