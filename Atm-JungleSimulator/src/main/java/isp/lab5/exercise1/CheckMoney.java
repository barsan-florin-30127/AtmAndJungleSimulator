package isp.lab5.exercise1;

class CheckMoney extends Transaction {

    public String execute() {
        System.out.println("Your account balance is:" + super.getAccount().getBalance());
        return "Your account balance is:" + super.getAccount().getBalance();
    }
}
