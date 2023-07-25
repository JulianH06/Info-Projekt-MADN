import java.util.Random;

public class Wuerfel
{
    private wuerfelUI wUI;
    
    public Wuerfel() throws java.io.IOException
    {
        wUI = new wuerfelUI();
    }
    
    public int wuerfeln()
    {
        int x = (int)(Math.random() * 6) + 1;
        return x;
    }
    
    public wuerfelUI wUIgeben()
    {
        return wUI;
    }
}

