import javax.swing.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class GameManager
{
    public static GameManager Instance;
    private static Brett Brett;
    private static Spieler[] Spieler;
    private static Wuerfel w1;
    private static Wuerfel w2;
    private static brettUI brettUI;
    private static int aktuellesErgebnis;
    private static farbenum aktuellerSpieler;
    private static int aktuelleFigur;
    private static farbenum beginnenderSpieler;
    
    public static void main(String[] args) throws java.io.IOException, InterruptedException {
        new GameManager();
    }
    
    GameManager() throws InterruptedException,java.io.IOException
    {
        Instance = this; //wird evntl. noch gelöscht falls nicht nötig
        
        //erstellt Brett und öffnet das UI Fenster
        Brett = new Brett();
        brettUI = new brettUI();
        
        //erstellt die spieler und weißt ihnen eine farbe zu
        Spieler = new Spieler[4];
        Spieler[0] = new Spieler(farbenum.Gelb);
        Spieler[1] = new Spieler(farbenum.Grün);
        Spieler[2] = new Spieler(farbenum.Rot);
        Spieler[3] = new Spieler(farbenum.Schwarz);
        
        
        spielStarten();
    }
    
    public static int Wuerfeln()
    {
        return w1.wuerfeln();
        //return 6;
    }
    
    public synchronized int ButtonWuerfel() throws InterruptedException,java.io.IOException
    {
        w1 = new Wuerfel();
        while(!w1.wUIgeben().gewuerfelt())
        {
            wait();   
        }
        return aktuellesErgebnis;
    }
    
    public int zweitwuerfeln() throws java.io.IOException,InterruptedException
    {
        w2 = w1;
        //w1.wUIgeben().close();
        Spieler[aktuellerSpieler.ordinal()].zweiMalGewuerfelt();
        return ButtonWuerfel();
    }
    
    public int drittwuerfeln() throws java.io.IOException,InterruptedException
    {
        w2 = w1;
        notify();
        //w1.wUIgeben().close();
        Spieler[aktuellerSpieler.ordinal()].dreiMalGewuerfelt();
        return ButtonWuerfel();
    }
    
    public synchronized int ButtonFigur(farbenum f) throws InterruptedException,java.io.IOException
    {
        while(!Spieler[f.ordinal()].gibfUI().gewaehlt())
        {
            wait();
        }
        return aktuelleFigur;
    }
    
    public synchronized void notifyGM()
    {
        notify();
    }
    
    public static void ergebnisSetzen(int i)
    {
        aktuellesErgebnis = i;
    }
    
    public static void aktFigurSetzen(int i)
    {
        aktuelleFigur = i;
    }
    
    private synchronized void spielStarten() throws java.io.IOException,InterruptedException
    {
        new reihenfolgeUI();
        
        wait();
        
        Spieler[aktuellerSpieler.ordinal()].spielzug();
    }
    
    public static void highlightFigur(int i) throws java.io.IOException
    {
        Image highlightF = 
                    ImageIO.read(new File("figur" + aktuellerSpieler.ordinal()
                    +"th.png"))
                    .getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        brettUI.gibLabelArr(aktuellerSpieler)[i].setIcon(
                    new ImageIcon(highlightF));
    }
    
    public static void unhighlightFigur(int i) throws java.io.IOException
    {
        Image unhighlightF = 
                    ImageIO.read(new File("figur" + aktuellerSpieler.ordinal()
                    +"t.png"))
                    .getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        brettUI.gibLabelArr(aktuellerSpieler)[i].setIcon(
                    new ImageIcon(unhighlightF));
    }
    
    public static farbenum gibAktuellerSpieler()
    {
        return aktuellerSpieler;
    }
    
    public static Brett gibBrett()
    {
        return Brett;
    }
    
    public static brettUI gibBrettUI()
    {
        return brettUI;
    }
    
    public static Wuerfel gibw1()
    {
        return w1;
    }
    
    public static void beginnendenSpielerSetzen(farbenum i)
    {
        beginnenderSpieler = i;
        aktuellerSpieler = i;
    }
    
    public void repaint()
    {
        brettUI.frame.repaint();
    }
    
    public static Spieler gibSpieler(farbenum f)
    {
        switch(f)
        {
            case Gelb:
                return Spieler[0];
            case Grün:
                return Spieler[1];
            case Rot:
                return Spieler[2];
            case Schwarz:
                return Spieler[3];
        }
        return null;
    }
    
    public static farbenum gibNaechsteFarbe(int i)
    {
        switch(i)
        {
            case 0:
                return farbenum.Grün;
            case 1:
                return farbenum.Rot;
            case 2:
                return farbenum.Schwarz;
            case 3:
                return farbenum.Gelb;
        }
        return null;
    }
    
    public static void naechsterZug() throws InterruptedException,java.io.IOException
    {
        w1.wUIgeben().close();
        aktuellerSpieler = gibNaechsteFarbe(aktuellerSpieler.ordinal());
        Spieler[aktuellerSpieler.ordinal()].spielzug();
    }
    
    public static void closeW2()
    {
        if(w2 != null)
        {
            w2.wUIgeben().close();
        }
    }
}