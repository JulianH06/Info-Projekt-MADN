import java.util.Random;

public class Wuerfel
{
    public int wuerfeln()
    {
        int x = (int)(Math.random() * 6) + 1;
        return x;
    }
}

