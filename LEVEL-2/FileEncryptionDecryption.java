import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to File Encryption/Decryption Program!");
        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        char choice = scanner.nextLine().toUpperCase().charAt(0);

        if (choice == 'E') {
            encryptFile(scanner);
        } else if (choice == 'D') {
            decryptFile(scanner);
        } else {
            System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    public static void encryptFile(Scanner scanner) {
        try {
            System.out.print("Enter the path of the file to encrypt: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the path for the encrypted file: ");
            String encryptedFilePath = scanner.nextLine();

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(encryptedFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int character;
            while ((character = bufferedReader.read()) != -1) {
               
                char encryptedChar = (char) (character + 1);
                bufferedWriter.write(encryptedChar);
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(Scanner scanner) {
        try {
            System.out.print("Enter the path of the file to decrypt: ");
            String filePath = scanner.nextLine();

            System.out.print("Enter the path for the decrypted file: ");
            String decryptedFilePath = scanner.nextLine();

            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(decryptedFilePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int character;
            while ((character = bufferedReader.read()) != -1) {
               
                char decryptedChar = (char) (character - 1);
                bufferedWriter.write(decryptedChar);
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
