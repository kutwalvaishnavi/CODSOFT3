import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}


class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("0. Exit");
    }

    public void performTransaction(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount > 0) {
                    userAccount.withdraw(withdrawalAmount);
                } else {
                    System.out.println("Invalid amount. Withdrawal failed.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                } else {
                    System.out.println("Invalid amount. Deposit failed.");
                }
                break;
            case 3:
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;
            case 0:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(1000);

        
        ATM atm = new ATM(userAccount);

        
        Scanner scanner = new Scanner(System.in);

        
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            
            atm.performTransaction(option, scanner);
        }
    }
}