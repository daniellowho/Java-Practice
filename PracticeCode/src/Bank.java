class Bank{
    private double balance;

    // Constructor to initialize the balance
    public Bank(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Error: Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            } else {
                System.out.println("Error: Insufficient funds. Your balance is $" + balance);
            }
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    // Method to check the current balance
    public double getBalance() {
        return balance;
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        // Example usage
        Bank myAccount = new Bank(500);
        myAccount.displayAccountInfo();

        myAccount.deposit(200);
        myAccount.withdraw(100);
        myAccount.withdraw(700); // Attempting to withdraw more than balance

        myAccount.displayAccountInfo();
    }
}
