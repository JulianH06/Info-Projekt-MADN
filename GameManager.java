public class GameManager
{
    private static GameManager Instance;
    private Brett Brett;
    private Spieler[] Spieler;
    
    GameManager()
    {
        Instance = this;
        Spieler = new Spieler[4];
        Brett = new Brett();
    }
}