package vn.codegym.dto;

public class DemoCounter {
    private int count;

    public DemoCounter() {
        this.count = 5;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count ++;
    }
}
