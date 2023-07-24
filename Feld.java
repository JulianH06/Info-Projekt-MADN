public class Feld
{
    private int Feldnummer;
    private Figur Figur = null;
    private boolean besetzt;
    private farbenum farbe; 
    private int x, y;
    
    public Feld(int i, farbenum f)
    {
        Feldnummer = i;
        besetzt = false;
        farbe = f;
    }
    
    public Feld(int i, farbenum f, int x, int y)
    {
        Feldnummer = i;
        besetzt = false;
        farbe = f;
        this.x = x;
        this.y = y;
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
    
    public static int AbzweigungGeben(farbenum f)
    {
        /*switch(f)
        {
            case Gelb:
                return Brett.gibFeld(9);
            case Grün:
                return Brett.gibFeld(19);
            case Rot:
                return Brett.gibFeld(29);
            case Schwarz:
                return Brett.gibFeld(39);
        }
        System.out.println("abzweigung funktioniert nicht 0 wird ausgegeben");
        return null;*/
        return 0;
    }
    
    public void KoordinatenSetzen(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int gibX()
    {
        return x;
    }
    
    public int gibY()
    {
        return y;
    }
}
