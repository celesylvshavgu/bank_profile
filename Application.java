import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Bank myBank = new Bank();
        Scanner input = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Welcome to the Banking System");

        while (!quit) {
            System.out.println("\n1. Create Profile\n2. Login\n3. Exit");
            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter username: "); String u = input.nextLine();
                System.out.print("Enter password: "); String p = input.nextLine();
                System.out.print("Initial deposit: "); double d = input.nextDouble();
                myBank.addUser(new Profile(u, p, d));
                System.out.println("Profile created successfully!");
            } 
            else if (choice == 2) {
                System.out.print("Username: "); String u = input.nextLine();
                System.out.print("Password: "); String p = input.nextLine();
                Profile current = myBank.login(u, p);
                
                if (current != null) {
                    userMenu(current, input);
                } else {
                    System.out.println("Invalid login credentials.");
                }
            } 
            else {
                System.out.println("Thank you for using our bank. Goodbye!");
                quit = true;
            }
        }
    }

    private static void userMenu(Profile user, Scanner input) {
        boolean logout = false;
        while (!logout) {
            System.out.println("\n--- User Menu ---\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Logout");
            int c = input.nextInt();
            if (c == 1) System.out.println(user.toString());
            else if (c == 2) {
                System.out.print("Amount: "); user.deposit(input.nextDouble());
            } 
            else if (c == 3) {
                System.out.print("Amount: "); user.withdraw(input.nextDouble());
            } 
            else logout = true;
        }
    }
}