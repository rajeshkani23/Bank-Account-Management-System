package Main;

public class BankAccount {
    private String AccountNumber;
    private String AccountHoldername;
    private  double balance;

    public BankAccount(String accountNumber, String accountHoldername, double balance) {
        AccountNumber = accountNumber;
        AccountHoldername = accountHoldername;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public String getAccountHoldername() {
        return AccountHoldername;
    }

    public double getBalance() {
        return balance;
    }
    public  void deposit(double Amount){
        if (Amount > 0){
            balance += Amount ;
            }
        else {
            throw  new IllegalArgumentException("Deposit must be positive");
        }
    }
    public  void withdraw(double Amount){
        if (Amount > 0){
            if (balance >= Amount){
                balance -= Amount;
            }
            else {
                throw  new IllegalArgumentException("Insufficent funds");
            }
        }
        else {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
    }
    public  void transfer(BankAccount targetAccount,double Amount){
        if (targetAccount == null){
            throw new IllegalArgumentException("Target Amount cannot be null");
        }
        this.withdraw(Amount);
        targetAccount.deposit(Amount);
    }
}
