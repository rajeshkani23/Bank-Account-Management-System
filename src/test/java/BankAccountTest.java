package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Balance should be 1500 after depositing 500");
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance(), "Balance should be 600 after withdrawing 400");
    }

    @Test
    public void testTransfer() {
        BankAccount account1 = new BankAccount("123456", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("654321", "Jane Doe", 500.0);
        account1.transfer(account2, 200.0);
        assertEquals(800.0, account1.getBalance(), "Balance of account1 should be 800 after transferring 200 to account2");
        assertEquals(700.0, account2.getBalance(), "Balance of account2 should be 700 after receiving 200 from account1");
    }

    @Test
    public void testInsufficientFunds() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(1500.0);
        });
        assertEquals("Insufficent funds", exception.getMessage());
    }

    @Test
    public void testNegativeDeposit() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100.0);
        });
        assertEquals("Deposit must be positive", exception.getMessage());
    }

    @Test
    public void testNegativeWithdraw() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-100.0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    @Test
    public void testTransferToNullAccount() {
        BankAccount account = new BankAccount("123456", "John Doe", 1000.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.transfer(null, 100.0);
        });
        assertEquals("Target Amount cannot be null", exception.getMessage());
    }
}
