public class Figur
{
    //
    private Feld startfeld;
    private Feld position;
    private farbenum farbe;
    public Figur(farbenum f)
    {
        startfeld = Brett.gibStartfeld(f); //evtl. nicht im Brett implementiert
        position = startfeld;
    }
    
    //Mechanik zum Verlassen des Startfeldes fehlt
    
    public void positionSetzen(Feld f)
    {
        position = f;
    }
    
    public void reset()
    {
        position = startfeld;
    }
    
    public boolean insHausZiehen(int i)
    {
        //Implementierung fehlt!
        return true;
    }
    
    public Feld ziehen(int i)
    {
        int p = position.FeldnummerGeben()+i;
        if(p>39)
            p = p - 40;
        if(position.FeldnummerGeben()<Feld.AbzweigungGeben(farbe).FeldnummerGeben() && p>Feld.AbzweigungGeben(farbe).FeldnummerGeben()) //wenn pos vor < Abzweigung und pos nach > Abzweigung
        {
            return null;//insHausZiehen(p-Feld.AbzweigungGeben(farbe).FeldnummerGeben());
        }
        else if(p<i && Feld.AbzweigungGeben(farbe).FeldnummerGeben()>position.FeldnummerGeben())                                                                 //
        {
            return null;//insHausZiehen(39-Feld.AbzweigungGeben(farbe).FeldnummerGeben()+p);
        }
        else if(p<i && Feld.AbzweigungGeben(farbe).FeldnummerGeben()<position.FeldnummerGeben())                                                                        //
        {
            return null;//insHausZiehen(p-Feld.AbzweigungGeben(farbe).FeldnummerGeben());
        }
        else                                                                                                                            //
        {
            return Brett.gibFeld(p);
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    }
    
    public farbenum gibFarbe()
    {
        return farbe;
    }
}