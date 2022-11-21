import java.util.*;
import java.io.*;
import java.awt.*;

public class bicycle {
    String color;
    double location;
    double speed;
    public bicycle(String c){
        color = c;
        location = 0;
        speed = 0;
    }
    public void setSpeed(double newSpeed){
        speed = newSpeed;
    }
    public void increaseSpeed(double deltaSpeed){
        speed += deltaSpeed;
    }
    public double travel(double hours){
        double traveled = hours * speed;
        location += traveled;
        return traveled;
    }
}