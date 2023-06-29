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
        Spieler[0] = new Spieler(farbenum.blau);
        Spieler[1] = new Spieler(farbenum.rot);
        Spieler[2] = new Spieler(farbenum.gruen);
        Spieler[3] = new Spieler(farbenum.schwarz);
        Brett = new Brett();
        w1 = new Wuerfel();
    }
    
    public int Wuerfeln()
    {
        // muss kurz updaten
        return w1.wuerfeln();
    }
}