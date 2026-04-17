public class Profile {
    private String username;
    private String password;
    private double balance;

    // Constructor to initialize the user
    public Profile(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: €" + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: €" + balance);
            return true;
        }
        System.out.println("Insufficient funds or invalid amount.");
        return false;
    }

    @Override
    public String toString() {
        return "Account: " + username + " | Current Balance: €" + balance;
    }
}