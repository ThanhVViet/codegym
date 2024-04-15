package Exam.models;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AccountBank {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String code;
    private String name;
    private String date;

    public AccountBank() {
    }

//    public AccountBank(String code, String name, String date) {
//        this.id = count.incrementAndGet();
//        this.code = code;
//        this.name = name;
//        this.date = date;
//    }

    public AccountBank(int id, String code, String name, String date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s ",
                getId(), getCode(), getName(), getDate());
    }
}
