import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable
{
    static final int GAME_WIDTH=1000;
    static final int GAME_HEIGHT=(int)(GAME_WIDTH*(0.6));
    static final Dimension SCREEN_SIZE=new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER=20;
    static final int PADDLE_WIDTH=25;
    static final int PADDLE_HEIGHT=100;
    Graphics graphics;
    Paddel paddel1;
    Paddel paddel2;
    Ball ball;
    Random random;
    Thread GameThread;
    Image image;
    Score score;






    GamePanel(){
        newPaddel();
        newBall();
        Score score=new Score(GAME_WIDTH,GAME_HEIGHT    );
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        GameThread =new Thread(this);
        GameThread.start();
    }
public void newBall(){

}
    public void newPaddel(){
paddel1=new Paddel(0,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddel2=new Paddel(GAME_WIDTH-PADDLE_WIDTH,((GAME_HEIGHT/2)-(PADDLE_HEIGHT/2)),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void paint(Graphics g){
image=createImage(getWidth(),getHeight());
graphics=image.getGraphics();

draw(graphics);
g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g){
paddel1.draw(g);
paddel2.draw(g);


    }
    public void move(){
        paddel1.move();//for smooth movement
        paddel2.move();
    }

    public void run(){
long lasttime=System.nanoTime();
double amountofticks=60.0;
double ns=1000000000/amountofticks;
double delta=0;
while (true){
    long now=System.nanoTime();
    delta+=(now-lasttime)/ns;
    lasttime=now;
    while (delta>=1){
        move();
        checkCollision();
        repaint();
        delta--;
    }
}

    }


    public void checkCollision(){
if(paddel1.y<=0){
    paddel1.y=0;
}
if(paddel1.y>(GAME_HEIGHT-PADDLE_HEIGHT)){
    paddel1.y=(GAME_HEIGHT-PADDLE_HEIGHT);
}
        if(paddel2.y<=0){
            paddel2.y=0;
        }
        if(paddel2.y>(GAME_HEIGHT-PADDLE_HEIGHT)){
            paddel2.y=(GAME_HEIGHT-PADDLE_HEIGHT);
        }
    }
    public class AL extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
paddel1.keyPressed(e);
paddel2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
paddel1.keyReleased(e);
paddel2.keyReleased(e);
        }
    }

}
