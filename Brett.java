import java.util.Arrays;

public class Brett
{
    private static Feld[] Felder;
    
    
    private static Feld[] SchwarzStart;
    private static Feld[] GruenStart;
    private static Feld[] RotStart;
    private static Feld[] GelbStart;
    
    
    private static Feld[] HausSchwarz;
    private static Feld[] HausGruen;
    private static Feld[] HausRot;
    private static Feld[] HausGelb;
    
    
    public void Brett()
    {
        Felder= new Feld[40];
        SchwarzStart = new Feld[4];
        GruenStart = new Feld[4];
        RotStart = new Feld[4];
        GelbStart = new Feld[4];
        HausSchwarz = new Feld[4];
        HausGruen = new Feld[4];
        HausRot = new Feld[4];
        HausGelb = new Feld[4];
        
        for(int i=0;i<Felder.length;i++)
        {
            Felder[i] = new Feld(i, null);
        }
        
        for(int i = 0;i<4; i++)
        {
            SchwarzStart[i] = new Feld(999, farbenum.Schwarz);
            GruenStart[i] = new Feld(999, farbenum.Grün);
            RotStart[i] = new Feld(999, farbenum.Rot);
            GelbStart[i] = new Feld(999, farbenum.Gelb);
            HausSchwarz[i] = new Feld(999, farbenum.Schwarz);
            HausGruen[i] = new Feld(999, farbenum.Grün);
            HausRot[i] = new Feld(999, farbenum.Rot);
            HausGelb[i] = new Feld(999, farbenum.Gelb);
        }
    }
    
    public static Feld gibFeld(int i)
    {
        return Felder[i];
    }
    
    public static Feld gibStartfeld(farbenum f)
    {
        switch(f)
        {
            case Gelb:
                for(int i = 0; i < 4; i++)
                {
                    if(HausGelb[i] != null)
                    {
                        return HausGelb[i];
                    }
                }
        }
        return null;
        //muss ich noch fertig machen -Julian
    }
}
