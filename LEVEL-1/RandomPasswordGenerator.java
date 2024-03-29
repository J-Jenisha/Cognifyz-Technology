import java.util.Scanner;
import java.util.Random;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Random Password Generator!");

        
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("yes");

        
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        
        StringBuilder validChars = new StringBuilder();
        if (includeNumbers) {
            validChars.append(numbers);
        }
        if (includeLowercase) {
            validChars.append(lowercaseLetters);
        }
        if (includeUppercase) {
            validChars.append(uppercaseLetters);
        }
        if (includeSpecialChars) {
            validChars.append(specialChars);
        }

        
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

       
        System.out.println("Your generated password is: " + password.toString());

        scanner.close();
    }
}
