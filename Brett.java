import java.util.LinkedList;
public class Brett
{
    private LinkedList Liste;
    private int laenge = 40;
    public void Brett()
    {
        Liste = new LinkedList();
         
        int i=0;
        for(i=0;i<laenge;i++)
        {
            Liste.add(new Feld(i));
        }
    }
    
}
