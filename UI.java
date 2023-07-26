import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class UI
{
    protected JFrame frame;
    
    public UI(int w, int h) throws java.io.IOException
    {
        //erstellt leeres Fenster mit breite w und hoehe h
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1300,400);
        frame.setVisible(true);
        frame.setSize(w,h);
    }
    
    public UI(int w, int h, int x, int y) throws java.io.IOException
    {
        //erstellt leeres Fenster mit breite w und hoehe h 
        //an den Koordinaten x und y
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(x, y);
        frame.setVisible(true);
        frame.setSize(w,h);
    }
    
    public void resetsize()
    {
        frame.setSize(1001, 1001);
        frame.setSize(1000, 1000);
        //es gibt einen Bug dass das Bild nicht geladen wird
        //ich hab herausgefunden, dass das Bild erscheint, wenn ich die größe
        //des Fensters verändere
        //Ich weiß nicht warum das passiert aber durch diese Methode wird der
        //Fehler behoben 
    }
    
    public void resetsize(int w, int h)
    {
        frame.setSize(w+1, h+1);
        frame.setSize(w, h);
    }
    
    public void close()
    {
        frame.setVisible(false);
        frame.dispose();
    }
}
