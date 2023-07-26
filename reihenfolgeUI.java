import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class reihenfolgeUI extends UI implements ActionListener
{
    protected JButton KnopfGe;
    protected JButton KnopfGr;
    protected JButton KnopfRo;
    protected JButton KnopfSc;
    JLabel label1 = new JLabel("Wähle den zu beginnenden Spieler!");
    
    public reihenfolgeUI() throws java.io.IOException
    {
        super(600, 600, 1100, 200);
        
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(32f));
        
        KnopfGe = new JButton(new ImageIcon(ImageIO.read(new File("figur0.jpg"))));
        KnopfGr = new JButton(new ImageIcon(ImageIO.read(new File("figur1.jpg"))));
        KnopfRo = new JButton(new ImageIcon(ImageIO.read(new File("figur2.jpg"))));
        KnopfSc = new JButton(new ImageIcon(ImageIO.read(new File("figur3.jpg"))));
        
        KnopfGe.setBounds(75, 75, 200, 200);
        KnopfGr.setBounds(325, 75, 200, 200);
        KnopfRo.setBounds(325, 325, 200, 200);
        KnopfSc.setBounds(75, 325, 200, 200);
        
        KnopfGe.addActionListener(this);
        KnopfGr.addActionListener(this);
        KnopfRo.addActionListener(this);
        KnopfSc.addActionListener(this);
        
        frame.add(KnopfGe);
        frame.add(KnopfGr);
        frame.add(KnopfSc);
        frame.add(KnopfRo);
        frame.add(label1);
        
        super.resetsize(600, 600);
    }
    
    public void actionPerformed (ActionEvent ae)
    {
        if(ae.getSource() == KnopfGe)
        {
            GameManager.beginnendenSpielerSetzen(farbenum.Gelb);
        }
        if(ae.getSource() == KnopfGr)
        {
            GameManager.beginnendenSpielerSetzen(farbenum.Grün);
        }
        if(ae.getSource() == KnopfRo)
        {
            GameManager.beginnendenSpielerSetzen(farbenum.Rot);
        }
        if(ae.getSource() == KnopfSc)
        {
            GameManager.beginnendenSpielerSetzen(farbenum.Schwarz);
        }
        GameManager.Instance.notifyGM();
        super.close();
    }
}
