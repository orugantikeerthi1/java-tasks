import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance += amount;
        System.out.println(" Deposit successful!");
    }

    // Withdraw Method
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(" Withdrawal successful!");
            return true;
        } else {
            System.out.println(" Insufficient balance!");
            return false;
        }
    }

    // Check Balance Method
    public double getBalance() {
        return balance;
    }
}

// ATM Class
class ATM {
    private BankAccount account;
    private Scanner sc;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    // Display ATM Menu
    public void showMenu() {
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    System.out.println(" Thank you for using the ATM!");
                    break;

                default:
                    System.out.println(" Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    // Check Balance
    private void checkBalance() {
        System.out.println(" Current Balance: ₹" + account.getBalance());
    }

    // Deposit Money
    private void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = sc.nextDouble();

        if (amount > 0) {
            account.deposit(amount);
            System.out.println(" Updated Balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    // Withdraw Money
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = sc.nextDouble();

        if (amount > 0) {
            account.withdraw(amount);
            System.out.println(" Updated Balance: ₹" + account.getBalance());
        } else {
            System.out.println(" Invalid withdrawal amount!");
        }
    }
}

// Main Class
public class atmmachine {
    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount userAccount = new BankAccount(5000);

        // Create ATM object
        ATM atm = new ATM(userAccount);

        // Start ATM system
        atm.showMenu();
    }
}