
public class Brett
{
    private Feld[] Felder;
    private int laenge = 40;
    
  
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
