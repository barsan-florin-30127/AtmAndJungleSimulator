package isp.lab5.exercise1;

class ChangePin extends Transaction {
    private String newPin;
    private String oldPin;

    public ChangePin(String oldPin, String newPin) {
        this.oldPin = oldPin;
        this.newPin = newPin;
    }

    public String execute() {
        if (this.oldPin == getAccount().getCard().getPin()) {
            super.getAccount().getCard().setPin(this.newPin);
            return "The old  pin " + this.oldPin + " has been changed to new pin " + this.newPin;
        } else
            return "Incorrect old pin,please try again";

    }
}
