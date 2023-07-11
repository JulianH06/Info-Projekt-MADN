import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.File;
import javax.imageio.ImageIO;

public class UI
{
    static JLabel label1 = new JLabel("Spieler Würfelt...");
    static JFrame frame;
    private static ImageIcon Bild;
    
    public static void main(String[] arg) throws java.io.IOException
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1300,400);
        frame.setVisible(true);
        frame.setSize(600,700);
        
        frame.add(label1);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.TOP);
        label1.setFont(label1.getFont().deriveFont(18f));
        
        Bild = new ImageIcon(ImageIO.read(new File("wuerfel.jpg")));
        frame.add(new JLabel(Bild));
    }
}
