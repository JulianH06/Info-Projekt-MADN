public class Spieler

{
    private Figur[] figuren;
    private farbenum farbe;
    public Spieler(farbenum f)  //muss noch 
    {
        figuren = new Figur[4];
        farbe = f;
        figuren[0] = new Figur(f);
        figuren[1] = new Figur(f);
        figuren[2] = new Figur(f);
        figuren[3] = new Figur(f);
    }
    
    public void spielzug() throws java.io.IOException
    {
        int i = GameManager.Instance.ButtonWuerfel();
        int j = GameManager.Instance.ButtonFigur();
        ziehen(j,i);
    }
    
    public void ziehen(int nummer, int i)
    {
        Feld f = figuren[nummer-1].ziehen(i);
        if(f.Figurgeben().gibFarbe() == farbe)
        {
            ziehen(f.FeldnummerGeben(),1);   //evtl. Feldnummer+1 ; kommt auf Implemetierung im Feld an
        }
        else
        {
            if(f.Figurgeben().gibFarbe() != null)
            {
                Figur a = f.Figurgeben();   //evtl. noch nicht implementiert
                a.reset();
            }
            figuren[nummer-1].positionSetzen(f);
            //f.FigurSetzen(figuren[nummer-1]);       //evtl. noch nicht implementiert
        }
    }
     
}