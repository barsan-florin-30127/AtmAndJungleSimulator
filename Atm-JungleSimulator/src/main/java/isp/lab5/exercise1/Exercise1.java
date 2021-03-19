package isp.lab5.exercise1;


public class Exercise1 {

    public static void main(String[] args) {
        Card[] card = new Card[10];
        String basicCardId = "cardId";
        card[0] = new Card("", "");
        for (int i = 1; i < 10; i++) {
            card[i] = new Card(basicCardId + i, "pin");
        }
        Account[] accounts = new Account[10];
        accounts[0] = new Account(card[0], "", 0);
        String basicOwner = "Owner";
        double basicBalance = 100;
        for (int i = 1; i < accounts.length; i++) {
            accounts[i] = new Account(card[i], basicOwner + i, basicBalance * i + i);
        }
        Bank bank = new Bank(accounts);
        ATM atm = new ATM(bank);
        atm.insertCard(card[1], "pin");

        atm.checkMoney();
        atm.withdraw(20);
        atm.changePin("pin", "pinnou");
        atm.checkMoney();
        System.out.println("Card1 pin is:" + card[1].getPin());
        atm.removeCard();
        atm.insertCard(card[2], "pin");
        atm.checkMoney();
        atm.removeCard();
        atm.insertCard(card[4], "pinincorect");
        atm.checkMoney();

    }
}
