import java.util.Arrays;

public class Brett
{
    private Feld[] Felder;
    
    
    private Feld[] SchwarzStart;
    private Feld[] GruenStart;
    private Feld[] RotStart;
    private Feld[] GelbStart;
    
    
    private Feld[] HausSchwarz;
    private Feld[] HausGruen;
    private Feld[] HausRot;
    private Feld[] HausGelb;
    
    
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
            SchwarzStart[i] = new Feld(999, farbenum.schwarz);
            GruenStart[i] = new Feld(999, farbenum.gruen);
            RotStart[i] = new Feld(999, farbenum.rot);
            GelbStart[i] = new Feld(999, farbenum.gelb);
            HausSchwarz[i] = new Feld(999, farbenum.schwarz);
            HausGruen[i] = new Feld(999, farbenum.gruen);
            HausRot[i] = new Feld(999, farbenum.rot);
            HausGelb[i] = new Feld(999, farbenum.gelb);
        }
    }
}
