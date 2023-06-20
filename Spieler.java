public class Spieler
{
    private Figur[] figuren;
    private int farbe;
    public Spieler(int f)
    {
        figuren = new Figur[4];
        farbe = f;
        figuren[0] = new Figur(null);
        figuren[1] = new Figur(null);
        figuren[2] = new Figur(null);
        figuren[3] = new Figur(null);
    }
}