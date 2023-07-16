public class GameManager
{
    public static GameManager Instance;
    private static Brett Brett;
    private static Spieler[] Spieler;
    private static Wuerfel w1;
    private static UI UI;
    
    GameManager() throws java.io.IOException
    {
        Instance = this; //wird evntl. noch gelöscht falls nicht nötig
        
        //erstellt die spieler und weißt ihnen eine farbe zu
        Spieler = new Spieler[4];
        Spieler[0] = new Spieler(farbenum.gelb);
        Spieler[1] = new Spieler(farbenum.gruen);
        Spieler[2] = new Spieler(farbenum.schwarz);
        Spieler[3] = new Spieler(farbenum.rot);
        
        //erstellt Brett und öffnet das UI Fenster
        Brett = new Brett();
        new brettUI();
        
        //erstellt Wuerfel und öffnet das UI Fenster
        w1 = new Wuerfel();
        ButtonWuerfel();
    }
    
    public static int Wuerfeln()
    {
        return w1.wuerfeln();
    }
    
    public static int ButtonWuerfel() throws java.io.IOException
    {
        new wuerfelUI(); //frame() ignorieren, brauch ich nur kurz zum testen
        //öffne fenster mit k+nopf
        //knopf aktiviert wuerfeln()
        //weert wird tueücskgegeben
        //System.out.println("methode ButtonWuerfel noch nicht implementiert," +
        //                    "0 wird ausgegeben");
        return 0;
    }
    
    public static int ButtonFigur()
    {
        //NOCH NICHT FERTIG!!!
        System.out.println("methode ButtonFigur noch nicht implementiert," +
                            "0 wird ausgegeben");
        return 0;
    }
}