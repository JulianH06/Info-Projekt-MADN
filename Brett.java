import java.util.Arrays;

public class Brett
{
    private Feld[] Felder;
    private int laenge = 40;
    
    
    private Feld[] BlauStart;
    
    private Feld[] GruenStart;
    
    private Feld[] RotStart;
    
    private Feld[] GelbStart;
    
    
    private Feld[] BlauEnde;
    
    private Feld[] GrünEnde;
    
    private Feld[] RotEnde;
    
    private Feld[] GelbEnde;
    
    
    public void Brett()
    {
        Felder= new Feld[40];

        
        for(int i=0;i<laenge;i++)
        {
            Felder[i] = new Feld(i);
        }
    }
    //heimatfelder mit 4 feld arrays erstellen und Farben zuweisen
    //startfelder mit feld array und farbe
}
