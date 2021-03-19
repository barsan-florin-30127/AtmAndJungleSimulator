package isp.lab5.exercise1;

class WithdrawMoney extends Transaction {
    private double amount;

    public WithdrawMoney(double amount) {
        this.amount = amount;
    }

    public String execute() {
        getAccount().setBalance(getAccount().getBalance() - this.amount);
        return "Amount" + this.amount + " has been taken from the account.";
    }
}
