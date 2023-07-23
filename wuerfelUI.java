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
    
    public wuerfelUI() throws java.io.IOException 
    {
        super(600, 700, 1100, 200);
        
        label1 = new JLabel(GameManager.gibAktuellerSpieler() + " Würfelt...");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(32f));
        
        Bild = new ImageIcon(ImageIO.read(new File("wuerfel.jpg")));
        WuerfelGif = new ImageIcon(ImageIO.read(new File("wuerfelgif.gif")));
        //frame.add(new JLabel(Bild));
        
        WuerfelImageArr = new ImageIcon[6];
        for(int i = 0; i < 6; i++)
        {
            WuerfelImageArr[i] = new ImageIcon(ImageIO.read(new File(
            "wuerfel" + (i+1) + ".jpg")));
        }
        
        int rnd = new Random().nextInt(6)+1;
        Knopf = new JButton(new ImageIcon(ImageIO.read(new File(
                            "wuerfel" + rnd  + ".jpg"))));
                            
        Knopf.setBounds(17, 50, 550, 600);
        Knopf.addActionListener(this);
        
        frame.add(Knopf);
        frame.add(label1);
    }

    public void actionPerformed (ActionEvent ae)
    {
        if(!gewuerfelt)
        {
            int erg = GameManager.Wuerfeln();
            //try{wuerfelanimation();}catch(java.io.IOException ie){}
            //try{TimeUnit.SECONDS.sleep(1);}catch (InterruptedException ie){}
            label1.setText(String.valueOf(erg));
            try{
                Knopf.setIcon(new ImageIcon(ImageIO.read(new File(
                            "wuerfel" + erg + ".jpg"))));}
            catch (Exception ie){}
            GameManager.Instance.notifyGM();
            GameManager.ergebnisSetzen(erg);
            gewuerfelt = true;
            frame.repaint();
            System.out.println("RUNNING");
        }
    }
    
    public boolean gewuerfelt()
    {
        return gewuerfelt;
    }
    
    public void wuerfelanimation() throws java.io.IOException
    {
        System.out.println("ANIM");
        Knopf.disable();
        Knopf.hide();
        for(int i = 1; i < 10; i++)
        {
            int rnd = new Random().nextInt(6);
            System.out.println(i);
            label1.setIcon(WuerfelGif);//WuerfelImageArr[rnd]);
            //Knopf.disable();
            try{TimeUnit.MILLISECONDS.sleep(100);}catch (InterruptedException ie)
            {ie.printStackTrace();}
        }
    }
}
