package ss7_abstract_interface.practice.Animal_and_interface_Edible;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            animal.makeSound();
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal; // ép kiểu đối tượng animal thành kiểu chicken
                // rồi gán cho biến edibler
                System.out.println(edibler.howToEat());
            }
        }


        Fruit [] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) { // lặp qua mỗi phan tu fruit trong mang fruits
            System.out.println(fruit.howToEat()); // goi phuong thuc tren moi dôi tuong fruit
        }
    }
}
