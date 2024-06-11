package Main;

import Main.BankAccount;

public class BankAccount_App {
    public static void main(String[] args) {
        BankAccount account1=new BankAccount("238976","Rajesh",20000);
        BankAccount account2=new BankAccount("2390976","deepan",500000);
        BankAccount account3=new BankAccount("2382376","rajan",10000);

        System.out.println("Intial Balances:");
        System.out.println(account1.getAccountHoldername()+ " : "+account1.getBalance());
        System.out.println(account2.getAccountHoldername()+ " : "+account2.getBalance());
        System.out.println(account3.getAccountHoldername()+ " : "+account3.getBalance());

        account1.deposit(4000);
        account2.withdraw(100000);

        System.out.println("\nBalances After Transcations:");
        System.out.println(account1.getAccountHoldername()+ " : "+account1.getBalance());
        System.out.println(account2.getAccountHoldername()+ " : "+account2.getBalance());

        account1.transfer(account2,4000);

        System.out.println("\nBalances after transfer");

        System.out.println(account1.getAccountHoldername()+ " : "+account1.getBalance());
        System.out.println(account2.getAccountHoldername()+ " : "+account2.getBalance());






    }
}
