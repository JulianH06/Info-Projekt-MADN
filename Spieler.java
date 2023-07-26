public class Spieler

{
    //
    private Figur[] figuren;
    protected farbenum farbe;
    private figurauswahlUI fUI;
    private boolean alleImHaus = true;
    private boolean zweimalgew = false;
    private boolean dreimalgew = false;
    private wuerfelUI w2;
    
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
        alleImHaus = true;
        for(int i = 0; i < 4; i++)
        {
            if(!figuren[i].inStart())
            {
                alleImHaus = false;    
            }
        }
        int i = GameManager.Instance.ButtonWuerfel();
        if(i < 6)
        {
            if(alleImHaus)
            {
                if(!zweimalgew)
                {
                    i = GameManager.Instance.zweitwuerfeln();
                }
                if(i != 6 && !dreimalgew)
                {
                    i = GameManager.Instance.drittwuerfeln();
                }
            }
        }
        if(i == 6)
        {
            w2 = GameManager.gibw1().wUIgeben();
            w2.frame.setLocation(1100, 0);
            i += GameManager.Instance.ButtonWuerfel();
            GameManager.gibw1().wUIgeben().frame.setLocation(1400, 0);
        }
        GameManager.Instance.notifyGM();
        System.out.println(i + " FROM " + farbe);
        if(!alleImHaus || i >= 6)
        {
            fUI = new figurauswahlUI(farbe);
            int j = GameManager.Instance.ButtonFigur(farbe);
            ziehen(j,i);
        }
        else
        {
            int j = 0;
            ziehen(j,i);
        }
    }
    
    public void ziehen(int nummer, int i) throws java.io.IOException,InterruptedException
    {
        if(w2 != null)
        {
            w2.close();
            w2 = null;
        }
        zweimalgew = false;
        dreimalgew = false;
        if(figuren[nummer].inStart() == true)
        {
            if(i < 6)
            {
                GameManager.naechsterZug();
            }else{
                Feld f = figuren[nummer].ziehen(GameManager.gibBrett()
                .gibA(farbe).FeldnummerGeben() + i-6);
                if(f.istBesetzt() != false)
                {
                    if(f.Figurgeben().gibFarbe() != farbe)
                    {
                        if(f.Figurgeben().gibFarbe() != null)
                        {
                            f.Figurgeben().reset();
                        }
                    }
                }
                zweimalgew = false;
                dreimalgew = false;
                figuren[nummer].positionSetzen(f);
                f.Figursetzen(figuren[nummer]);
                GameManager.gibBrettUI().ziehFigur(f, farbe, nummer); 
                GameManager.Instance.repaint();
                GameManager.naechsterZug();
                return;
            }
        }
        
        if(figuren[nummer].inHaus() == true)
        {
            System.out.println(farbe + " i");
            System.out.println(farbe + "IM HAUS");
            System.out.println(figuren[nummer].gibPosImHaus());
            switch(figuren[nummer].gibPosImHaus())
            {
                case 0:
                    if(i > 3)
                    {
                        System.out.println(farbe + "Pos 0, i > 3, weiter");
                        GameManager.naechsterZug();
                        break;
                    }
                    if(Brett.gibHausfeld(farbe)[i].istBesetzt())
                    {
                        GameManager.naechsterZug();
                        break;
                    }
                    else
                    {
                        System.out.println(farbe + "Pos 0, i < 3, gezogen auf " + Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        figuren[nummer].posImHausSetzen(i);
                        zweimalgew = false;
                        dreimalgew = false;
                        figuren[nummer].gibPosition().Figursetzen(null);
                        figuren[nummer].positionSetzen(Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        GameManager.gibBrettUI().ziehFigur(Brett.gibHausfeld(farbe)[i]
                        , farbe, nummer); 
                        GameManager.Instance.repaint();
                        GameManager.naechsterZug();
                        return;
                    }
                case 1:
                    if(i > 2)
                    {
                        System.out.println(farbe + "Pos 1, i > 2, weiter");
                        GameManager.naechsterZug();
                        break;
                    }
                    if(Brett.gibHausfeld(farbe)[i].istBesetzt())
                    {
                        System.out.println(farbe + "Pos 1, IST BESETZT");
                        GameManager.naechsterZug();
                        break;
                    }
                    else
                    {
                        System.out.println(farbe + "Pos 1, i < 2, gezogen auf " + Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        figuren[nummer].posImHausSetzen(i);
                        zweimalgew = false;
                        dreimalgew = false;
                        figuren[nummer].gibPosition().Figursetzen(null);
                        figuren[nummer].positionSetzen(Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        GameManager.gibBrettUI().ziehFigur(Brett.gibHausfeld(farbe)[i]
                        , farbe, nummer); 
                        GameManager.Instance.repaint();
                        GameManager.naechsterZug();
                        return;
                    }
                case 2:
                    if(i > 1)
                    {
                        System.out.println(farbe + " Pos 2, i > 1, weiter");
                        GameManager.naechsterZug();
                    }
                    if(Brett.gibHausfeld(farbe)[i].istBesetzt())
                    {
                        GameManager.naechsterZug();
                    }
                    else
                    {
                        System.out.println(farbe + "Pos 2, i < 1, gezogen auf " + Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        figuren[nummer].posImHausSetzen(i);
                        zweimalgew = false;
                        dreimalgew = false;
                        figuren[nummer].gibPosition().Figursetzen(null);
                        figuren[nummer].positionSetzen(Brett.
                        gibHausfeld(farbe)[figuren[nummer].gibPosImHaus() + i]);
                        GameManager.gibBrettUI().ziehFigur(Brett.gibHausfeld(farbe)[i]
                        , farbe, nummer); 
                        GameManager.Instance.repaint();
                        GameManager.naechsterZug();
                        return;
                    }
                default:
                    GameManager.naechsterZug();
                    return;
            }
        }
        
        Feld f = figuren[nummer].ziehen(i);
        if(f.istBesetzt() != false)
        {
            if(f.Figurgeben().gibFarbe() != null)
            {
                if(f.Figurgeben().gibFarbe() != farbe)
                {
                    f.Figurgeben().reset();
                }
            }
        }
        zweimalgew = false;
        dreimalgew = false;
        figuren[nummer].gibPosition().Figursetzen(null);
        figuren[nummer].positionSetzen(f);
        f.Figursetzen(figuren[nummer]);
        if(figuren[nummer].gibAbzweigungImHaus() == true && i > 0 && i <= 4 && figuren[nummer].gibPosImHaus() <= 4)
        {
            GameManager.gibBrettUI().ziehFigur(
            Brett.gibHausfeld(farbe)[(figuren[nummer].gibPosImHaus())], 
            farbe, figuren[nummer]);
            GameManager.Instance.repaint();
            GameManager.naechsterZug();
            return;
        }
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
    
    public Figur gibFigur(int i)
    {
        return figuren[i];
    }
    
    public synchronized void notifySpieler()
    {
        notifyAll();
    }
    
    public boolean alleImHaus()
    {
        return alleImHaus;
    }
    
    public void zweiMalGewuerfelt()
    {
        zweimalgew = true;
    }
    
    public void dreiMalGewuerfelt()
    {
        dreimalgew = true;
    }
}