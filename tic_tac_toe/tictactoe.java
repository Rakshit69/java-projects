package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class tictactoe implements ActionListener {
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton []buttons=new JButton[9];
    boolean player_one_turn;
 tictactoe(){//MV boli INK free

    frame.setSize(900,900);
    frame.setLayout(new BorderLayout());
    frame.setVisible(true);
    frame.getContentPane().setBackground(new Color(50,50,50));
    frame.setDefaultCloseOperation(3);
    textfield.setOpaque(true);
    textfield.setBackground(new Color(25,25,25));
    textfield.setForeground(new Color(25,254,0));
    textfield.setText("Tic-Tac-Toe");
    textfield.setFont(new Font("ink free",Font.BOLD,75));
    textfield.setHorizontalAlignment(SwingConstants.CENTER);

    title_panel.setLayout(new BorderLayout());
     title_panel.setBounds(0,0,800,100);

   button_panel.setLayout(new GridLayout(3,3));
     button_panel.setBackground(new Color(125,125,125));
     for (int i = 0; i < 9; i++) {
         buttons[i]=new JButton();
         button_panel.add(buttons[i]);
         buttons[i].setOpaque(true);
         buttons[i].setFont(new Font("mv boli",Font.BOLD,120));
         buttons[i].addActionListener(this);
         buttons[i].setFocusable(false);
     }
    title_panel.add(textfield);

    frame.add(title_panel,BorderLayout.NORTH); frame.add(button_panel);
firstTurn();

 }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource()==buttons[i]){
                System.out.println(player_one_turn);
                if (player_one_turn){
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");

                        textfield.setText("O Turn");
player_one_turn=false;
check();
                    }
                }else if(player_one_turn==false) {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");

                        textfield.setText("X Turn");
                        player_one_turn=true;
                        check();
                    }
                }
            }
        }
    }
    public  void firstTurn(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("exception");
        }
        if(random.nextInt(2)==0){
    player_one_turn=true;

    textfield.setText("X Turn");

}
else {
    player_one_turn=false;
    textfield.setText("O Turn");


}
    }
    public void check(){
if((buttons[0].getText()=="X") &&
        (buttons[1].getText()=="X") &&
        (buttons[2].getText()=="X")
){
    Xwins(0,1,2);
}
        if((buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ){
            Xwins(3,4,5);
        }
        if((buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            Xwins(6,7,8);
        }
        if((buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            Xwins(0,4,8);
        }
        if((buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            Xwins(2,4,6);
        }
        if((buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ){
            Xwins(1,4,7);
        }
        if((buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ){
            Xwins(2,5,8);
        }
        if((buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ){
            Xwins(0,3,6);
        }
        // O wins condition
        if((buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ){
            Owins(0,1,2);
        }
        if((buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ){
            Owins(3,4,5);
        }
        if((buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            Owins(6,7,8);
        }
        if((buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            Owins(0,4,8);
        }
        if((buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            Owins(2,4,6);
        }
        if((buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ){
            Owins(1,4,7);
        }
        if((buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ){
            Owins(2,5,8);
        }
        if((buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ){
            Owins(0,3,6);
        }

    }
    public void Xwins(int a,int b ,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        textfield.setText("X wins");
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
    }
    public void Owins(int a,int b ,int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        textfield.setText("O wins");
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
    }

}
