package Exam.models;

public class SavingAccount extends AccountBank {
    private double money;
    private String dateOfSaving;

    private double interest;
    private int tenor;

    public SavingAccount() {
    }

//    public SavingAccount(String code, String name, String date, double money, String dateOfSaving, double interest, int tenor) {
//        super(code, name, date);
//        this.money = money;
//        this.dateOfSaving = dateOfSaving;
//        this.interest = interest;
//        this.tenor = tenor;
//    }

    public SavingAccount(int id, String code, String name, String date, double money, String dateOfSaving, double interest, int tenor) {
        super(id, code, name, date);
        this.money = money;
        this.dateOfSaving = dateOfSaving;
        this.interest = interest;
        this.tenor = tenor;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDateOfSaving() {
        return dateOfSaving;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                super.toString(), getMoney(), getDateOfSaving(), getInterest(), getTenor());
    }
}
