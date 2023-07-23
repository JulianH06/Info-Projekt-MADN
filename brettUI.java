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
    private static JLabel[] figurenSc = new JLabel[4];
    private static JLabel[] figurenRo = new JLabel[4];
    
    public brettUI() throws java.io.IOException
    {
        //erstellt das leere Fenster
        super(1000, 1000, 25, 25);
        
        
        for(int i = 0; i < 4; i++)
        {
            Image BIGE =
                            ImageIO.read(new File("figur0t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);
            Image BIGR =
                            ImageIO.read(new File("figur1t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);
            Image BISC =
                            ImageIO.read(new File("figur2t.png")).getScaledInstance
                            (60, 60, Image.SCALE_SMOOTH);  
            Image BIRO =
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
        
        
        figurenGe[0].setBounds(55, 50, 60, 60);
        figurenGe[1].setBounds(135, 50, 60, 60);
        figurenGe[2].setBounds(55, 130, 60, 60);
        figurenGe[3].setBounds(135, 130, 60, 60);
        
        figurenGr[0].setBounds(55 + 735, 50, 60, 60);
        figurenGr[1].setBounds(135 + 735, 50, 60, 60);
        figurenGr[2].setBounds(55 + 735, 130, 60, 60);
        figurenGr[3].setBounds(135 + 735, 130, 60, 60);
        
        figurenSc[0].setBounds(54, 50 + 728, 60, 60);
        figurenSc[1].setBounds(137, 50 + 728, 60, 60);
        figurenSc[2].setBounds(54, 130 + 728, 60, 60);
        figurenSc[3].setBounds(137, 130 + 728, 60, 60);
        
        figurenRo[0].setBounds(55 + 734, 50 + 730, 60, 60);
        figurenRo[1].setBounds(135 + 737, 50 + 730, 60, 60);
        figurenRo[2].setBounds(55 + 734, 130 + 730, 60, 60);
        figurenRo[3].setBounds(872, 860, 60, 60);
        
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
        if(f == farbenum.Schwarz)
            return figurenSc;
        if(f == farbenum.Rot)
            return figurenRo;
        return null;
    }
}
