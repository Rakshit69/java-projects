import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GameFrame(){
        this.add(new Gamepanel());
        this.setResizable(false);
        this.setTitle("SNAKE GAME");
        this.setFont(new Font("ink free",0,31));
        this.setDefaultCloseOperation(3);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}
