/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankproject;




import java.util.Scanner;

public class BankProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = null;

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Bank");
            System.out.println("2. Add Account");
            System.out.println("3. Perform Transaction");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Deposit Money");
            System.out.println("6. List Transactions for Account");
            System.out.println("7. Check Account Balance");
            System.out.println("8. List Bank Accounts");
            System.out.println("9. Check Bank Transaction Fee Amount");
            System.out.println("10. Check Bank Transfer Amount");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter bank name:");
                    String bankName = scanner.nextLine();
                    System.out.println("Enter flat fee:");
                    double flatFee = scanner.nextDouble();
                    System.out.println("Enter percent fee:");
                    double percentFee = scanner.nextDouble();
                    bank = new Bank(bankName, flatFee, percentFee);
                    System.out.println("Bank created successfully!");
                    break;

                case 2:
                    if (bank == null) {
                        System.out.println("Create a bank first!");
                    } else {
                        System.out.println("Enter account name:");
                        String accountName = scanner.nextLine();
                        System.out.println("Enter initial balance:");
                        double initialBalance = scanner.nextDouble();
                        Account account = new Account(accountName, initialBalance);
                        bank.addAccount(account);
                        System.out.println("Account added successfully!");
                    }
                    break;

case 3:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        // Display list of available accounts
        System.out.println("Available accounts:");
        for (Account account : bank.getAccounts()) {
            System.out.println("ID: " + account.getAccountId() + ", Name: " + account.getUserName()+", balance: " + account.getBalance());
        }

        System.out.println("Enter originating account ID:");
        int fromAccountId = scanner.nextInt();

        // Validate the originating account ID
        boolean isValidOriginatingAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == fromAccountId) {
                isValidOriginatingAccount = true;
                break;
            }
        }
        if (!isValidOriginatingAccount) {
            System.out.println("Invalid originating account ID!");
            break;
        }

        System.out.println("Enter resulting account ID:");
        int toAccountId = scanner.nextInt();

        // Validate the resulting account ID
        boolean isValidResultingAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == toAccountId) {
                isValidResultingAccount = true;
                break;
            }
        }
        if (!isValidResultingAccount) {
            System.out.println("Invalid resulting account ID!");
            break;
        }

        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        System.out.println("Enter transaction reason:");
        scanner.nextLine(); // Consume newline
        String reason = scanner.nextLine();
        Transaction transaction = new Transaction(amount, fromAccountId, toAccountId, reason);
        try {
            bank.performTransaction(transaction);
            System.out.println("Transaction successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
    break;


              case 4:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        // Display list of available accounts
        System.out.println("Available accounts:");
        for (Account account : bank.getAccounts()) {
            System.out.println("ID: " + account.getAccountId() + ", Name: " + account.getUserName());
        }

        System.out.println("Enter account ID for withdrawal:");
        int accountId = scanner.nextInt();

        // Validate the account ID
        boolean isValidAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == accountId) {
                isValidAccount = true;
                break;
            }
        }
        if (!isValidAccount) {
            System.out.println("Invalid account ID!");
            break;
        }

        System.out.println("Enter withdrawal amount:");
        double withdrawAmount = scanner.nextDouble();
        try {
            Account account = bank.getAccountById(accountId);
            account.withdraw(withdrawAmount);
            System.out.println("Withdrawal successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }
    break;

case 5:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        // Display list of available accounts
        System.out.println("Available accounts:");
        for (Account account : bank.getAccounts()) {
            System.out.println("ID: " + account.getAccountId() + ", Name: " + account.getUserName());
        }

        System.out.println("Enter account ID for deposit:");
        int accountId = scanner.nextInt();

        // Validate the account ID
        boolean isValidAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == accountId) {
                isValidAccount = true;
                break;
            }
        }
        if (!isValidAccount) {
            System.out.println("Invalid account ID!");
            break;
        }

        System.out.println("Enter deposit amount:");
        double depositAmount = scanner.nextDouble();
        try {
            Account account = bank.getAccountById(accountId);
            account.deposit(depositAmount);
            System.out.println("Deposit successful!");
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }
    break;

case 6:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        System.out.println("Enter account ID to list transactions:");
        int accountId = scanner.nextInt();

        // Validate the account ID
        boolean isValidAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == accountId) {
                isValidAccount = true;
                System.out.println("Transactions for Account ID " + accountId + ":");
                for (Transaction transaction : account.getTransactions()) {
                    System.out.println(transaction.getTransactionReason() + " - Amount: $" + transaction.getAmount() + ", Transaction Fee: $" + transaction.getTransactionFee());
                }
                break;
            }
        }
        if (!isValidAccount) {
            System.out.println("Invalid account ID!");
        }
    }
    break;

case 7:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        System.out.println("Enter account ID to check balance:");
        int accountId = scanner.nextInt();

        // Validate the account ID
        boolean isValidAccount = false;
        for (Account account : bank.getAccounts()) {
            if (account.getAccountId() == accountId) {
                isValidAccount = true;
                System.out.println("Balance for Account ID " + accountId + ": $" + account.getBalance());
                break;
            }
        }
        if (!isValidAccount) {
            System.out.println("Invalid account ID!");
        }
    }
    break;

case 8:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        System.out.println("Bank Accounts:");
        for (Account account : bank.getAccounts()) {
            System.out.println("ID: " + account.getAccountId() + ", Name: " + account.getUserName() + ", Balance: $" + account.getBalance());
        }
    }
    break;

case 9:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        System.out.println("Bank Total Transaction Fee Amount: $" + bank.getTotalTransactionFeeAmount());
    }
    break;

case 10:
    if (bank == null) {
        System.out.println("Create a bank first!");
    } else {
        System.out.println("Bank Total Transfer Amount: $" + bank.getTotalTransferAmount());
    }
    break;

                case 0:
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
