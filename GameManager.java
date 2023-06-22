public class GameManager
{
    public static GameManager Instance;
    private Brett Brett;
    private Spieler[] Spieler;
    private Wuerfel w1;
    
    GameManager()
    {
        Instance = this;
        Spieler = new Spieler[4];
        Brett = new Brett();
        w1 = new Wuerfel();
    }
    
    public int Wuerfeln()
    {
        // muss kurz updaten
        return w1.wuerfeln();
    }
}