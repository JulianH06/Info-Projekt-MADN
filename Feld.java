public class Feld
{
    //Notiz für Henrik und Jan: jedes feld wird einzeln auf den bildschirm gezeichnet
    //jedes feld hat koordinaten, auf die es dann gezeichnet wird
    //Jpanel oder JFrame ich weiß ichnt mehr genau was aber das anschauen und dafür benutzen
    //im konstruktor von feld an den koordinaten damit dann zeichnen
    
    int Feldnummer;
    Figur Figur;
    private Feld nachfolger;
    public Feld(int i, Feld x)
    {
        Feldnummer = i;
        Feld = nachfolger;
    }
    
    public Feld geben()
    {
        return this;
    }
}
