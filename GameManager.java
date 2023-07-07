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
    
    public int ButtonWuerfel()
    {
        //öffne fenster mit k+nopf
        //knopf aktiviert wuerfeln()
        //weert wird tueücskgegeben
        System.out.println("methode ButtonWuerfel noch nicht implementiert," +
                            "0 wird ausgegeben");
        return 0;
    }
    
    public int ButtonFigur()
    {
        System.out.println("methode ButtonFigur noch nicht implementiert," +
                            "0 wird ausgegeben");
        return 0;
    }
}