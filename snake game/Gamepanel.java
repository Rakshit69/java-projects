import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

public class Gamepanel extends JPanel implements ActionListener {
    static final int GAME_WIDTH=1300;
    static final int GAME_HEIGHT=740;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=(GAME_WIDTH*GAME_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static  int DELAY=75;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
int parts=6;
int appleeten;
int applex;
int appley;

char direction='d';
Random random;
Timer timer;
boolean running=false;



Gamepanel(){
    this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
    random=new Random();

    this.setBackground(Color.black);
    this.setFocusable(true);
    this.addKeyListener(new myAdapter());
    startGame();

}
    public void startGame(){
        newapple();   running=true;

    timer=new Timer(DELAY,this);
    timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
super.paintComponent(g);
draw(g);

    }
public void draw(Graphics g){
    if(running){
      //  the lines are removed
//        for (int i = 0; i < GAME_WIDTH/UNIT_SIZE; i++) {
//            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,GAME_HEIGHT);
//            g.drawLine(0,i*UNIT_SIZE,GAME_WIDTH,i*UNIT_SIZE);
//
//         }
         g.setColor(Color.red);
        g.fillOval(applex,appley,UNIT_SIZE,UNIT_SIZE);
        for (int i = 0; i < parts; i++) {
            if(i==0){
                g.setColor(Color.green);
                g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);

            }
            else {
                g.setColor(new Color(45,101,4));
                g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("ink free",Font.BOLD,40));
        FontMetrics matrix=getFontMetrics(g.getFont());
        g.drawString("SCORE: "+appleeten,(GAME_WIDTH-matrix.stringWidth("SCORE: "+appleeten))/2,g.getFont().getSize());
    }

    else {
        endGame( g);
    }
}
public void newapple(){
    applex=random.nextInt((int)(GAME_WIDTH/UNIT_SIZE))*UNIT_SIZE;
    appley=random.nextInt((int)(GAME_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

}

    public void move(){
        for (int i = parts; i >0; i--) {
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        switch (direction){
            case  'r':{
                x[0]=x[0]+UNIT_SIZE;


            break;
            }
            case  'l':{
                x[0]=x[0]-UNIT_SIZE;
            break;
            }
            case  'u':{
                y[0]=y[0]-UNIT_SIZE;
            break;
            }
            case  'd':{
                y[0]=y[0]+UNIT_SIZE;
            break;
            }
        }
    }
    public void checkcollision(){
for (int i=parts;i>0;i--){
    if((x[i]==x[0]) && (y[i]==y[0])){
        running=false;
    }

}
if(x[0]>GAME_WIDTH) {running=false;}
if(x[0]<0) {running=false;}
if(y[0]<0){ running=false;}
if(y[0]>GAME_HEIGHT) {running=false;}

if(!running) timer.stop();
    }
    public void checkApple(){
if((x[0]==applex) && y[0]==appley){
    parts++;
    appleeten++;
    if(DELAY>=20){
    DELAY-=2;
    timer.setDelay(DELAY);}
    System.out.println(DELAY);
    newapple();
}

    }
    public void endGame(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("ink free",Font.BOLD,40));
        FontMetrics matrix1=getFontMetrics(g.getFont());
        g.drawString("SCORE: "+appleeten,(GAME_WIDTH-matrix1.stringWidth("SCORE: "+appleeten))/2,g.getFont().getSize());

        g.setColor(Color.red);
g.setFont(new Font("ink free",Font.BOLD,75));
FontMetrics matrix=getFontMetrics(g.getFont());
g.drawString("GAME OVER",(GAME_WIDTH-matrix.stringWidth("GAME OVER"))/2,GAME_HEIGHT/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
if(running){
    move();
    checkcollision();
    checkApple();

}
repaint();
    }
    public class myAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
switch (e.getKeyCode()){
    case KeyEvent.VK_LEFT:
        if(direction!='r') direction='l';
        break;
    case KeyEvent.VK_RIGHT:
        if(direction!='l') direction='r';
        break;
    case KeyEvent.VK_UP:
        if(direction!='d') direction='u';
        break;
    case KeyEvent.VK_DOWN:
        if(direction!='u') direction='d';
        break;
}
        }
    }

}
