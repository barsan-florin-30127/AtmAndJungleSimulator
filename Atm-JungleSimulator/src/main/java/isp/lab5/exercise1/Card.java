package isp.lab5.exercise1;

public class Card {
    private String cardId;
    private String pin;

    Card(String cardId, String pin) {
        this.cardId = cardId;
        this.pin = pin;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPin() {
        return pin;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                '}';
    }
}
