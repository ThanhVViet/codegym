package ss6_inheritance.exercise.Point_MPoint;

import java.text.MessageFormat;
import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;

    private float ySpeed = 0.0f;

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float x, float y) {
        this.xSpeed = x;
        this.ySpeed = y;
    }

    public float[] getSpeed() {
        float[] arr = new float[2];
        arr[0] = this.xSpeed;
        arr[1] = this.ySpeed;
        return arr;
    }

    @Override
    public String toString() {
        return MessageFormat.format("MovablePoint'{'xSpeed={0}, ySpeed={1}, x and y:{2}'}'", xSpeed, ySpeed, Arrays.toString(super.getXY()));

//        return "MovablePoint{xSpeed=%s, ySpeed=%s, x and y:%s}".formatted(xSpeed, ySpeed, super.getXY());
//        return new StringBuilder().
//                append("MovablePoint{").append("xSpeed=").append(xSpeed).append(", ySpeed=").append(ySpeed).append(", x and y:").
//                append(Arrays.toString(super.getXY())).append('}').toString();
//        return "MovablePoint{" + "xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + ", x and y:" + String.valueOf(super.getXY()) + '}';
    }

    public MovablePoint move() {
        setX(getX()+ xSpeed);
        setY(getY()+ ySpeed);
        return this;
    }

}
