package object;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement

public class Coordinates implements Serializable {
    private int x;
    private double y; //Значение поля должно быть больше -174

    public void setX(int x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    @XmlElement
    public double getY() {
        return y;
    }
    @XmlElement
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