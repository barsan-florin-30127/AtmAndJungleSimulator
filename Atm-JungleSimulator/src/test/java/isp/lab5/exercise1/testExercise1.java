package isp.lab5.exercise1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//By testing methods from the ATM we are testing ExecuteTransaction method from bank too,atm using this method to run.
public class testExercise1 {
    @Test
    public void testChangePin() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);
        atm.insertCard(card[0], "1234");
        atm.changePin("1234", "0000");
        assertEquals("0000", card[0].getPin());
    }

    @Test
    public void testWithdraw() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);
        atm.insertCard(card[0], "1234");
        atm.withdraw(1);
        assertEquals(randBalance - 1, bank.getAccountByCardId("TestCard").getBalance(), 0.01);
    }

    @Test
    public void testInsertCard() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);
        assertEquals(null, atm.getCard());
        atm.insertCard(card[0], "1234");
        assertEquals(card[0], atm.getCard());
    }

    @Test
    public void testRemoveCard() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);
        atm.insertCard(card[0], "1234");
        assertEquals(card[0], atm.getCard());
        atm.removeCard();
        assertEquals(null, atm.getCard());
    }

    @Test
    public void testGetAccountById() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        assertEquals(account[0], bank.getAccountByCardId("TestCard"));
    }

    @Test
    public void testCheckMoney() {
        Card[] card = new Card[1];
        card[0] = new Card("TestCard", "1234");
        Account[] account = new Account[1];
        double randBalance = (Math.random() * 1000);
        account[0] = new Account(card[0], "TestOwner", randBalance);
        Bank bank = new Bank(account);
        ATM atm = new ATM(bank);
        atm.insertCard(card[0], "1234");
        Transaction t = new CheckMoney();
        t.setAccount(bank.getAccountByCardId(card[0].getCardId()));
        bank.executeTransaction(t);
        assertEquals("Your account balance is:" + randBalance, bank.executeTransaction(t));

    }
}
