import java.util.Scanner;


class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

   
    public void deposit(double amount) {
        balance += amount;
        System.out.println(" Deposit successful!");
    }

    
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

   
    public double getBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;
    private Scanner sc;

    
    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    
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

   
    private void checkBalance() {
        System.out.println(" Current Balance: ₹" + account.getBalance());
    }

    
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


public class atmmachine {
    public static void main(String[] args) {

        
        BankAccount userAccount = new BankAccount(5000);

        
        ATM atm = new ATM(userAccount);

    
        atm.showMenu();
    }
}
