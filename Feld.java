public class Feld
{
    //Notiz für Henrik und Jan: jedes feld wird einzeln auf den bildschirm gezeichnet
    //jedes feld hat koordinaten, auf die es dann gezeichnet wird
    //Jpanel oder JFrame ich weiß ichnt mehr genau was aber das anschauen und dafür benutzen
    //im konstruktor von feld an den koordinaten damit dann zeichnen

    int Feldnummer;
    Figur Figur;
    private Feld nachfolger;
    private boolean besetzt;
    private farbenum farbe; 
    public Feld(int i, farbenum f)
    {
        Feldnummer = i;
        besetzt = false;
        farbe = f ;
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
    
    //notiz an tobi und gabo: hab das gemacht nicht wundern hab das kurz
    //gebraucht -julian
    public Figur Figurgeben()
    {
        return Figur;
    }
    
    //notiz an tobi und gabo: hab das gemacht nicht wundern hab das kurz
    //gebraucht -julian
    public int FeldnummerGeben()
    {
        return Feldnummer;
    }
    public void Figursetzen(Figur f )
    {
        Figur = f;
    }
    public Feld geben()
    {
        return this;
    }
}
