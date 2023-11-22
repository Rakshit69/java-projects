import org.omg.PortableServer.THREAD_POLICY_ID;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddel  extends Rectangle

{
    int yVelocity;
    int id;
    int speed=10;

    Paddel(int x ,int y ,int PAADLE_WIDTH,int PADDLE_HEIGHT,int id){
super(x,y,PAADLE_WIDTH,PADDLE_HEIGHT)   ;
        this.id=id;
    }
    public void keyPressed(KeyEvent e){
        switch (id){
            case 1:
                if (e.getKeyCode()==KeyEvent.VK_W){
                    setyDirection(-speed);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    setyDirection(speed);
                    move();

                }
                break;
            case 2:
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    setyDirection(-speed);
                    move();

                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    setyDirection(speed);
                    move();

                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (id){
            case 1:
                if (e.getKeyCode()==KeyEvent.VK_W){
                    setyDirection(0);
                    move();
                }
                if (e.getKeyCode()==KeyEvent.VK_S){
                    setyDirection(0);
                    move();

                }
                break;
            case 2:
                if (e.getKeyCode()==KeyEvent.VK_UP){
                    setyDirection(0);
                    move();

                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    setyDirection(0);
                    move();

                }
                break;
    }
    }
    public void move(){

        y=y+yVelocity;
    }

    public void setyDirection(int Ydirection){
        yVelocity=Ydirection;

    }
    public void draw(Graphics g){
        if (id==1) g.setColor(Color.blue);
        else g.setColor(Color.red);
        g.fillRect(x,y,width,height);

    }


}
