import javax.swing.JFrame;

public class JFrame1
{
    public static void main(String[] arg)
    {
        JFrame frame = new JFrame("ABC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
