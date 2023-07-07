public class Spieler

{
    private Figur[] figuren;
    private farbenum farbe;
    public Spieler(farbenum f)
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
    
    public void 
}