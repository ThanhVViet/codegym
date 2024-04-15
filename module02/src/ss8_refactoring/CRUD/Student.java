package ss8_refactoring.CRUD;

import java.util.Scanner;

public class Student {

    private  int id;
    private String name;
    private double score;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score < 0 || score > 10) {
            System.out.println("Điểm không hợp lệ");
            // exception
        } else {
            this.score = score;
        }
    }

    public void check(int id) {
        boolean check = false;
        while (!check) {
            if (this.id == id) {
                System.out.println("ID trùng !!! Vui lòng nhập lai");
                System.out.println("Nhập lại ID: ");
                Scanner input = new Scanner(System.in);
                id = Integer.parseInt(input.nextLine());
            } else {
                check = true;
            }
        }

    }

    public static int nhap() {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        while (!check) {
            System.out.print(" ");
            try {
                n = input.nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Ban phai nhap so! hay nhap lai...");
                input.nextLine();
            }
        }
        return (n);
    }

    public Student(int id, String name, double score) {
     //   Student.id = id;
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
