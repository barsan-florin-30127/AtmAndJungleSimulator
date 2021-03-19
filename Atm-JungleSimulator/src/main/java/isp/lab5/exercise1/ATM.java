package isp.lab5.exercise1;

/**
 * Class that acts as an ATM and allows the user to interacts with it's account from bank using his card.
 */
public class ATM {
    private Bank bank;
    private Card card;

    public ATM(Bank bank) {
        this.bank = bank;
        this.card = null;
    }

    public Card getCard() {
        return card;
    }

    /**
     * Method that calls out the ChangePin transaction if the old pin matches the pin which the bank account currently has
     * If the condition is true ,the old pin will be changed to the new pin parameter
     * @param oldPin -old pin parameter
     * @param newPin -new pin parameter
     */
    public void changePin(String oldPin, String newPin) {
        if (this.card != null) {
            System.out.println("Trying to change the pin.");
            Transaction t = new ChangePin(oldPin, newPin);
            t.setAccount(bank.getAccountByCardId(this.card.getCardId()));
            bank.executeTransaction(t);
            System.out.println("Pin changed succesfully. Your new pin is:" + card.getPin());
        } else {
            System.out.println("Please introduce a card.");
        }
    }

    /**
     * Method that calls out the WithdrawMoney transaction if there is enough money in the bank to be withdrawn.
     * @param amount -amount of money that user wants to withdraw
     */
    public void withdraw(double amount) {
        if (this.card != null) {
            if (bank.getAccountByCardId(card.getCardId()).getBalance() >= amount) {
                Transaction t = new WithdrawMoney(amount);
                t.setAccount(bank.getAccountByCardId(this.card.getCardId()));
                bank.executeTransaction(t);
                System.out.println("The amount of " + amount + " has been withdrawn from your account.");
            }
        } else {
            System.out.println("Please introduce a card.");

        }
    }

    /**
     * Method that display the amount of money an account has, calling the method CheckMoney from Transaction abstract class
     */
    public void checkMoney() {
        if (this.card != null) {
            Transaction t = new CheckMoney();
            t.setAccount(bank.getAccountByCardId(this.card.getCardId()));
            bank.executeTransaction(t);
        } else {
            System.out.println("Please introduce a card.");
        }
    }

    /**
     * Method that introduces a card in the ATM is the introduced pin matches the card's pin.
     * @param card - the card user wants to introduce in the atm
     * @param pin - pin that need to match the card's pin
     */
    public void insertCard(Card card, String pin) {
        String cardId = card.getCardId();
        if (bank.getAccountByCardId(cardId).getCard().getPin() == pin) {
            this.card = card;
            System.out.println(this.card.toString() + "has been introduced in the ATM.");
        } else {
            System.out.println("Failed to insert card " + card.toString() + " .Incorrect pin.");
        }


    }

    /**
     * Method that remove the card that currently is in the atm.
     */
    public void removeCard() {
        if (this.card != null) {
            System.out.println(this.card.toString() + "was removed from the ATM.");
            this.card = null;
        } else {
            System.out.println("Please introduce a card first then use remove method.");
        }
    }

}
