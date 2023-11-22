import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Random;

public class Gamepanel extends JPanel implements ActionListener {
    static final int GAME_WIDTH=600;
    static final int GAME_HEIGHT=600;
    static final int UNIT_SIZE=25;
    static final int GAME_UNITS=(GAME_WIDTH*GAME_HEIGHT)/UNIT_SIZE;
    static final int DELAY=75;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
int parts=6;
int appleeten;
int applex;
int appley;

char direction='r';
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
    newapple();
    running=true;
    timer=new Timer(DELAY,this);
    timer.start();

    }

    @Override
    public void paint(Graphics g) {
super.paint(g);
draw(g);

    }
public void draw(Graphics g){
    for (int i = 0; i < GAME_WIDTH/UNIT_SIZE; i++) {
        g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,GAME_HEIGHT);
        g.drawLine(0,i*UNIT_SIZE,GAME_WIDTH,i*UNIT_SIZE);

    }
    g.setColor(Color.red);
    g.fillOval(applex,appley,UNIT_SIZE,UNIT_SIZE);
    for (int i = 0; i < parts; i++) {
        if(i==0){
            g.setColor(Color.green);
            g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);

        }
        else {
            g.setColor(new Color(45,101,4));
            g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
        }
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
            }
            case  'l':{
                x[0]=x[0]-UNIT_SIZE;
            }
            case  'u':{
                y[0]=y[0]-UNIT_SIZE;
            }
            case  'd':{
                y[0]=y[0]+UNIT_SIZE;
            }
        }
    }
    public void checkcollision(){

    }
    public void checkApple(){

    }
    public void endGame(){

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

        }
    }

}
