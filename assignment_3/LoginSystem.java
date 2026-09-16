import java.util.Scanner;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

public class LoginSystem {

    static final String CORRECT_USERNAME = "admin";
    static final String CORRECT_PASSWORD = "1234";

    static int failedAttempts = 0;
    static final int MAX_ATTEMPTS = 3;

    static void login(String username, String password)
            throws InvalidUsernameException,
                   InvalidPasswordException,
                   AccountLockedException {

        // Check if account is already locked
        if (failedAttempts >= MAX_ATTEMPTS) {
            throw new AccountLockedException(
                "Account is locked."
            );
        }

        // Check username
        if (!username.equals(CORRECT_USERNAME)) {
            failedAttempts++;

            throw new InvalidUsernameException(
                "Invalid username."
            );
        }

        // Check password
        if (!password.equals(CORRECT_PASSWORD)) {
            failedAttempts++;

            throw new InvalidPasswordException(
                "Invalid password."
            );
        }

        // Login successful
        System.out.println("Login successful!");
        failedAttempts = 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            while (failedAttempts < MAX_ATTEMPTS) {

                System.out.print("Enter username: ");
                String username = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                try {

                    login(username, password);
                    break;

                } catch (InvalidUsernameException e) {

                    System.out.println("Error: " + e.getMessage());

                } catch (InvalidPasswordException e) {

                    System.out.println("Error: " + e.getMessage());
                }
            }

            // If maximum attempts reached
            if (failedAttempts >= MAX_ATTEMPTS) {

                throw new AccountLockedException(
                    "Maximum attempts exceeded. Account locked."
                );
            }

        } catch (AccountLockedException e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("Login process completed.");
            sc.close();
        }
    }
}
