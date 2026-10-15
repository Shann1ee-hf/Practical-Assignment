import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {

        // One list, two different account types -> polymorphism
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-1001", 1000.00, 100.00));
        accounts.add(new SavingsAccount("SAV-1002", 200.00, 100.00));
        accounts.add(new CurrentAccount("CUR-2001", 300.00, 500.00));
        accounts.add(new CurrentAccount("CUR-2002", 50.00, 500.00));

        System.out.println("Opening balances");
        for (Account a : accounts) {
            System.out.printf("  [%s] %.2f%n", a.getAccountNumber(), a.getBalance());
        }

        System.out.println("\nDeposit test (shared Account behaviour)");
        accounts.getFirst().deposit(500.00);
        accounts.getFirst().deposit(-20.00);   // rejected

        System.out.println("\nStep 1: withdraw 250 from every account");
        for (Account a : accounts) {
            a.withdraw(250.00);            // no casting - correct override runs
        }

        System.out.println("\nStep 2: withdraw 400 from every account");
        for (Account a : accounts) {
            a.withdraw(400.00);
        }

        System.out.println("\nEnd of month processing");
        for (Account a : accounts) {
            a.endOfMonth();                // interest vs fee, decided by object type
        }

        System.out.println("\nClosing balances");
        for (Account a : accounts) {
            System.out.printf("  [%s] %.2f%n", a.getAccountNumber(), a.getBalance());
        }
    }
}
