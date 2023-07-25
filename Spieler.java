public class Spieler

{
    //
    private static Figur[] figuren;
    protected farbenum farbe;
    private figurauswahlUI fUI;
    
    public Spieler(farbenum f) throws java.io.IOException
    {
        figuren = new Figur[4];
        farbe = f;
        figuren[0] = new Figur(f);
        figuren[1] = new Figur(f);
        figuren[2] = new Figur(f);
        figuren[3] = new Figur(f);
    }
    
    public synchronized void spielzug() throws java.io.IOException,InterruptedException
    {
        int i = GameManager.Instance.ButtonWuerfel();
        System.out.println(i + " FROM " + farbe);
        fUI = new figurauswahlUI(farbe);
        int j = GameManager.Instance.ButtonFigur(farbe);
        ziehen(j,i);
    }
    
    public void ziehen(int nummer, int i) throws java.io.IOException,InterruptedException
    {
        if(figuren[nummer].gibPosTyp() == posenum.Start)
        {
            if(i != 6)
            {
                GameManager.naechsterZug();
                return;
            }else{
                Feld f = GameManager.gibBrett().gibA(farbe);
                if(f.Figurgeben() != null)
                {
                    if(f.Figurgeben().gibFarbe() == farbe)
                    {
                        ziehen(nummer, f.FeldnummerGeben() + 1);
                        figuren[nummer].startVerlassen();
                        return;
                    }
                    else
                    {
                        if(f.Figurgeben().gibFarbe() != null)
                        {
                            Figur a = f.Figurgeben();  
                            
                            //GameManager.gibBrettUI().ziehFigur(f, farbe, nummer);
                            a.reset();
                        }
                        
                    }
                }
                figuren[nummer].positionSetzen(f);
                f.Figursetzen(figuren[nummer]);
                GameManager.gibBrettUI().ziehFigur(f, farbe, nummer); 
                figuren[nummer].startVerlassen();
                GameManager.Instance.repaint();
                GameManager.naechsterZug();
                return;
            }
        }
        
        Feld f = figuren[nummer].ziehen(i);
        System.out.println(f.gibX() + " " + f.gibY());
        if(f.Figurgeben() != null)
        {
            if(f.Figurgeben().gibFarbe() == farbe)
            {
                ziehen(nummer, f.FeldnummerGeben() + 1);
                return;
            }
            else
            {
                if(f.Figurgeben().gibFarbe() != null)
                {
                    Figur a = f.Figurgeben();   
                    a.reset();
                }
                 //evtl. nicht im Feld implementiert
            }
        }
        figuren[nummer].positionSetzen(f);
        f.Figursetzen(figuren[nummer]);
        GameManager.gibBrettUI().ziehFigur(f, farbe, nummer); 
        GameManager.Instance.repaint();
        GameManager.naechsterZug();
        return;
    }    
    
    public figurauswahlUI gibfUI()
    {
        return fUI;
    }
    
    public farbenum gibFarbe()
    {
        return farbe;
    }
    
    public static Figur gibFigur(int i)
    {
        return figuren[i];
    }
    
    public synchronized void notifySpieler()
    {
        notifyAll();
    }
}