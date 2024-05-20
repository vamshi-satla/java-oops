class Account {
    private String accountNumber;
    public double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Savings account withdrawal not allowed.");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Exceeds overdraft limit!");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 2.5);
        savingsAccount.deposit(2000);
        savingsAccount.calculateInterest();
        System.out.println("Savings account balance: " + savingsAccount.getBalance());

        CurrentAccount currentAccount = new CurrentAccount("CA456", 500);
        currentAccount.deposit(20000);
        currentAccount.withdraw(8000);
        System.out.println("Current account balance: " + currentAccount.getBalance());
    }
}