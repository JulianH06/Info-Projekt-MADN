public class GameManager
{
    public static GameManager Instance;
    private static Brett Brett;
    private static Spieler[] Spieler;
    private static Wuerfel w1;
    
    
    GameManager()
    {
        Instance = this;
        Spieler = new Spieler[4];
        Spieler[0] = new Spieler(farbenum.gelb);
        Spieler[1] = new Spieler(farbenum.gruen);
        Spieler[2] = new Spieler(farbenum.schwarz);
        Spieler[3] = new Spieler(farbenum.rot);
        Brett = new Brett();
        w1 = new Wuerfel();
    }
    
    public static int Wuerfeln()
    {
        // muss kurz updaten
        return w1.wuerfeln();
    }
    
    public static int ButtonWuerfel()
    {
        //öffne fenster mit k+nopf
        //knopf aktiviert wuerfeln()
        //weert wird tueücskgegeben
        System.out.println("methode ButtonWuerfel noch nicht implementiert," +
                            "0 wird ausgegeben");
        return 0;
    }
    
    public static int ButtonFigur()
    {
        System.out.println("methode ButtonFigur noch nicht implementiert," +
                            "0 wird ausgegeben");
        return 0;
    }
}