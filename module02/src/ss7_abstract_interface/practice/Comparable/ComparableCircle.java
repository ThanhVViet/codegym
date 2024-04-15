package ss7_abstract_interface.practice.Comparable;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
//    Ngoài ra, lớp ComparableCircle cũng triển khai giao diện Comparable<ComparableCircle>.
//        Giao diện Comparable được sử dụng để so sánh các đối tượng của cùng một kiểu với nhau và xác định thứ tự của chúng.
//        Trong trường hợp này, giao diện Comparable<ComparableCircle>
//chỉ định rằng lớp ComparableCircle có thể được so sánh với nhau và sắp xếp dựa trên một tiêu chí nhất định.
//        Bằng cách triển khai giao diện Comparable<ComparableCircle>,
//        lớp ComparableCircle phải cung cấp một phương thức compareTo để so sánh các đối tượng
//        của nó với các đối tượng khác cùng kiểu ComparableCircle. Trong phương thức compareTo,
//        bạn xác định cách so sánh các thuộc tính của đối tượng hiện tại (this)
//        với thuộc tính của đối tượng được truyền vào như một tham số.
//        Phương thức compareTo trả về một số nguyên dựa trên kết quả so sánh,
//        cho phép sắp xếp các đối tượng ComparableCircle theo thứ tự mong muốn.
