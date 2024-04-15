package Exam.models;

public class PaymentAccount extends AccountBank {
    private String cardNumber;
    private double moneyInAccount;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getMoneyInAccount() {
        return moneyInAccount;
    }

    public void setMoneyInAccount(double moneyInAccount) {
        this.moneyInAccount = moneyInAccount;
    }

    public PaymentAccount(int id, String code, String name, String date, String cardNumber, double moneyInAccount) {
        super(id, code, name, date);
        this.cardNumber = cardNumber;
        this.moneyInAccount = moneyInAccount;
    }

//    public PaymentAccount(String code, String name, String date, String cardNumber, double moneyInAccount) {
//        super(code, name, date);
//        this.cardNumber = cardNumber;
//        this.moneyInAccount = moneyInAccount;
//    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",
                super.toString(), getCardNumber(), getMoneyInAccount());
    }
}



