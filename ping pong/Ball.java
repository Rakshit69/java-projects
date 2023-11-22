import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle

{
    int xVelocity;
    int yVelocity;
    int id;
    Random random;
    int speed=4;
    Ball(int x,int y ,int width,int height){
        super(x,y,width,height);
        random=new Random();
        int randomXDirection=random.nextInt(2);
        if(randomXDirection==0)
            randomXDirection--;
        setxDirection(randomXDirection*speed);
        int randomYdirection=random.nextInt(2);
        if(randomYdirection==0)
            randomYdirection--;
        setyDirection(randomYdirection*speed);
    }
    public void move(){
        x+=xVelocity;
        y+=yVelocity;
    }
    public void setxDirection(int randomXdirection){
        xVelocity=randomXdirection;
    }
    public void setyDirection(int randomYdirection){
        yVelocity=randomYdirection;
    }



    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,height,width);
    }
}
