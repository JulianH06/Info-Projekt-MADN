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
    public Feld(int i)
    {
        Feldnummer = i;
        besetzt = false;
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
    
    

    public Feld geben()
    {
        return this;
    }
}
