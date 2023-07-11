public class Feld
{
    private int Feldnummer;
    private Figur Figur;
    private boolean besetzt;
    private farbenum farbe; 
    
    public Feld(int i, farbenum f)
    {
        Feldnummer = i;
        besetzt = false;
        farbe = f;
    }
    
    public boolean istBesetzt()
    {
        if (besetzt == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Figur Figurgeben()
    {
        return Figur;
    }
    
    public int FeldnummerGeben()
    {
        return Feldnummer;
    }
    
    public void Figursetzen(Figur f )
    {
        Figur = f;
    }
}
