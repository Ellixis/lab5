package object;

public class Coordinates {
    private int x;
    private double y; //Значение поля должно быть больше -174

    public void setX(int x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                '}';
    }
}