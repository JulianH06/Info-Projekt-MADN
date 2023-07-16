import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;

public class wuerfelUI extends UI implements ActionListener
{
    private ImageIcon Bild;
    protected JButton Knopf;
    JLabel label1 = new JLabel("Spieler Würfelt...");
    
    public wuerfelUI() throws java.io.IOException
    {
        super(600, 700, 1100, 200);
        
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(32f));
        
        Bild = new ImageIcon(ImageIO.read(new File("wuerfel.jpg")));
        //frame.add(new JLabel(Bild));
        
        Knopf = new JButton(Bild);
        Knopf.setBounds(17, 50, 550, 600);
        Knopf.addActionListener(this);
        
        frame.add(Knopf);
        frame.add(label1);
    }

    public void actionPerformed (ActionEvent ae)
    {
        label1.setText(String.valueOf(GameManager.Wuerfeln()));
        //System.out.println("DRUCK");
    }
}
