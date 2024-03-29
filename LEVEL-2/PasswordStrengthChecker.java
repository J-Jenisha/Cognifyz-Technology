import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Password Strength Checker!");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9 ]*");

        int strength = calculateStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);

        displayStrength(strength);

        scanner.close();
    }

    public static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase, boolean hasDigit, boolean hasSpecialChar) {
        int strength = 0;

        // Add points based on password criteria
        if (length >= 8) {
            strength += 2;
        } else if (length >= 6) {
            strength += 1;
        }

        if (hasUppercase) {
            strength += 2;
        }
        if (hasLowercase) {
            strength += 2;
        }
        if (hasDigit) {
            strength += 2;
        }
        if (hasSpecialChar) {
            strength += 2;
        }

        return strength;
    }

    public static void displayStrength(int strength) {
        if (strength >= 10) {
            System.out.println("Password strength: Very Strong");
        } else if (strength >= 8) {
            System.out.println("Password strength: Strong");
        } else if (strength >= 6) {
            System.out.println("Password strength: Moderate");
        } else if (strength >= 4) {
            System.out.println("Password strength: Weak");
        } else {
            System.out.println("Password strength: Very Weak");
        }
    }
}
