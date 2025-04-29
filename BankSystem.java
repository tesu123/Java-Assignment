import java.util.ArrayList;

// Parent class BankAccount
abstract class BankAccount {
    protected String accountNo;
    protected double balance;
    protected double interestRate;

    public BankAccount(String accountNo, double balance, double interestRate) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public abstract void displayAccountInfo();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNo, double balance, double interestRate) {
        super(accountNo, balance, interestRate);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Savings Account No: " + accountNo);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Interest Amount: $" + calculateInterest());
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNo, double balance, double interestRate, double overdraftLimit) {
        super(accountNo, balance, interestRate);
        this.overdraftLimit = overdraftLimit;
    }

    public void displayOverdraftAmount() {
        if (balance < 0) {
            System.out.println("Overdraft Amount: $" + Math.abs(balance));
        } else {
            System.out.println("No overdraft used.");
        }
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Current Account No: " + accountNo);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
        displayOverdraftAmount();
    }
}

// Bank class to manage accounts
class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public boolean verifyAccount(String accountNo) {
        for (BankAccount account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(BankAccount account) {
        if (!verifyAccount(account.getAccountNo())) {
            accounts.add(account);
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account already exists.");
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the bank.");
            return;
        }

        System.out.println("\nAll Accounts in the Bank:");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            System.out.println("----------------------");
        }
    }
}

// Main class to demonstrate the functionality
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create some accounts
        SavingsAccount savings1 = new SavingsAccount("SA001", 5000, 3.5);
        CurrentAccount current1 = new CurrentAccount("CA001", 2000, 1.0, 1000);
        CurrentAccount current2 = new CurrentAccount("CA002", -500, 1.5, 2000);

        // Add accounts to the bank
        bank.addAccount(savings1);
        bank.addAccount(current1);
        bank.addAccount(current2);

        // Try to add duplicate account
        bank.addAccount(new SavingsAccount("SA001", 10000, 4.0));

        // Verify account existence
        System.out.println("\nAccount SA001 exists: " + bank.verifyAccount("SA001"));
        System.out.println("Account SA002 exists: " + bank.verifyAccount("SA002"));

        // Display all accounts
        bank.displayAllAccounts();
    }
}