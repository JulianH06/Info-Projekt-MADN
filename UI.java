import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;

public class UI implements ActionListener
{
    JLabel label1 = new JLabel("Spieler Würfelt...");
    JFrame frame;
    private ImageIcon Bild;
    JButton Knopf;
    
    public UI() throws java.io.IOException
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1300,400);
        frame.setVisible(true);
        frame.setSize(600,675);
        
        
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(18f));
        
        Bild = new ImageIcon(ImageIO.read(new File("wuerfel.jpg")));
        //frame.add(new JLabel(Bild));
        
        Knopf = new JButton(Bild);
        Knopf.setBounds(17, 25, 550, 600);
        Knopf.addActionListener(this);
        
        frame.add(Knopf);
        frame.add(label1);
    }
    
    public void actionPerformed (ActionEvent ae){
        label1.setText(String.valueOf(GameManager.Wuerfeln()));
        System.out.println("DRUCK");
    }
}
