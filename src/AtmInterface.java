
import java.util.*;
class BankAccount
{
    String name;
    String userName;
    String password;

    String accountNo;
    float balance = 1000000f;
    int transactions = 0;
    String transactionHistory = "";
    Scanner sc = new Scanner(System.in);
    public void register()
    {
        System.out.print("\nEnter your name: ");
        name = sc.next();

        System.out.print("\nEnter your username: ");
        userName = sc.next();

        System.out.print("\nEnter your account number: ");
        accountNo = sc.next();

        System.out.print("\nEnter your password: ");
        password = sc.next();

        System.out.print("\nRegistration Completed Successfully, please kindly Login ");
    }

    public boolean login() {
        boolean isLogin = false;

        while (!isLogin) {
            System.out.print("\nEnter your username: ");
            String Username = sc.next();

            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter your password: ");
                    String Password = sc.next();

                    if (Password.equals(password)) {
                        System.out.print("\nLogin Successfully!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else
            {
                System.out.println("\nUsername not found!");
            }
        }
        return isLogin;
    }
    public void withdraw()
    {
        System.out.print("\nEnter amount to withdraw: ");
        float amount = sc.nextFloat();

        try {
            if (balance >= amount)
            {
                transactions++;
                balance -= amount;

                System.out.println("\nWithdraw Successfully "+amount);
                String str = amount + " Rs withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance!");
            }
        } catch (Exception e) {

        }
    }
    public void deposit()
    {
        System.out.print("\nEnter amount to deposit: ");
        float amount = sc.nextFloat();

        try
        {
            if (amount <= 1000000f)
            {
                transactions++;
                balance += amount;

                System.out.println("\nSuccessfully Deposited "+amount);
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.println("Sorry limit is 1000000.00 Rs ");
            }
        }
        catch (Exception e)
        {

        }
    }
    public void transfer()
    {
        System.out.print("\nEnter receipent's Name: ");
        String receipent = sc.next();

        System.out.print("\nEnter amount to transfer: ");
        float amount = sc.nextFloat();

        try
        {
            if (balance >= amount)
            {
                if (amount <= 50000f)
                {
                    transactions++;
                    balance -= amount;

                    System.out.println("\nSuccessfully transferred to " + receipent);
                    String str = amount + " Rs transferred to " + receipent + " \n";

                    transactionHistory = transactionHistory.concat(str);
                } else
                {
                    System.out.println("\nSorry Limit is 50000.00 Rs");
                }
            } else
            {
                System.out.println("\nInsufficient Balance!");
            }
        }
        catch (Exception e)
        {

        }
    }
    public void checkBalance()
    {
        System.out.println("\n" + balance + " Rs");
    }

    public void transHistory()
    {
        if (transactions == 0)
        {
            System.out.println("\nEmpty");
        } else
        {
            System.out.println("\n" + transactionHistory);
        }
    }
}
public class AtmInterface
{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;

        while (!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1)
                {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e)
            {
                System.out.println("Enter the integer only");
                flag = false;
            }
        };
        return input;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("--WELCOME--");
        System.out.println("1.Register \n2.Exit");
        System.out.print("Enter your choice");

        int choice = takeIntegerInput(2);

        if (choice == 1)
        {
            BankAccount b = new BankAccount();
            b.register();

            while(true)
            {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter your choice");
                int ch = takeIntegerInput(2);

                if (ch == 1)
                {
                    if (b.login())
                    {
                        System.out.println("--WELCOME BACK "+ b.name +"--");
                        boolean isFinished = false;

                        while(!isFinished) {
                            System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Quit");
                            System.out.print("\nEnter your choice: ");
                            int c = takeIntegerInput(6);

                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;

                                case 2:
                                    b.deposit();
                                    break;

                                case 3:
                                    b.transfer();
                                    break;

                                case 4:
                                    b.checkBalance();
                                    break;

                                case 5:
                                    b.transHistory();
                                    break;

                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        System.exit(0);
    }
}
