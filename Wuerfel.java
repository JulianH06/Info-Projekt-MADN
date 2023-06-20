import java.util.Random;

public class Wuerfel
{
    public void wuerfeln()
    {
        int x = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        System.out.println(x);
    }
    
    public boolean startwurfeln()
    {
        int x = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        if(x == 6)
        {
            return true;
        }
        int y = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        if(y == 6)
        {
            return true;
        }
        int z = (int)(Math.random() * ((6 - 1) + 1)) + 1;
        if(z == 6)
        {
            return true;
        }
        return false;
    }
}

