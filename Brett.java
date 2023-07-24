import java.util.Arrays;

public class Brett
{
    private static Feld[] Felder;
    
    private static Feld[] SchwarzStart;
    private static Feld[] GruenStart;
    private static Feld[] RotStart;
    private static Feld[] GelbStart;
    
    private static Feld SchwarzA;
    private static Feld GruenA;
    private static Feld RotA;
    private static Feld GelbA;
    
    private static Feld[] HausSchwarz;
    private static Feld[] HausGruen;
    private static Feld[] HausRot;
    private static Feld[] HausGelb;
    
    
    public Brett()
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
            SchwarzStart[i] = new Feld(0, farbenum.Schwarz);
            GruenStart[i] = new Feld(0, farbenum.Grün);
            RotStart[i] = new Feld(0, farbenum.Rot);
            GelbStart[i] = new Feld(0, farbenum.Gelb);
            HausSchwarz[i] = new Feld(0, farbenum.Schwarz);
            HausGruen[i] = new Feld(0, farbenum.Grün);
            HausRot[i] = new Feld(0, farbenum.Rot);
            HausGelb[i] = new Feld(0, farbenum.Gelb);
        }
        
        GruenA = gibFeld(0);
        RotA = gibFeld(10);
        SchwarzA = gibFeld(20);
        GelbA = gibFeld(30);
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
                    if(GelbStart[i] != null && GelbStart[i].Figurgeben() == null)
                    {
                        return GelbStart[i];
                    }
                }
            case Grün:
                for(int i = 0; i < 4; i++)
                {
                    if(GruenStart[i] != null && GruenStart[i].Figurgeben() == null)
                    {
                        return GruenStart[i];
                    }
                }
            case Schwarz:
                for(int i = 0; i < 4; i++)
                {
                    if(SchwarzStart[i] != null && SchwarzStart[i].Figurgeben() == null)
                    {
                        return SchwarzStart[i];
                    }
                }
            case Rot:
                for(int i = 0; i < 4; i++)
                {
                    if(RotStart[i] != null && RotStart[i].Figurgeben() == null)
                    {
                        return RotStart[i];
                    }
                }
        }
        return null;
        //muss ich noch fertig machen -Julian
    }
    
    public Feld gibA(farbenum f)
    {
        switch(f)
        {
            case Gelb:
                return GelbA;
            case Grün:
                return GruenA;
            case Schwarz:
                return SchwarzA;
            case Rot:
                return RotA;
        }
        return null;
    }
}
