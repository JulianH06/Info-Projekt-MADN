public class Figur
{
    private Feld startfeld;
    private Feld position;
    private farbenum farbe;
    private int figurnummer;
    private boolean inStart = true;
    private posenum postyp;
    
    public Figur(farbenum f)
    {
        startfeld = Brett.gibStartfeld(f);
        position = startfeld;
        postyp = posenum.Start;
    }
    
    //Mechanik zum Verlassen des Startfeldes fehlt
    
    public void positionSetzen(Feld f)
    {
        position = f;
        inStart = false;
    }
    
    public void reset()
    {
        position = Brett.gibStartfeld(farbe);
    }
    
    public boolean insHausZiehen(int i)
    {
        //Implementierung fehlt!
        return true;
    }
    
    public Feld ziehen(int i)
    {
        if(!inStart)
        {
            int p = position.FeldnummerGeben()+i;
            if(p>39)
            {
                p = p - 40;
            } 
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
            
            //else                                                                                                                            //
            //{
                return Brett.gibFeld(p);
            //} 
        }
        else
        {
                   
        }
        return null;
    }
    
    public farbenum gibFarbe()
    {
        return farbe;
    }
    
    public posenum gibPosTyp()
    {
        return postyp;
    }
    
    public void startVerlassen()
    {
        postyp = posenum.Normal;
        inStart = false;
    }
}