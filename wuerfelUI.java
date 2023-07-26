import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class wuerfelUI extends UI implements ActionListener
{
    private ImageIcon Bild;
    private ImageIcon[] WuerfelImageArr;
    private ImageIcon WuerfelGif;
    protected JButton Knopf;
    JLabel label1;
    private boolean gewuerfelt = false;
    private Timer timer;
    private wuerfelUI alteswUI;
    
    public wuerfelUI() throws java.io.IOException 
    {
        super(600, 700, 1100, 300);
        
        label1 = new JLabel(GameManager.gibAktuellerSpieler() + " Würfelt...");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(32f));
        
        Bild = new ImageIcon(ImageIO.read(new File("wuerfel.jpg")));
        //WuerfelGif = new ImageIcon(ImageIO.read(new File("wuerfelgif.gif")));
        //frame.add(new JLabel(Bild));
        
        WuerfelImageArr = new ImageIcon[6];
        for(int i = 0; i < 6; i++)
        {
            WuerfelImageArr[i] = new ImageIcon(ImageIO.read(new File(
            "wuerfel" + (i+1) + ".jpg")));
        }
        
        Knopf = new JButton(new ImageIcon(ImageIO.read(new File(
                            "wuerfelFRAGEZEICHEN.jpg"))));
                            
        Knopf.setBounds(17, 50, 550, 600);
        Knopf.addActionListener(this);
        
        frame.add(Knopf);
        frame.add(label1);
        
        super.resetsize(600, 700);
    }

    public void actionPerformed (ActionEvent ae)
    {
        if(!gewuerfelt)
        {
            int erg = GameManager.Wuerfeln();
            
            label1.setText(String.valueOf(erg));
            
            try{
                Knopf.setIcon(new ImageIcon(ImageIO.read(new File(
                            "wuerfel" + erg + ".jpg"))));}
            catch (Exception ie){}
            
            label1.hide();
            frame.setLocation(1250, 0);
            Knopf.setBounds(17,5, 250, 250);
            frame.setSize(300, 300);
            frame.setTitle("Ergebnis");
            GameManager.closeW2();
            
            GameManager.Instance.notifyGM();
            GameManager.ergebnisSetzen(erg);
            
            gewuerfelt = true;
            
            frame.repaint();
        }
        else
        {
            GameManager.gibSpieler(GameManager.gibAktuellerSpieler())
            .gibfUI().gibFrame().show();
        }
    }
    
    public boolean gewuerfelt()
    {
        return gewuerfelt;
    }
    
    public void alteswUIsetzen(wuerfelUI wUI)
    {
        alteswUI = wUI;
    }
}
