public class Figur
{
    private Feld startfeld;
    private Feld position;
    private farbenum farbe;
    private int figurnummer;
    private boolean inStart = true;
    private boolean inHaus = false;
    private int positionImHaus = 111;
    //private posenum postyp;
    boolean abzweigungAufStrecke = false;
    
    public Figur(farbenum f)
    {
        farbe = f;
        startfeld = Brett.gibStartfeld(f);
        position = startfeld;
        //postyp = posenum.Start;
    }
    
    //Mechanik zum Verlassen des Startfeldes fehlt
    
    public void positionSetzen(Feld f)
    {
        position = f;
        inStart = false;
    }
    
    public Feld gibPosition()
    {
        return position;
    }
    
    public void reset()
    {
        position = startfeld;
        inStart = true;
        GameManager.gibBrettUI().ziehFigur(startfeld, farbe, this);
    }
    
    public boolean insHausZiehen(int i)
    {
        //Implementierung fehlt!
        return true;
    }
    
    public Feld ziehen(int i)
    {
        int e = Brett.gibHausEingang(farbe);
        //if(position = 
        //System.out.println(position.gibX() + " " + position.gibY());
        int p = position.FeldnummerGeben()+i;
        System.out.println("p ist " + p);
        System.out.println("e ist " + e);
        System.out.println("position ist " + position.FeldnummerGeben());
        
        if(inStart)
        {
            return Brett.gibFeld(p);
        }
        if(inHaus)
        {
            System.out.println("IM HAUS");
        }
        if(position.FeldnummerGeben() != e)
        {
            int k = 0;
            for(int j = position.FeldnummerGeben(); j <= p; j++)
            {
                if(j == e)
                {
                    System.out.println("abzweigungAufStrecke");
                    abzweigungAufStrecke = true;
                    k = p - e;
                    
                    System.out.println(k);
                    if(k > 0 && k <= 4)
                    {
                        System.out.println("k >= 0 && k <= 4 IN HAUS IST TRUE");
                        inHaus = true;
                        positionImHaus = k-1;
                        return Brett.gibHausfeld(farbe)[k-1];
                    }
                    return Brett.gibFeld(e);
                }
            }
        }
        else if(position.FeldnummerGeben() == e)
        {
            if(i >= 0 && i <= 4)
            {
                System.out.println("i >= 0 && i <= 4 IN HAUS IST TRUE");
                inHaus = true;
                positionImHaus = i;
                return Brett.gibHausfeld(farbe)[i-1];
            }
            else
            {
                return Brett.gibFeld(e);
            }
        }
        else
        {
            return Brett.gibFeld(e);
        }
        
        /*if(abzweigungAufStrecke)
        {
            for(int j = position.FeldnummerGeben(); j < p; j++)
            {
                if(j == p)
                {
                    abzweigungAufStrecke = true;
                }
            }
        }
        else
        {
            return Brett.gibFeld(p);
        }*/
        // /* 
        // if(position.FeldnummerGeben()<Feld.AbzweigungGeben(farbe)/*.FeldnummerGeben()*/ && p>Feld.AbzweigungGeben(farbe)/*.FeldnummerGeben()*/) //wenn pos vor < Abzweigung und pos nach > Abzweigung
        // /*{
            // return null;//insHausZiehen(p-Feld.AbzweigungGeben(farbe).FeldnummerGeben());
        // }
        // else if(p<i && Feld.AbzweigungGeben(farbe)/*.FeldnummerGeben()*/>position.FeldnummerGeben())                                                                 //
        // /*{
            // return null;//insHausZiehen(39-Feld.AbzweigungGeben(farbe).FeldnummerGeben()+p);
        // }
        // else if(p<i && Feld.AbzweigungGeben(farbe)/*.FeldnummerGeben()*/<position.FeldnummerGeben())                                                                        //
        // /*{
            // return null;//insHausZiehen(p-Feld.AbzweigungGeben(farbe).FeldnummerGeben());
        // }*/
        
        if(p>39)
        {
            p = p - 40;
        } 
        //else                                                                                                                            //
        //{
            
        //} 
        return Brett.gibFeld(p);
    }
    
    public Feld ziehen(int i, Feld f)
    {
        position = f;
        return ziehen(i);
    }
    
    public farbenum gibFarbe()
    {
        return farbe;
    }
    
    public posenum gibPosTyp()
    {
        return null;//postyp;
    }
    
    public void startVerlassen()
    {
        //postyp = posenum.Normal;
        inStart = false;
    }
    
    public boolean inStart()
    {
        return inStart;
    }
    
    public boolean inHaus()
    {
        return inHaus;
    }
    
    public int gibPosImHaus()
    {
        return positionImHaus;
    }
    
    public void posImHausSetzen(int i)
    {
        i = positionImHaus;
    }
    
    public boolean gibAbzweigungImHaus()
    {
        return abzweigungAufStrecke;
    }
}