public class Spieler

{
    private Figur[] figuren;
    private int farbe;
    public Spieler(int f,Feld Startfeld)
    {
        figuren = new Figur[4];
        farbe = f;
        figuren[0] = new Figur(null);
        figuren[1] = new Figur(null);
        figuren[2] = new Figur(null);
        figuren[3] = new Figur(null);
    }
    
    public void ziehen(int non, int i)
    {
        Feld j =figuren[non-1].ziehen(i);
        
    }
}