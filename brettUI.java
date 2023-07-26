import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

public class brettUI extends UI
{
    private BufferedImage Bild;
    
    private static JLabel[] figurenGe = new JLabel[4];
    private static JLabel[] figurenGr = new JLabel[4];
    private static JLabel[] figurenRo = new JLabel[4];
    private static JLabel[] figurenSc = new JLabel[4];
    
    private static Feld[] f1b4 = new Feld[4];
    private static Feld[] f5b8 = new Feld[4];
    private static Feld[] f11b14 = new Feld[4];
    private static Feld[] f15b18 = new Feld[4];
    private static Feld[] f21b24 = new Feld[4];
    private static Feld[] f25b28 = new Feld[4];
    private static Feld[] f31b34 = new Feld[4];
    private static Feld[] f35b38 = new Feld[4];
    
    private static Feld[] abzweigungen = new Feld[4];
    
    public brettUI() throws java.io.IOException
    {
        //erstellt das leere Fenster
        super(1000, 1000, 25, 25);
        
            // GameManager.gibBrett().gibA(farbenum.Grün).KoordinatenSetzen(545, 45);
            // GameManager.gibBrett().gibA(farbenum.Rot).KoordinatenSetzen(865, 535);
            // GameManager.gibBrett().gibA(farbenum.Schwarz).KoordinatenSetzen(380, 860);
            // GameManager.gibBrett().gibA(farbenum.Gelb).KoordinatenSetzen(57, 370);
        
        for(int i = 0; i < 4; i++)
        {
            f1b4[i] = GameManager.gibBrett().gibFeld(i+1);
            f1b4[i].KoordinatenSetzen(545, 45 + 80*(i+1));
            f5b8[i] = GameManager.gibBrett().gibFeld(i+5);
            f5b8[i].KoordinatenSetzen(545 + 80*(i+1),370);
            f11b14[i] = GameManager.gibBrett().gibFeld(i+11);
            f11b14[i].KoordinatenSetzen(865 - 80*(i+1) , 535);
            f15b18[i] = GameManager.gibBrett().gibFeld(i+15);
            f15b18[i].KoordinatenSetzen(545, 465 + 150 + (80*i));
            f21b24[i] = GameManager.gibBrett().gibFeld(i+21);
            f21b24[i].KoordinatenSetzen(380, 860 - 80*(i+1));
            f25b28[i] = GameManager.gibBrett().gibFeld(i+25);
            f25b28[i].KoordinatenSetzen(380 - 80*(i+1),535);
            f31b34[i] = GameManager.gibBrett().gibFeld(i+31);
            f31b34[i].KoordinatenSetzen(57 + 80*(i+1),370);
            f35b38[i] = GameManager.gibBrett().gibFeld(i+35);
            f35b38[i].KoordinatenSetzen(380, 370 - 80*(i+1));
            
            abzweigungen[i] = GameManager.gibBrett().gibFeld(9 + 10*i);
            
            Image BIGE =
                            ImageIO.read(new File("figur0t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);
            Image BIGR =
                            ImageIO.read(new File("figur1t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);
            Image BIRO =
                            ImageIO.read(new File("figur2t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);  
            Image BISC =
                            ImageIO.read(new File("figur3t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);
            figurenGe[i] = new JLabel(new ImageIcon(BIGE));
            figurenGr[i] = new JLabel(new ImageIcon(BIGR));
            figurenSc[i] = new JLabel(new ImageIcon(BISC));
            figurenRo[i] = new JLabel(new ImageIcon(BIRO));
            
            
            frame.add(figurenGe[i]);
            frame.add(figurenGr[i]);
            frame.add(figurenSc[i]);
            frame.add(figurenRo[i]);
            
            //das letzte objekt was hinzugefügt wird erscheint in der mitte
            //ich weiß nicht warum das passiert aber ohne diese zeile erscheint
            //die vierte rote figur in der mitte
            //durch das Label wird ein "unsichbares" rechteck in der mitte
            //erschaffen und dadurch ist die rote figur unten rechts
            //java ist manchmal komisch aber immerhin funktionierts so
            frame.add(new JLabel(new ImageIcon(ImageIO.read
                                (new File("mittetest.jpg")))));
        }
        
        //figurenGe[0].setBounds(545, 45, 60, 60);
        //figurenGe[0].setBounds(380, 860, 60, 60);
        //figurenGe[0].setBounds(865, 535, 60, 60);
        //figurenGe[0].setBounds(57, 370, 60, 60);
        //figurenGe[0].setBounds(545, 125, 60, 60);
        figurenGe[0].setBounds(55, 50, 60, 60);
        figurenGe[1].setBounds(135, 50, 60, 60);
        figurenGe[2].setBounds(55, 130, 60, 60);
        figurenGe[3].setBounds(135, 130, 60, 60);
        //figurenGe[0].setLocation(57+80*4, 370 + 80);
        
        figurenGr[0].setBounds(55 + 735, 50, 60, 60);
        figurenGr[1].setBounds(135 + 735, 50, 60, 60);
        figurenGr[2].setBounds(55 + 735, 130, 60, 60);
        figurenGr[3].setBounds(135 + 735, 130, 60, 60);
        
        figurenRo[0].setBounds(55 + 734, 50 + 730, 60, 60);
        figurenRo[1].setBounds(135 + 737, 50 + 730, 60, 60);
        figurenRo[2].setBounds(55 + 734, 130 + 730, 60, 60);
        figurenRo[3].setBounds(872, 860, 60, 60);
        
        figurenSc[0].setBounds(54, 50 + 728, 60, 60);
        figurenSc[1].setBounds(137, 50 + 728, 60, 60);
        figurenSc[2].setBounds(54, 130 + 728, 60, 60);
        figurenSc[3].setBounds(137, 130 + 728, 60, 60);
        
        //pass die groeße vom Bild an
        Bild = ImageIO.read(new File("Spielbrett.jpg"));
        Image croppedBild = Bild.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        JLabel BildLabel = new JLabel(new ImageIcon(croppedBild));
        BildLabel.setBounds(1000, 1000, 0, 0);
        frame.add(BildLabel);
        
        //behebt den fehler, mehr informationen in der methode selbst
        super.resetsize();
    }
    
    public static JLabel[] gibLabelArr(farbenum f)
    {
        if(f == farbenum.Gelb)
            return figurenGe;
        if(f == farbenum.Grün)
            return figurenGr;
        if(f == farbenum.Rot)
            return figurenRo;
        if(f == farbenum.Schwarz)
            return figurenSc;
        return null;
    }
    
    public void ziehFigur(Feld f, farbenum fe, int figurnr)
    {
        //System.out.println(fe + " zieht auf" + f.gibX()+ ", " + f.gibY());
        gibLabelArr(fe)[figurnr].setLocation(f.gibX(), f.gibY());
        frame.repaint();
    }
    
    public void ziehFigur(Feld f, farbenum fe, Figur figur)
    {
        Spieler figuren = GameManager.gibSpieler(fe);
        for(int i = 0; i < 4; i ++)
        {
            if(GameManager.gibSpieler(fe).gibFigur(i) == figur)
            {
                ziehFigur(f, fe, i);
            }
        }
    }
}
