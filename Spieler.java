public class Spieler

{
    //
    private Figur[] figuren;
    private farbenum farbe;
    public Spieler(farbenum f)
    {
        figuren = new Figur[4];
        farbe = f;
        figuren[0] = new Figur(f);
        figuren[1] = new Figur(f);
        figuren[2] = new Figur(f);
        figuren[3] = new Figur(f);
    }
    
    public void spielzug()
    {
        int i = GameManager.Instance.ButtonWuerfel();
        int j = GameManager.Instance.ButtonFigur();
        ziehen(j,i);
    }
    
    public void ziehen(int nummer, int i)
    {
        Feld f = figuren[nummer].ziehen(i);
        if(f.Figurgeben().gibFarbe() == farbe)
        {
            ziehen(f.FeldnummerGeben(),1);
        }
        else
        {
            if(f.Figurgeben().gibFarbe() != null)
            {
                Figur a = f.Figurgeben();   
                a.reset();
            }
            figuren[nummer].positionSetzen(f);
            f.Figursetzen(figuren[nummer]); //evtl. nicht im Feld implementiert
        }
    }    
}