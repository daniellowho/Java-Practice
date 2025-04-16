// Interface with transaction methods
interface Transaction {
    void deposit(int deposit);
    void withdraw(int withdraw);
}

// Implementing the Transaction interface
class BankAccount implements Transaction {
    final int minBalance = 1000;
    int currentBalance = 20000;

    @Override
    public void deposit(int deposit) {
        currentBalance += deposit;
        System.out.println("Amount Deposited: " + deposit);
        System.out.println("Current Balance: " + currentBalance);
    }

    @Override
    public void withdraw(int withdraw) {
        if (currentBalance - withdraw < minBalance) {
            System.out.println("Low Balance. Please add funds");
        } else {
            currentBalance -= withdraw;
            System.out.println("Amount Withdrawn: " + withdraw);
            System.out.println("Balance Remaining: " + currentBalance);
        }
    }
}

// Main class
public class case2 {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.deposit(1000);  // Depositing money
        b.withdraw(14000); // Withdrawing money
    }
}
