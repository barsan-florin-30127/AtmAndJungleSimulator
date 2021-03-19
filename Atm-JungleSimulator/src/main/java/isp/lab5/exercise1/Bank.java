package isp.lab5.exercise1;


public class Bank {
    private Account[] accounts;

    public Bank(Account[] accounts) {
        this.accounts = accounts;
    }

    /**
     * Method that returns an account from the bank searched by it's cardId.
     * @param cardId
     * @return account which has the searched cardId
     */
    public Account getAccountByCardId(String cardId) {
        Account transitionAccount = null;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getCard().getCardId() == cardId) {
                transitionAccount = accounts[i];
            }
        }
        return transitionAccount;
    }

    public String executeTransaction(Transaction t) {
        return t.execute();
    }
}
