import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;

public class brettUI extends UI
{
    private BufferedImage Bild;
    
    public brettUI() throws java.io.IOException
    {
        //erstellt das leere Fenster
        super(1000, 1000, 25, 25);
        
        //pass die groeße vom Bild an
        Bild = ImageIO.read(new File("Spielbrett.jpg"));
        Image croppedBild = Bild.getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
        frame.add(new JLabel(new ImageIcon(croppedBild)));
        
        //behebt den fehler, mehr informationen in der methode selbst
        super.resetsize();
    }
}
