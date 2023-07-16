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
    
    public static Feld AbzweigungGeben(farbenum f)
    {
        switch(f)
        {
            case gelb:
                return Brett.gibFeld(9);
            case gruen:
                return Brett.gibFeld(19);
            case rot:
                return Brett.gibFeld(29);
            case schwarz:
                return Brett.gibFeld(39);
        }
        System.out.println("abzweigung funktioniert nicht 0 wird ausgegeben");
        return 0;
    }
}
