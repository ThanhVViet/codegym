package ss4_oop.exercise;

public class C_FAN {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(fan1.getFast());
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.toString();

        Fan fan2 = new Fan();
        fan2.toString();

        Fan fan3 = new Fan(2, 2, "red", false);
        fan3.toString();
    }

    public static class Fan {
        private final int Slow = 1;
        private final int Medium = 2;
        private final int Fast = 3;

        public int getSlow() {
            return Slow;
        }

        public int getMedium() {
            return Medium;
        }

        public int getFast() {
            return Fast;
        }

        private int speed;
        private boolean on;
        private double radius;
        private String color;

        public Fan() {
            this.speed = Slow;
            this.on = false;
            this.radius = 5;
            this.color = "blue";
        }

        public Fan(int speed, double radius, String color, boolean on) {
            this.speed = speed;
            this.radius = radius;
            this.color = color;
            this.on = on;
        }

        public int getSpeed() {
            return speed;
        }

        public boolean isOn() {
            return on;
        }

        public double getRadius() {
            return radius;
        }

        public String getColor() {
            return color;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            String str = " ";
            if (on == true) {
                System.out.println("Fan is on with the speed is " + this.getSpeed() + " ,color " + this.color + ", the radius is " + this.radius);
            } else {
                System.out.println("Fan is off !!" + " color is " + this.color + ",radius is " + this.radius);
            }
            return str;
        }
    }
}
