import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

class BankAccount {

    private int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Deposit amount must be greater than zero."
            );
        }

        balance += amount;
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount)
            throws InvalidAmountException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance."
            );
        }

        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    public double getBalance() {
        return balance;
    }
}

public class BankingApplication {

    static BankAccount findAccount(int accountNumber)
            throws AccountNotFoundException {

        if (accountNumber != 1001) {
            throw new AccountNotFoundException(
                "Account not found."
            );
        }

        return new BankAccount(1001, 5000);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter account number: ");
            int accountNumber = sc.nextInt();

            BankAccount account = findAccount(accountNumber);

            account.deposit(1000);

            account.withdraw(2000);

            System.out.println(
                "Current Balance = " + account.getBalance()
            );

        } catch (AccountNotFoundException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {

            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}