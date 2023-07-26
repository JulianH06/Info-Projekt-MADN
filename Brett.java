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
            HausSchwarz[i] = new Feld(80+1, farbenum.Schwarz);
            HausGruen[i] = new Feld(60+i, farbenum.Grün);
            HausRot[i] = new Feld(70+i, farbenum.Rot);
            HausGelb[i] = new Feld(50+i, farbenum.Gelb);
            
            HausGelb[i].KoordinatenSetzen(57+80*(i+2), 370 + 80);
            HausGruen[i].KoordinatenSetzen(545-80, 45+80*(i+2));
            HausSchwarz[i].KoordinatenSetzen(380+80, 860 - 80*(i+2));
            HausRot[i].KoordinatenSetzen(865 - 80*(i+2), 535-80);
        }
        
        GruenA = gibFeld(0);
        RotA = gibFeld(10);
        SchwarzA = gibFeld(20);
        GelbA = gibFeld(30);
        
        GelbStart[0].KoordinatenSetzen(55, 50);
        GelbStart[1].KoordinatenSetzen(135, 50);
        GelbStart[2].KoordinatenSetzen(55, 130);
        GelbStart[3].KoordinatenSetzen(135, 130);
        
        GruenStart[0].KoordinatenSetzen(55 + 735, 50);
        GruenStart[1].KoordinatenSetzen(135 + 735, 50);
        GruenStart[2].KoordinatenSetzen(55 + 735, 130);
        GruenStart[3].KoordinatenSetzen(135 + 735, 130);
        
        RotStart[0].KoordinatenSetzen(55 + 734, 50 + 730);
        RotStart[1].KoordinatenSetzen(135 + 737, 50 + 730);
        RotStart[2].KoordinatenSetzen(55 + 734, 130 + 730);
        RotStart[3].KoordinatenSetzen(872, 860);
        
        SchwarzStart[0].KoordinatenSetzen(54, 50 + 728);
        SchwarzStart[1].KoordinatenSetzen(137, 50 + 728);
        SchwarzStart[2].KoordinatenSetzen(54, 130 + 728);
        SchwarzStart[3].KoordinatenSetzen(137, 130 + 728);
        
        GruenA.KoordinatenSetzen(545, 45);
        RotA.KoordinatenSetzen(865, 535);
        SchwarzA.KoordinatenSetzen(380, 860);
        GelbA.KoordinatenSetzen(57, 370);
        
        Felder[9].KoordinatenSetzen(865, 535 - 80);
        Felder[19].KoordinatenSetzen(380 + 80, 860);
        Felder[29].KoordinatenSetzen(57, 370 + 80);
        Felder[39].KoordinatenSetzen(545-80, 45);
    }
    
    public static Feld gibFeld(int i)
    {
        return Felder[i];
    }
    
    public static Feld[] gibHausfeld(farbenum f)
    {
        switch(f)
        {
            case Gelb:
                return HausGelb;
            case Grün:
                return HausGruen;
            case Schwarz:
                return HausSchwarz;
            case Rot:
                return HausRot;
                   
        }
        return null;
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
    
    public static int gibHausEingang(farbenum f)
    {
        switch(f)
        {
            case Gelb:
                return 29;
            case Grün:
                return 39;
            case Schwarz:
                return 19;
            case Rot:
                return 9;
        }
        return 0;
    }
}
