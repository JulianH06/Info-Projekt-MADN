import java.util.LinkedList;
public class Brett
{
    private LinkedList Liste;
    private int laenge = 40;
    public void Brett()
    {
        private Feld nachfolger;
        Liste = new LinkedList();

        int i=0;
        for(i=0;i<laenge;i++)
        {
            int x = 0;
            if(i < 40)
            {
                x = i +1;
            }
            Liste.add(new Feld(i,x));
        }
    }

}
